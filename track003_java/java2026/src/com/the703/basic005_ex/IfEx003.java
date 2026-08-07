package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		System.out.println("숫자를 입력하세요>");
		num=scanner.nextInt();
		if(num==1) {
			System.out.println("one");
		}else if(num==2) {
			System.out.println("two");
		}else if(num==3) {
			System.out.println("three");
		}else {
			System.out.println("1,2,3이 아니다");
		}
		System.out.println( num==1?"one":num==2 ?"two":num==3? "three" :"1,2,3이 아니다");

	}

}
