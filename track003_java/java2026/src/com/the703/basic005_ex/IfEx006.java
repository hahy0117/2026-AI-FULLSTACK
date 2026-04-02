package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx006 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("숫자를 입력하세요>");
		int num;
		num=scanner.nextInt();
		if(num%2==0) {
			System.out.println("여자");
		}else {
			System.out.println("남자");
		}
	}

}
