package com.the703.basic012_ex;
//Q1. 상속도 그리기
/*Object
 * ↑
 * Papa {int money,sing(){"GOD-거짓말"}}
 *  ↑
 *  Son (int money,@sing(){빅뱅-거짓말})
  
  
 * */
//Q2. 각클래스에서 사용할수있는 멤버변수/멤버메서드


class Papa extends Object{  
	   int money = 10000;     
	   public Papa() { super(); }
	   public void sing() {  System.out.println("GOD-거짓말");  }
	}// end class

class Son extends Papa{ 
	   int money = 1500;
	   public Son() { super(); }
	   @Override public void sing() {  System.out.println("빅뱅-거짓말"); }
	} // end class




public class PolyEx001 {

	public static void main(String[] args) {
		 //부모     =자식  (업캐스팅)
		 Papa mypapa = new Son();    
		 // Q3. Papa mypapa 의미? {money=10000/sing()}
		 //  Q4. 인스턴스화한 실제 메모리 빌려온그림 -new Son()
		 //     Son() → Papa()  → Object()
		 //1번지: {money=1500/@Sing() {빅뱅-거짓말}}-{money=10000/sing(){GOD-거짓말}
		  System.out.println(mypapa.money); // Q5.  출력 :   10000
		  mypapa.sing();  //Q6. 출력 
		   //Q7. mypapa.money 를 이용해서  1500 출력
		  
		  System.out.println(((Son)mypapa).money);
		  
	}

}
