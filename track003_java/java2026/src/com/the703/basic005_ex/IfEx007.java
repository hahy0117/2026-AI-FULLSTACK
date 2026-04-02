package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int num1,num2;
		char num3;
		double result=0;
		System.out.println("정수를 하나 입력해주세요>");
		num1=scanner.nextInt();		
			
		System.out.println("정수를 하나 입력해주세요2>");
		num2=scanner.nextInt();
		
		System.out.println("연산자를 입력해주세요>");
		num3=scanner.next().charAt(0);
		
		
		if(num3=='+') {
			result = num1+num2;
//			System.out.println(num1+"+"+num2+"="+(num1+num2));
		}else if(num3=='-') {
			result = num1-num2;
//			System.out.println(num1+"-"+num2+"="+(num1-num2));
		}else if(num3=='*') {
		    result = num1*num2;
//			System.out.println(num1+"*"+num2+"="+(num1*num2));
		}else if(num3=='/') {
			result = (double)num1/num2;
//			System.out.println(num1+"/"+num2+"="+((double)num1/num2));
		} 
		
		System.out.printf("%d%s%d=%.2f",num1,num3,num2,result);
				

	}

}
