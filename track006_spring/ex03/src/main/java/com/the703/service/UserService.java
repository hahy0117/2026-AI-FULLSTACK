package com.the703.service;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.dto.UserDto;

public interface UserService {
	// 회원가입
	public int insert(UserDto dto);

//로그인
	public int findLogin(UserDto dto);

//마이페이지
	public UserDto findByUno(int uno);

//아이디 중복검사
	public String findByEmail(String email);
	
	/*security login*/
	public AuthListDto readAuth(AuthDto dto);
	
	public UserDto findByEmailUserInfo(String email);

}
