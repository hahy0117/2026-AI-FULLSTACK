package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.the703.dao.AppUserDao;
import com.the703.dao.Sboard2Dao;
import com.the703.dao.TestDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto;
import com.the703.dto.Sboard2Dto;
import com.the703.service.AppUserService;
import com.the703.service.Sboard2Service;

@SpringBootTest
class Boot1ApplicationTests2 {
	@Autowired AppUserDao dao;
	@Autowired AppUserService service;
	
	//삭제
	@Disabled @Test
	public void deleteService_User() {
		AppUserDto user=new AppUserDto();
		user.setEmail("2@2"); user.setPassword("2"); user.setAppUserId(62);
		assertEquals(1,service.delete(user, true));
	}
	
	//수정
	@Disabled @Test
	public void updateService_User() {
		AppUserDto user=new AppUserDto();
		user.setEmail("2@2"); user.setPassword("2"); 
		user.setUfile("12.png"); user.setMobile("01011111111"); user.setNickname("new-2");
		user.setProvider("local"); user.setProviderId("local_002"); user.setAppUserId(62);
		
		MockMultipartFile file=new MockMultipartFile("file","test.text","text/plain","data".getBytes());
		
		assertEquals(1,service.update(file, user));
	}
	
	
	//아이디 중복
	@Disabled @Test
	public void iddoubleService_User() {
		int mypage=service.iddouble("2@2", "local");
		
		assertEquals(1, mypage);
	}
	
	//마이페이지
	@Disabled @Test
	public void mypageService_User() {
		AppUserDto mypage=service.selectEmail("2@2", "local");
		
		assertNotNull(mypage);
		assertEquals("2@2",mypage.getEmail());
	}
	//로그인
	@Disabled @Test
	public void loginService_User() {
		
		AppUserAuthDto login=service.readAuthByEmail("2@2", "local");
		assertNotNull(login);
		assertEquals("2@2",login.getEmail());
		assertTrue(login.getAuthList().stream().anyMatch(a -> "ROLE_MEMBER".equals(a.getAuth())));
	}
	
	 @Test 
	public void insert_Service_User() {
		AppUserDto user=new AppUserDto();
		user.setEmail("2@2"); user.setPassword("2"); user.setMbtiTypeId(1);
		user.setUfile("1.png"); user.setMobile("01011111111"); user.setNickname("2");
		user.setProvider("local"); user.setProviderId("local_001");
		
		
		MockMultipartFile file=new MockMultipartFile("file","test.text","text/plain","data".getBytes());
		int result= service.insert(file,user);
		assertEquals(1,result); //예상되는 결과, 코드
		
		
		
	}
	//회원가입
	 @Disabled @Test
	public void insert_User(){
		AppUserDto user=new AppUserDto();
		user.setEmail("1@1"); user.setPassword("1"); user.setMbtiTypeId(1);
		user.setUfile("1.png"); user.setMobile("01011111111"); user.setNickname("1");
		user.setProvider("local"); user.setProviderId("local_001");
		
		int result= dao.insertAppUser(user);
		assertEquals(1,result); //예상되는 결과, 코드
		
		AuthDto auth = new AuthDto();
		auth.setEmail("1@1"); auth.setAuth("ROLE_USER");
		int result_auth=dao.insertAuth(auth);
		assertEquals(1,result_auth); //예상 되는 결과,코드
		
		
	}
	
	//로그인
	@Disabled @Test
	public void login_User() {
		AppUserDto user=new AppUserDto();
		user.setEmail("1@1");
		assertNotNull(dao.readAuthByEmail(user));
	}
	
	//아이디 중복
	@Disabled @Test
	public void iddouble_User() {
		AppUserDto user=new AppUserDto();
		user.setEmail("1@1");
		//assertEquals(1,dao.iddoubleByEmail(user));
		int result=dao.iddoubleByEmail(user);
		assertEquals(1,result);
		
	}
	
	//마이페이지
	@Disabled @Test
	public void mypage() {
		AppUserDto user=new AppUserDto();
		user.setEmail("1@1");
		AppUserDto result=dao.findByEmail(user);
		assertNotNull(result);
	}
	
	//사용자 삭제 +권한 삭제
	@Disabled @Test
	public void delete_User() {
		AppUserDto user=new AppUserDto();
		user.setAppUserId(21);
		assertEquals(1,dao.deleteAppUser(user));
		
		AuthDto auth=new AuthDto();
		auth.setEmail("1@1");
		assertEquals(1,dao.deleteAuth(auth));
	}
	
	//수정(동적sql)
	
	
	
}
