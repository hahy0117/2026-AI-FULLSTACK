package ex02;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.UserDto;
import com.the703.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {
	    "classpath:config/root-context.xml", "classpath:config/security-context.xml"
	   // "classpath:config/servlet-context.xml"
	})
public class ModelTest2 {
	@Autowired UserMapper  user;
	@Autowired UserService service;
	@Autowired @Qualifier("passwordEncoder")PasswordEncoder pwencoder;
	
	@Ignore@Test public void test4() {
		AuthDto dto2=new AuthDto(); dto2.setEmail("gg@11");
		System.out.println(service.readAuth(dto2));
	}
	
	  @Test public void test3() {
//		AuthDto dto2=new AuthDto();
//		dto2.setEmail("gg@11");
//		System.out.println(user.readAuth(dto2));
		/* 권한 2개 줬으면 주석달고 위에 해당유저정보가져오기*/
		AuthDto  dto1=new AuthDto();
		dto1.setEmail("1@1");
		dto1.setAuth("ROLE_ADMIN");
		System.out.println(user.insertAuth(dto1));
		
//		UserDto dto=new UserDto();
//		dto.setNickname("gg");
//		dto.setBpass(pwencoder.encode("gg"));  
//		dto.setEmail("gg@11");
//		dto.setMobile("11");
//		System.out.println(service.insert(dto));
	}
	
	@Ignore @Test public void test1() throws UnknownHostException {
		//이메일중복 : findByEmail
		System.out.println(user.findByEmail("gg@11"));
		//마이페이지: findByUno
		System.out.println(user.findByUno(18));
		
		//로그인:findLogin email=#{email} and bpass=#{bpass}
		UserDto dto2=new UserDto();
		dto2.setBpass("11"); dto2.setEmail("gg@11");
		System.out.println(user.findLogin(dto2));
		
		//회원가입:insert -UserDto :nickname,bpass,email,mobile,bip
		UserDto dto= new UserDto();
		dto.setNickname("gg");
		dto.setBpass("11");
		dto.setEmail("gg@11");
		dto.setMobile("11");
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		System.out.println(user.insert(dto));
	}
}
