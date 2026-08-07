package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx004 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		float f1=3.14f;
		double dou = 3.14;
		
		System.out.println("파이값을 입력해주세요>");
		f1=sc.nextFloat();
		System.out.println("파이값은"+f1+"입니다");
		System.out.printf("파이값은 %f입니다.\n" ,dou);
		System.out.printf("파이값은 %.0f입니다.\n"  ,dou);
		System.out.printf("파이값은 %.1f입니다.\n" ,dou);
		System.out.printf("파이값은 %.2f입니다.\n" ,dou);
		System.out.printf("파이값은 %.6f입니다.\n" ,dou);
		
		System.out.print(10/3); //정수/정수
		System.out.println(10/3f); //정수/실수
		System.out.println(10f/3); //실수/정수
		 
		
		

	}

}
