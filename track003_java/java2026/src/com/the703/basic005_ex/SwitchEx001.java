package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx001 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num;
		System.out.println("숫자 하나를 입력>");
		num=scanner.nextInt();
		switch(num) {
		case 3: System.out.println("봄");break;
		case 6: System.out.println("여름");break;
		case 9: System.out.println("가을");break;
		case 12:System.out.println("겨울");break;
		}

	}

}
