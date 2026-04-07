package com.the703.basic006;

public class ForBasic {

	public static void main(String[] args) {
		//step) 줄바꿈안된 print 이용해서 1  2  3
		System.out.println("step 1 출력");
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		
		System.out.println("step 2) for");
		//for(;;){빠져나올조건}
		//step2-1) 반복되는 영역  System.out.println(1);
		//step2-2) 반복되는 영역-> 변수찾기 System.out.println(1,2,3으로 바뀜);
		//step2-3) 패턴찾기 (시작;종료;변화) 시작:1, 종료:3, 변화:1
		for(int i=1; i<=3; i++) {
			System.out.println(i);
		}
		//step3)
		System.out.println("\n step3) for연습");
		//패턴:시작 1; 종료 10;변화 1
		for(int i=1; i<=10; i++) {
			System.out.print(i); 
		}System.out.println();
		//패턴:시작 2; 종료 8;변화 1
		for(int i=2; i<=8; i++) {
			System.out.print(i); 
		}System.out.println();
		//패턴:시작 3; 종료 9;변화 3
		for(int i=3; i<=9; i+=3) {//i=i+3
			System.out.print(i); 
		}System.out.println();
		
		//패턴:시작 5; 종료 1;변화 -2
		for(int i=5; i>=1; i-=2) {//i=i-2
			System.out.print(i); 
		}System.out.println();
		
		//hi1 hi2 hi3 {} {변수} for(시작;종료;변화)
		{
			System.out.print("hi"+1);
			System.out.print("hi"+2);
			System.out.print("hi"+3);
			
			for(int i=1; i<=3;i++) { System.out.print("hi"+i+"\t");}
		}
		
				
		
		

	}

}
