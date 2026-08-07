package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {
		//변수
		Scanner scanner =new Scanner(System.in);
		int num1= -1,num2 = -1;
		char num3='\u0000';
		double result=0;
		//result =""+num1+num3+num2+"=";
		
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
			//System.out.println("%.0f / %.0f=%.2f" ,num1,num2,num1/(double)num2);
			//else if(num2 != 0 && num3=='/')
		}
		if(num3=='/') {
	    	  System.out.printf("%d%s%d=%.2f",num1,num3,num2,result);	            
	      }else {
	    	  System.out.printf("%d%s%d=%d",num1,num3,num2,(int)result);
	    	  //System.out.println("%d %c %d="+(num3=='/' ? "%.2f": "%.0f")
	            
	      }
		//10/3 이면 소수점나오게 아니면소수점 안나오게, 나누기는 소수점 나오게
		
		

	}

}
