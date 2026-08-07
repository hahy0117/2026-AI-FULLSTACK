package com.thejoa703.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.service.PostService;
import com.thejoa703.dto.PostDto.PostRequestDto;
import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.entity.Post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name="Post Api",description="게시글 관련 API")
@RestController    //@Controller + @ResponseBody
@RequestMapping("/api/posts")
@RequiredArgsConstructor
//@CrossOrigin(origins="*")   //// webConfig에서 설정이 되어 있어요ㅕ!
public class PostController {
	
	private final PostService postService;
	
	
	//게시글 작성
	@Operation(summary="게시글 작성",description="특정유저 ID와 내용을 받아 게시글을 작성합니다.")
	@PostMapping(consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<PostResponseDto> createPost(
			@Parameter(description="작성자 사용자 ID") @RequestParam("userId") Long userId,
			@ModelAttribute PostRequestDto  dto , // multipart/form-data
			@Parameter(description="업로드할 이미지 파일 리스트")  // swagger
			@RequestPart(name="files" , required=false)  List<MultipartFile>files){
		
		System.out.println("===== 게시글 작성 =====");
	    System.out.println("userId : " + userId);
	    System.out.println("content : " + dto.getContent());
	    System.out.println("hashtags : " + dto.getHashtags());
		
		
		return ResponseEntity.ok(postService.createPost(userId,dto,files));
	}
	
	//게시글 수정  /api/posts/{postId}
	@Operation(summary="게시글 수정",description="특정유저 ID와 내용을 받아 게시글을 수정합니다.")
	@PatchMapping("/{postId}") //Put 리소스의 전체 교체 /Patch 부분수정
	public ResponseEntity<PostResponseDto> getUpdatePost(
			@Parameter(description="작성자 사용자 ID") @RequestParam("userId") Long userId,
			@Parameter(description="수정할 게시긁 ID") @PathVariable(name="postId") Long postId,
			@ModelAttribute PostRequestDto  dto , // 게시글내용+댓글
			@Parameter(description="수정시 업로드할 이미지 파일 리스트")  // swagger
			@RequestPart(name="files" , required=false)  List<MultipartFile>files
			){
		

		    return ResponseEntity.ok(postService.updatePost(userId,postId,dto,files));
	}
	//게시글 삭제
	@Operation(summary="게시글 삭제",description="특정유저 ID를 받아 게시글을 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deletePost(@PathVariable("id") Long id){
		 postService.deletePost(id);

		    return ResponseEntity.ok(id);
	} 
	
	
	//게시글 단건조회
	@Operation(summary="게시글 단건조회", description="게시글 ID로 게시글을 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable("id")  Long id) {

        PostResponseDto response = postService.getPost(id);

        return ResponseEntity.ok(response);
    }
	
	@GetMapping
	@Operation(summary = "게시글 전체조회", description = "삭제되지 않은 게시글 목록을 조회합니다.")
	public ResponseEntity<List<PostResponseDto>> getAllPosts() {

	    List<Post> posts = postService.getAllPosts();

	    List<PostResponseDto> response = posts.stream()
	            .map(PostResponseDto::new)
	            .toList();

	    return ResponseEntity.ok(response);
	}
}



