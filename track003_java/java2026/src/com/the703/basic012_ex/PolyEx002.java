package com.the703.basic012_ex;

/*
 Object
 ↑
 Parent7 {x=100,method()} Parent
  ↑
  child7 {x=200,method()} Child
  
 * */

class Parent7  extends Object{
	   int x = 100;
	   public Parent7() { super(); }
	   void method() { System.out.println("Parent Method"); }
	} 

class Child7 extends Parent7 {
	   int x = 200;
	   public Child7() { super(); }
	   @Override  void method() { System.out.println("Child Method"); }
	}



public class PolyEx002 {

	public static void main(String[] args) {
		  Parent7 p = new Child7();      //부모 = 자식 (업캐스팅)
		  // Q3.  Parent7 p   보장하는 범위  
		  // int x = 100;, void method()
		  // Q4. 인스턴스화 했을때 사용가능한 범위 : new Child7()  
		       child7()   →     Parent7()    →        Object()
		       //1번지 : {x=200, [@method()} -{x=100 ], method()}   {}
		  
		   Child7 c = new Child7();     
		   
		   System.out.println("p.x = " + p.x);  // Q5. 출력되는 내용 : 100
		   p.method();  // Q6. 출력되는 내용    Child Method 
		   System.out.println("c.x ="+c.x); // Q7. 출력되는 내용 : 200
		   c.method();   // Q8. 출력되는 내용Child Method
		  
	}

}
