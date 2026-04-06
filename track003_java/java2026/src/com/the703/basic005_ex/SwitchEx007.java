package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx007 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		double avg=-1;
		System.out.println("평균 한개 입력>");
		avg=scanner.nextDouble();
		switch((int)avg/10) {
		
		case 10: 
		case 9: System.out.println("수"); break;
		case 8: System.out.println("우"); break;
		case 7: System.out.println("미"); break;
		case 6: System.out.println("양"); break;
		default:System.out.println("가"); break;
		
		}
	}

}
