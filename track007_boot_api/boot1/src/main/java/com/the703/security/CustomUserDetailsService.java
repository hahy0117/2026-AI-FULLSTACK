package com.the703.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.the703.dao.AppUserDao;
import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired AppUserDao dao;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	//username "1@1:local" 2@2:kakao
		
		String [] parts =username.split(":");
		String email = parts[0];
		String provider= parts.length >1 ? parts[1] : "local";
		
		AppUserDto dto=new AppUserDto(); dto.setEmail(email);  
		dto.setProvider(provider);
		AppUserAuthDto authDto=dao.readAuthByEmail(dto); 
		
		AppUserDto appUserDto =dao.findByEmail(dto);
		
		return new CustomUserDetails(appUserDto,authDto);
	}

}
