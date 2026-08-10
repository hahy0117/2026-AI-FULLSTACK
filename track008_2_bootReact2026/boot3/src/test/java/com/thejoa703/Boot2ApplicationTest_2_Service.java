package com.thejoa703;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.domain.DeptUser;
import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Comment;
import com.thejoa703.entity.Hashtag;
import com.thejoa703.entity.Image;
import com.thejoa703.entity.Post;
import com.thejoa703.entity.PostLike;
import com.thejoa703.mapper.DeptUserMapper;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.CommentRepository;
import com.thejoa703.repository.DeptUserRepository;
import com.thejoa703.repository.HashtagRepository;
import com.thejoa703.repository.ImageRepository;
import com.thejoa703.repository.PostLikeRepository;
import com.thejoa703.repository.PostRepository;
import com.thejoa703.service.UserService;
import org.springframework.mock.web.MockMultipartFile;

@SpringBootTest
@Transactional
class Boot2ApplicationTest_2_Service {
	@Autowired
	UserService userService;
	
	private Long createTestUser(String email,String nickname) {
		UserRequestDto signupDto =new UserRequestDto();
		signupDto.setEmail(email);
		signupDto.setPassword("password123");
		signupDto.setNickname(nickname);
		signupDto.setProvider("local");
		
		MockMultipartFile profileImage=new MockMultipartFile(
				"profileImage","test.png" ,"image/png" ,"test image content".getBytes()
				);
		UserResponseDto res =
		        userService.createUser(signupDto, profileImage);
		return res.getId();
		
	}
	
	@Test
	@DisplayName("userservice crud")
	void testAppUserService() {
		Long userId=createTestUser("test1@email.com","test1");
		
		
		LoginRequest loginDto = new LoginRequest();
		
		loginDto.setEmail("test1@email.com");
		loginDto.setPassword("test1");
		loginDto.setProvider("local");
		
		UserResponseDto loginRes=userService.login(loginDto);
		assertThat(loginRes).isNotNull();
		assertThat(loginRes.getId()).isEqualTo(userId);
		
		//이메일중복
		assertThat(userService.existsByEmail("test1@email.com")).isTrue();
		
		//닉네임 중복
		assertThat(userService.existsByNickname("test1")).isTrue();
		
		//마이페이지
		UserResponseDto foundUser=userService.getUser(userId);
		assertThat(foundUser.getNickname()).isEqualTo("test1");
		
		//유저닉네임수정
		UserResponseDto updateUser=userService.updateNickname(userId, "111");
		//유저삭제
		//userService.deleteById(userId);
		//UserResponseDto deleteUser=userService.getUser(userId);
		//assertThat(deleteUser).isNotNull();
		
	}
	
	
}
