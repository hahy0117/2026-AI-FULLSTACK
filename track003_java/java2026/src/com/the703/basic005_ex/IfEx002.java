package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx002 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		System.out.println("숫자를 입력하세요>");
		num = scanner.nextInt();
		if(num>0) {
			System.out.println("양수입니다");
		}else if(num<0) {
			System.out.println("음수입니다");
		}else if(num==0) {
			System.out.println("zero");
		}
		String anser = num>0 ? "양수": num<0 ? "음수" : "zero" ;

	}

}
