package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LIstEx002 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=0;
		

		
		 List<String> numbers = new ArrayList<String>();
		 numbers.add("one");
		 numbers.add("two");
		 numbers.add("three");
		 
		
		 for(;;) {
			 System.out.println("1,2,3 중에 입력받기");
			 num=scanner.nextInt();
			 if(num==1) {
				 System.out.println("one"); continue;
			 }else if(num==2) {
				 System.out.println("two"); continue;
			 }else if(num==3) {
				 System.out.println("three");continue;
			 }else {
				 System.out.println("종료");break;
			 }
		 }
		 
		 
	}

}
