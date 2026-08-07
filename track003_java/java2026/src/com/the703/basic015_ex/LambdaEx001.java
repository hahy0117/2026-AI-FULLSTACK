package com.the703.basic015_ex;

interface Printer {
    void print(String msg);
}

interface Calculator {
    int add(int a, int b);
}

public class LambdaEx001 {

	public static void main(String[] args) {
		//익명 객체로 "Message: <문자열>" 형식으로 출력하기 람다식으로 동일한 기능 구현하기
		//p1.print("Hello World");
		//p2.print("Lambda Rocks!");
		//System.out.println("익명객체 결과: " + c1.add(3, 5)); 
        //System.out.println("람다식 결과: " + c2.add(10, 20));
		
		Printer a1=new Printer() {

			@Override
			public void print(String msg) {
				System.out.println("Message:"+msg);
				
			}
			
		}; a1.print("Hello World");
		

		Printer a2=new Printer() {

			@Override
			public void print(String msg) {
				System.out.println("Message:"+msg);
				
			}
			
		}; a2.print("Lambda Rocks!");
		
		Calculator a3=new Calculator() {

			@Override
			public int add(int a, int b) {
				int result=a+b;
				
				return result;
			}
			
		};
		System.out.println("익명객제 결과:"+a3.add(3, 5));
		
		Calculator a4=(a,b)->a+b; 
			
			System.out.println("람다식 결과:"+a4.add(10,20));
		  
		
		
		
	}

}
