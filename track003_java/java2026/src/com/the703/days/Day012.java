package com.the703.days;

import java.util.Scanner;

public class Day012 {

	public static void main(String[] args) {
		int avg=0;
		Scanner scanner=new Scanner(System.in);
		System.out.println("평균입력>");
		avg=scanner.nextInt();
		
		if(avg>=90) {
			System.out.println("A학점");
		}else if(avg>=80) {
			System.out.println("B학점");
		}else if(avg>=70) {
			System.out.println("C학점");
		}else {
			System.out.println("F학점");
		}
		//switch
		switch(avg/10) {
		case 10:
		case 9: System.out.println("A"); break;
		case 8: System.out.println("B"); break;
		case 7: System.out.println("C"); break;
		default: System.out.println("F"); break;
		}
		
		//for
		for(int i=1; i<=3;i++) {
			System.out.print(i);
		}System.out.println();
		//while
		int i=1;
		while(i<=3) {
			System.out.print(i);
			i++;
		}System.out.println();
		
		//do while
		int i1=1;
		do {
			System.out.print(i1);
			i1++;
		}while(i1<=3);
		System.out.println();
		
		//이중 for
		for(int i2=1;i2<=4;i2++) {
			for(int i3=1;i3<=4;i3++) {
				System.out.print("★");
			}System.out.println();
		}
	}

}
