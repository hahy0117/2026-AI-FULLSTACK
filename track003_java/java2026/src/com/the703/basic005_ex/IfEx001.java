package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx001 {

	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요>");
		Scanner scanner=new Scanner(System.in);
		double num;
		num =scanner.nextDouble();
		if(num>=60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		//삼항 연산자   조건? 참:거짓
		String anser= num>=60 ? "합격":"불합격";
		System.out.println(anser);
		
		System.out.println( num>=60? "합격":"불합격");
	}

}
