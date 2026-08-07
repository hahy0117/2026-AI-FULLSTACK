package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx003 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		char i;
		System.out.println("문자한개를 입력>");
		i=scanner.next().charAt(0);
		switch(i) {
		case 'a': System.out.println("APPLE");break;
		case 'b': System.out.println("BANANA");break;
		case 'c': System.out.println("COCONUT");break;
		}

	}

}
