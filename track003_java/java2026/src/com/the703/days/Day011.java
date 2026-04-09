package com.the703.days;

import java.util.Scanner;

public class Day011 {

	public static void main(String[] args) {
		//if
		char ch='\u0000';
		Scanner scanner=new Scanner(System.in);
		System.out.println("a,b,c중에 입력>");
		ch=scanner.next().charAt(0);
		
		if(ch=='a') {
			System.out.println("apple");
		}else if(ch=='b') {
			System.out.println("banana");
		}else if(ch=='c') {
			System.out.println("coconut");
		}
		
		//switch
		switch(ch) {
		case 'a': System.out.println("apple");
		break;
		case 'b':System.out.println("banana");
		break;
		case 'c':System.out.println("coconut");
		break;
		}
		//for while do while 12345 출력
		for(int i=1;i<=5;i++) {
			System.out.print(i+"\t");
		}System.out.println();
		
		//while
		int i=1;
		while(i<=5) {
			System.out.print(i+"\t");
			i++;
		}		
		System.out.println();
		//do while
		int i1=1;
		do {
			System.out.print(i1+"\t");
			i1++;
		}while(i1<=5);
		System.out.println();
		

	}

}
