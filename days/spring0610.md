파일 CustomUser


package com.thejoa703.security;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.the703.dto.AuthListDto;
import lombok.Getter;

@Getter public class CustomUser extends User{ //## 사용자정보
   private static final long serialVersionUID = 1L; 
   AuthListDto dto;    
   //2. 유저아이디와 비밀번호를 받아서 권한이 있는지 체크
   public CustomUser(String username, 
                  String password, 
                  Collection<? extends GrantedAuthority> authorities) {
      super(username, password, authorities); 
   }
   //1. 유저이메일과 비밀번호를 받아서 권한이 다른경우 맞게 셋팅
      public CustomUser(AuthListDto dto) {
         super(  dto.getEmail() ,  
               dto.getBpass() , 
               dto.getAuthList().stream()
                  .map( auth-> new SimpleGrantedAuthority(auth.getAuth()))
                  .collect(Collectors.toList())   
         );
         this.dto = dto;
      }
    
}
파일 CustomUserDetailsService


package com.thejoa703.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthListDto;
import com.the703.service.UserService;

public class CustomUserDetailsService   implements UserDetailsService{

   @Autowired  UserService service;
   
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      AuthDto     adto = new AuthDto();    adto.setEmail(username); // 이메일셋팅
      AuthListDto  dto = service.readAuth(adto);  // 이메일,비밀번호, 권한(들) 가져오기
      return dto == null?  null : new CustomUser(dto);
   }

}
