package com.the703.dto;

import java.util.List;

import lombok.Data;

@Data
public class AuthListDto {
private String email;
private String bpass;
private List<AuthDto> authList; //리스트로 권한을 여러개 받아오니까 user mapper에서 collection 으로 받아오기
}
