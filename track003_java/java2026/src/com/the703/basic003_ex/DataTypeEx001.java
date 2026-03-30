package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx001 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int age;
		
		System.out.println("나이를 입력하세요>");
		age=sc.nextInt();
		System.out.println("나이는"+age+"살 입니다");
		System.out.print("내 나이는"+age+"살 입니다");
		System.out.printf("내 나이는%d살 입니다",age);
		

	}

}
