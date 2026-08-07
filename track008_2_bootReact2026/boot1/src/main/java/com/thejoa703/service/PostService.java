package com.thejoa703.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final AppUserRepository appUserRepository;

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
    public Post createPost(Long userId, String content) {

        AppUser user = appUserRepository.findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 사용자입니다. ID : " + userId));

        Post post = new Post();
        post.setContent(content);
        post.setUser(user);

        return postRepository.save(post);
    }

    // 5. 게시글 수정
    @Transactional
    public Post updatePost(Long postId, String content) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 게시글입니다. ID : " + postId));

        if (post.isDeleted()) {
            throw new IllegalArgumentException("삭제된 게시글은 수정할 수 없습니다.");
        }

        post.setContent(content);

        // 더티체킹으로 자동 UPDATE
        return post;
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