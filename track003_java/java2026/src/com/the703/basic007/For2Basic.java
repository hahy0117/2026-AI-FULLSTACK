package com.the703.basic007;

public class For2Basic {

	public static void main(String[] args) {
		System.out.println(1+"층");
		System.out.println(1);System.out.println(2);System.out.println(3);System.out.println();
		System.out.println(2+"층");
		System.out.println(1);System.out.println(2);System.out.println(3);System.out.println();
		//ver-2 각칸정리 for정리 {영역} {변수} for(시작;종료;변화)
		System.out.println();
		System.out.println(1+"층");
		for(int kan=1; kan<=3; kan++) {
			System.out.print(kan);
		}System.out.println();
		
		System.out.println(2+"층");
		for(int kan=1; kan<=3; kan++) {
			System.out.print(kan);
		}System.out.println();
		//ver-3
		for(int ch=1; ch<=3;ch++)
		{
			System.out.println(ch+"층");
			for(int kan=1; kan<=3; kan++) {
				System.out.print(kan);
			}System.out.println();
		}
		
		
		
		
		
	


	}

}
