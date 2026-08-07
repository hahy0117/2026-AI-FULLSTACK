package com.the703.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.service.UserService;

public class CustomDetailsService implements UserDetailsService { 
	
	@Autowired UserService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthDto adto=new AuthDto();
		adto.setEmail(username);
		AuthListDto dto= service.readAuth(adto);
		return dto==null? null:new CustomUser(dto);
	}

}
///loadUserByUsername: mapper에서 해당하는 값을 가져와준다.
