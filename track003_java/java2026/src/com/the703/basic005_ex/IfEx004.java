package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx004 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char a;
		
		System.out.println("문자를 입력하세요>");
		a =scanner.next().charAt(0);
		if(a>='A' && a<='Z') {
			System.out.println("대문자");
		}else if(a>='a'  &&  a<='z') {
			System.out.println("소문자");
		}else {
			System.out.println("문자가 아닙니다");
		}
		System.out.println(a>='A' && a<='Z'?"대문자": a>='a'  &&  a<='z'?"소문자":"문자가 아니다");
	}

}
