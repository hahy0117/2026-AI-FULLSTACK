package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx004 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String i;
		System.out.println("문자한개를 입력>");
		i=scanner.next();
		switch(i) {
		case "a":
		case "A": System.out.println("APPLE"); break;
		
		case "b":
		case "B": System.out.println("BANANA"); break;
		
		case "c":
		case "C":System.out.println("COCONUT"); break;
		
		}

	}

}
