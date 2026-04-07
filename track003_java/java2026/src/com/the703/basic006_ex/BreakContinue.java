package com.the703.basic006_ex;

import java.util.Scanner;

public class BreakContinue {

	public static void main(String[] args) {
		//ver-0
		//       {int a=1; System.out.println(a);}//영역
		//       a=2;   //why? X
		//ver-1 for 반복
		//for(;;) {System.out.println(1);}
		
		//ver-2 반복 빠져나오기
		
		for(int i=1;i<5;i++) { //조건 if(;조건;)
			
			if(i==3) {break;}// 나가
			System.out.println(i);
			}
		
		/////////////
		System.out.println();
		
		for(int i=1;i<5;i++) { //조건 if(;조건;)
			if(i==3) {continue;}//skip
			System.out.println(i);
			
			}
		Scanner scanner=new Scanner(System.in);
		//ver-3
		int a;
		for(;;) {
			System.out.println("1입력");
			a=scanner.nextInt();
			if(a==1) {break;} //잘 입력하면 나가
		}

	}

}
