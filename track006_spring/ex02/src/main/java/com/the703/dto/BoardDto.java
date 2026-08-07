package com.the703.dto;

import lombok.Data;

@Data
public class BoardDto {
	private int bno;
	private String bname;
	private String bpass;
	private String btitle;
	private String bcontext;
	private String bdate;
	private int bhit;
	private String bip;
}
