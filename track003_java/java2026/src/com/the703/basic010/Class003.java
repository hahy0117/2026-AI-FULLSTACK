package com.the703.basic010;

//1.클래스 부품객체
//2.클래스는 상태(멤버변수)와 행위(멤버함수)
//ctrl+alt+j 한줄정렬

class Car31{} //생성자 Car31() -컴파일러가 기본생성자를 자동생성
class Car32 extends Object{ //생성자는 초기화
	String color; //alt+shift+s -2,3,4
// public Car32() { color="white" } //기본생성자 -2)생성자를 개발자 수동으로 만들 때 자동생성취소
 public Car32(String color) { super(); this.color = color; }//필드 있는 생성자
 //상태 확인
 @Override
 public String toString() { return   color  ; } 
 }



public class Class003 {

	public static void main(String[] args) {
		Car31 car1 =new Car31(); //1.new (객체생성) 2.Car31()초기화-null,0 3.Car1 번지
		System.out.println(car1); //번지
//		
//		Car32 car2 =new Car32();
//		System.out.println(car2+"\t"+car2.color); //toString 상태
//		
		Car32 car3 =new Car32("red");
		System.out.println(car3+"\t"+car3.color);

	}

}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보] Car31.class, Car32.class, Class003.class#1
---------------------------------------------------
[HEAP:동적]            |  [STACK:지역]
3번지:Car32{ color="red" }           <-car2 [2번지]
2번지:Car32{ color=null}                       <-car1 [1번지]         
1번지:Car31{}                                     main#2
---------------------------------------------------
*/
//////////////////////////////////////////////////////
/*
 1.생성자 - new 연산자에 의해 호출 [초기화] 담당
 2.기본생성자
 -모든 클래스에 생성자가 반드시 존재
 -생성자선언을 생략시 컴파일러가 자동으로 기본생성자를 추가
 -개발자가 선언시 컴파일러가 자동생성을 취소하는 역할
 alt+shift+s
 3.형식
 class A{
 String name;
 A(){}     //기본생성자(디폴트생성자)
 A(String name){} //파라미터,알규먼트가 있는 생성자
 }
  리턴값 매서드명 (파라미터)
  X    클래스명동일
 
  
  */
 