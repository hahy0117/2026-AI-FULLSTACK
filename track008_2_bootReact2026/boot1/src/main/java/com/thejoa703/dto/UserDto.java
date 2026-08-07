package com.thejoa703.dto;

import com.thejoa703.entity.AppUser;

import lombok.Getter;
import lombok.Setter;

public class UserDto {
	//회원가입 요청Dto
		@Setter @Getter
		public static class UserRequestDto{
			private String email;
			private String password;
			private String nickname;
			private String mobile;
			private Integer mbtitype;
		}
		//회원 정보- 응답Dto
		@Getter
		public static class UserResponseDto{
			private Long      id;
			private String email;
			private String password;
			private String nickname;
			private String mobile;
			private Integer mbtitype;
			private String role;
			
			public UserResponseDto(AppUser user) {
				this.id=user.getId();
				this.email=user.getEmail();
				this.password=user.getPassword();
				this.nickname=user.getNickname();
				this.mobile=user.getMobile();
				this.mbtitype=user.getMbtitype();
				this.role=user.getRole();
			}
}
}
