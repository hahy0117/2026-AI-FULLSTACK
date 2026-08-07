package com.the703.basic006;

import java.util.Scanner;

public class ForInfinit {

	public static void main(String[] args) {
		//제어문
		//조건문:~라면 if / switch
		//반복문: 반복 for/ while / do while
		
		//1.영역
		//for(;;) {System.out.println("hello")
		
		Scanner scanner = new Scanner(System.in);
		int a = -1;
		
		//빠져나올 조건
//		for(;;){
//			System.out.println("hello");
//			System.out.println("빠져나오실래요? 0이면 종료");
//			a=  scanner.nextInt();
//			if(a==0) break;
//			
//			for(; a==0  ;) {
//				System.out.println("hello");
//				System.out.println("빠져나오실래요? 0이면 종료");
//				a=  scanner.nextInt();
			//}
			//}
		//int a =-1; //a[-1]
		for(; a==0 ;) // a가 0이 아니면
		{//여기서부터
			System.out.println("hello");
			System.out.println("빠져나오실래요? 0이면 종료");
			a=scanner.nextInt();
		}
	}

}
