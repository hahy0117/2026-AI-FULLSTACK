package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx003 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int year;
		int age;
		System.out.println("태어난 년도를 입력하세요>");
		year=sc.nextInt();
		age=(2026-year);
		System.out.println("당신의나이는"+age+"살 입니다");
		System.out.print("당신의 나이는"+year+"살 입니다 \n");
	}

}
