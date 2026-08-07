package com.the703.basic010;

//1.final 변경하지마
//2) 클래스는 부품객체
//3) 클래스(상속:X)는 상태(멤버변수:상수)와 행위(멤버함수)
// final class 재사용하지마-상속
class FinalEx extends Object{
	static final String child="5-5"; //클래스 변수 - method area- new X -this X
	String name; // 인스턴스변수 - heap area -new O- 생성자()-this
	void show() {
		System.out.println(child+"\t"+name); //인스턴스 메서드
	}
}
class FinalExSon extends FinalEx{
	@Override void show() {
		System.out.println("나한테 맞게 수정");
	}
}
//class Test extends Color{}
public class Class006_Final {

	public static void main(String[] args) {
	 //FinalEx.child="5-12"; 
	 // The final field FinalEx.child cannot be assigned
		
	}

}
/*
 final (하지마)
 
 1)클래스에 붙으면 상속 불가 (extends 사용못함)
 2)멤버변수 (상수 O/값 변경X)
 3)멤버함수 (부모기능 수정 X/@override 못함)
 
 
  */
