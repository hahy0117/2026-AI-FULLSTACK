package com.the703.basic012;

/*
  //1.클래스는 부품객체
  //2.상속은 재활용
  /// Object        
  /// ↑                
  /// Test2  (int a, toString)         
  /// ↑        
  /// TestB2 (int b,toSrting)
  
  
 * */
class TestA4 extends Object{ 
	int a=10;

	@Override
	public String toString() {
		return "TestA4 [a=" + a + "]";
	}
	}//end class
class TestB4 extends TestA4{
	int b=20;

	@Override
	public String toString() {
		return "TestB4 [b=" + b + "]";
	}
	}//end class

public class Poly004 {

	public static void main(String[] args) {
		System.out.println((int)1.1); // 소수점이 짤림
		
		TestB4 tb= (TestB4) new TestA4();
		//1) TestB3 tb {b=20, toString}-{a=10,toString}
		//2) new TestA3() 1번지 : {a=10, toString}
		//3)보장범위: tb {b=20, toString}-{a=10, toString}
		//                                             = {a=10,toString}
		/*
		  1
    Exception in thread "main" java.lang.ClassCastException: class com.the703.basic012.TestA3 cannot be cast to class com.the703.basic012.TestB3 
    (com.the703.basic012.TestA3 and com.the703.basic012.TestB3 are in unnamed module of loader 'app')
	at com.the703.basic012.Poly003.main(Poly003.java:36)
   */
		
  }

}

/*
  1. 다형성
  -많은 형상을 띄는 상품
  -여러타입의 객체를 하나의 타입으로 관리
 
  2.부모는 자식을 담을 수 있다.(업캐스팅)
  --------------------------------
  <<class>> Animal [이름,나이/먹기,자기,배변]
              ↓
           
  <<class>>  Cat    [동물등록증/꾹꾹이 하기]
  --------------------------------
  Cat cat=new Animal()
  1)Cat cat;
  {동물등록증/꾹꾺이 하기} +{이름,나이/먹기,자기,베변}
  
  2)new Animal()
  {이름,나이/먹기,자기,배변}
  
  3)만족 못 시키는 범위가 생김
  {동물등록증/꾹꾹이 하기}
  
  
  
  
  Animal ani =new Cat()
  1) Animal ani   {이름,나이/먹기,자기,배변}
  2)          Cat() → Animal()       →Object()
  {동물등록증/꾹꾹이 하기} + {이름,나이/먹기,자기,배변}
  
  
  3.자식은 부모를 담을 수 있다. (다운캐스팅)
  
  
  4.쓰는 이유는?
  -부모타입으로 자식 객체들을 관리가능
  
  Animal[] anis= {new Cat(),new Cat(),new Person(), new Person() };
  
 
 * */
 