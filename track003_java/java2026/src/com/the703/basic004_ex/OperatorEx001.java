package com.the703.basic004_ex;

public class OperatorEx001 {

	public static void main(String[] args) {
		int a=3, b=10;
		System.out.println( b+=10 -a--);
		//1) a-- (; 끝나고 계산 -> 맨 마지막에) 상태) a=3 b=10
		//2) 10-a(3)=7//17               
		//3) b+=7   b=b+7  b=10+7 (17)
		//4) ; 후 a=2 b=17
		System.out.println( a+=5); //7 a=a+5 a=2+5 출력 a=7
		System.out.println( a>=10 || a<0 && a>3); //false
		//1) a>10 -> 7>=        ->false
		//2) a<0 && a>3 -> 7<0  -> false
		//3) false || false     -> false
		

	}

}
// int a=3, b=10;
//System.out.println(  b+=10 - a-- );   
//System.out.println(  a+=5 );
//System.out.println(  a>=10 || a<0 && a>3);
