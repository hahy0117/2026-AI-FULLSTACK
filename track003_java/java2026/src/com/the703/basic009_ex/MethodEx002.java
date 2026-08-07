package com.the703.basic009_ex;

public class MethodEx002 {

	public static void test1(int num) {
		System.out.println(num);
	}
	public static void test2(double num1) {
		System.out.println(num1);
		
	}
	public static void hap(int num2, int num22) {
		int sum=0;
		for( int i=num2;i<=num22;i++) {
			sum=sum+i;
		
		}System.out.println("합은:"+sum);		
		
	}
	public static void disp(int num3,char ch) {
		for(int i=1;i<=num3;i++) {
			System.out.print(ch);
		}
	}
	public static void main(String[] args) {
		test1(10);
		test2(1.2);
		hap(3,5);
		disp(7,'*');
		
	}

}
