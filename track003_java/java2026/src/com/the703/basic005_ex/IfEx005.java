package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx005 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char a;
		System.out.println("문자를입력하세요>");
		a=scanner.next().charAt(0);
		if(a>='A' && a<='Z') {
			a=(char)(a+32);
			System.out.println("소문자"+a);
		}else if(a>='a'  &&  a<='z') {
			a=(char)(a-32);
			System.out.println("대문자"+a);
		}
	}

}
