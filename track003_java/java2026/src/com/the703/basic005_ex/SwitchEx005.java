package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx005 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num;
		System.out.println("숫자 한개 입력>");
		num=scanner.nextInt();
		switch(num%2) {
		case 0: System.out.println("여자");break;
		case 1: System.out.println("남자");break;
		}
	}

}
