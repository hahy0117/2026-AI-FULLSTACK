package com.the703.basic009;

public class Method003 {
	//1.함수구조 public static 리턴값(결과물) 매서드형(마법상자이름) (파라미터:재료) {할일}
	public static      int hello(String name) {
		return 1;
	}
	//public static      void hello(String name) {
		
	//}
	public static String   sing(){
		return "용감한 자바전사";
		}
	public static String intro(String name,int num) {
		return name+"님의레벨은:"+num;
	}
	public static double spell(int num) {
		return num/2.0; 
	}
	public static int luck() {
		return 100;
	}
	public static int s(int num) {
		return num*100;
	}

	public static void main(String[] args) {
		hello("aaa"); //사용법: 마법상자이름(재료) (1) 
		System.out.println( hello("bbb") ); //1
		
		//public static 리턴값 매서드명(파라미터){해야할일}
		//public static String   sing(){용감한 자바전사}
		System.out.println("1.당신의 이름은?"+sing()); //용감한 자바전사
		System.out.println("2.당신의 소개?"+intro("홍길동",9)); 
		                  //2.당신의 소개? 홍길동님의 레벨은 9
		System.out.println("2.당신의 소개?"+intro(sing(),10));  //예상되는 결과는? 용감한자바전사님의 레벨은10
	    System.out.println("3.반타작이저주>"+spell(9)); //반타작의 저주>4.5
	    //public static double spell(int num){return a/2.0}
	    System.out.println("4.운세>"+luck()); //4.운세 100
	    
	    System.out.println("5.주식>"+s(1)); //5.주식>100배
		
		

	}

}
