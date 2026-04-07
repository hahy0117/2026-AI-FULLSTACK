package com.the703.basic005_ex;

import java.util.Scanner;

public class ForEx002 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int dan=-1;		
		System.out.println("단을 입력하세요>");
		dan=scanner.nextInt();
	   
	
		
		for(int i=1;i<=9;i++) {
			System.out.println(dan+"x"+i+"="+(dan*i));
		
	}

	}

}
