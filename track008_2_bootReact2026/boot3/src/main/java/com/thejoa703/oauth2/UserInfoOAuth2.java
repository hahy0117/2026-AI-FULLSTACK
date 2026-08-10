package com.thejoa703.oauth2;

 
public interface UserInfoOAuth2 {
	
    String getProvider();   //공급자 이름
    String getProviderId();    //공급자 고유 사용자 id
    String getEmail();        //사용자 이메일
    String getNickname();    //사용자 닉네임
    String getImage();       //프로필 이미지 url
}
