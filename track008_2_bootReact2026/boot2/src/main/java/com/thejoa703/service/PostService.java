package com.thejoa703.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.PostDto.PostRequestDto;
import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Hashtag;
import com.thejoa703.entity.Image;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.HashtagRepository;
import com.thejoa703.repository.PostRepository;
import com.thejoa703.util.FileStorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final AppUserRepository appUserRepository;
    private final HashtagRepository hashtagRepository;
    private final FileStorageService fileStorageService;

    // 1. 전체 게시글 조회
    public List<Post> getAllPosts() {
        return postRepository.findByDeletedFalse();
    }

    // 2. 게시글 단건 조회(Entity 반환)
    public Post getPostById(Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 게시글입니다. ID : " + id));

        if (post.isDeleted()) {
            throw new IllegalArgumentException("삭제된 게시글입니다.");
        }

        return post;
    }

    // 2-1. 게시글 단건 조회(DTO 반환)
    public PostResponseDto getPost(Long id) {

        Post post = getPostById(id);

        return new PostResponseDto(post);
    }

    // 3. 오라클 네이티브 페이징 조회
    public List<Post> getPostPaged(int start, int end) {
        return postRepository.findPostsWithPaging(start, end);
    }

    // 4. 게시글 작성
    @Transactional
    public PostResponseDto createPost(Long userId, PostRequestDto dto, List<MultipartFile> files) {

        AppUser user = appUserRepository.findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 사용자입니다. ID : " + userId));

        Post post = new Post();
        post.setContent(dto.getContent());
        post.setUser(user);
        
        //이미지 업로드
        if(files !=null && !files.isEmpty()) {
        	files.forEach( file->{
        		String url=fileStorageService.upload(file);
        		Image image=new Image();
        		image.setSrc(url);
        		image.setPost(post);
        		post.getImages().add(image);
        	});
        }
        
        //해쉬태그 (1.겹치면 안됨 2.#해쉬 #first #태그)
        if(dto.getHashtags() != null && !dto.getHashtags().isEmpty()) {
            Set<String> distinctTags = Arrays.stream(dto.getHashtags().split(",")) //1. ,기준으로 분리해서 배열을 스트링
                    .map(String::trim)   
                    .filter(s -> !s.isEmpty())  //빈값은 버려라
                    .collect(Collectors.toSet());// 콜렉션 프레임워크,겹치는 값이 있으면 안됨. (중복을 허용하지 않는 보관함)
            
            distinctTags.forEach(tagStr -> {
                String normalized = tagStr.startsWith("#") ? tagStr.substring(1) : tagStr;
                Hashtag tag = hashtagRepository.findByName(normalized)
                        .orElseGet(() -> {
                            Hashtag newTag = new Hashtag();
                            newTag.setName(normalized);
                            return hashtagRepository.save(newTag);
                        });
                post.getHashtags().add(tag);
            });
        }

        return PostResponseDto.from(postRepository.save(post) );
    }

    // 5. 게시글 수정
    @Transactional
    public PostResponseDto updatePost(Long userId,Long postId, PostRequestDto dto,List<MultipartFile> files) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 게시글입니다. ID : " + postId));

        if (!post.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("본인 글만 수정 할 수 있습니다");
        }
        
        post.setContent(dto.getContent()); 
      //이미지 업로드
        if(files !=null && !files.isEmpty()) {
        	files.forEach( file->{
        		String url=fileStorageService.upload(file);
        		Image image=new Image();
        		image.setSrc(url);
        		image.setPost(post);
        		post.getImages().add(image);
        	});
        }
        
        //해쉬태그 (1.겹치면 안됨 2.#해쉬 #first #태그)
        if(dto.getHashtags() != null && !dto.getHashtags().isEmpty()) {
        	post.getHashtags().clear();
            Set<String> distinctTags = Arrays.stream(dto.getHashtags().split(",")) //1. ,기준으로 분리해서 배열을 스트링
                    .map(String::trim)   
                    .filter(s -> !s.isEmpty())  //빈값은 버려라
                    .collect(Collectors.toSet());// 콜렉션 프레임워크,겹치는 값이 있으면 안됨. (중복을 허용하지 않는 보관함)
            
            distinctTags.forEach(tagStr -> {
                String normalized = tagStr.startsWith("#") ? tagStr.substring(1) : tagStr;
                Hashtag tag = hashtagRepository.findByName(normalized)
                        .orElseGet(() -> {
                            Hashtag newTag = new Hashtag();
                            newTag.setName(normalized);
                            return hashtagRepository.save(newTag);
                        });
                post.getHashtags().add(tag);
            });
        }//저장메서드를 따로 호출하지 않아도 update 쿼리반영

        
        return PostResponseDto.from(postRepository.save(post) ); // 으로 자동으로 update
    }

    // 6. 게시글 삭제
    @Transactional
    public void deletePost(Long postId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 게시글입니다. ID : " + postId));

        if (post.isDeleted()) {
            throw new IllegalArgumentException("이미 삭제된 게시글입니다.");
        }

        // 논리 삭제
        post.setDeleted(true);
    }

}