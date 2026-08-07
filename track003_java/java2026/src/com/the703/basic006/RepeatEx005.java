package com.the703.basic006;

import java.util.Scanner;

public class RepeatEx005 {

	public static void main(String[] args) {
		//for
		int a,b;
		int sum=0;
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("숫자1을 입력>");
		a=scanner.nextInt();
		System.out.println("숫자2을 입력>");
		b=scanner.nextInt();
		if(a>b) {
			int c=a;
			a=b;
			b=c;
			System.out.print("+");
		}
		
		for(int i=a; i<=b;i++) {
			sum=sum+i;
			System.out.print(i);
			if(i !=b) {
				System.out.print("+");
			} 
						
		}
		System.out.print("="+sum);
		

	}

}
