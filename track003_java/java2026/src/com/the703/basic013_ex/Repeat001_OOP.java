package com.the703.basic013_ex;

public class Repeat001_OOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/*
## 📝 문제: OOP 개념(1)

다음 코드를 보고 질문에 답하시오.
Q1. OOP란 무엇인가?
-object oriented programming
-부품객체(클래스) 구성(조립)해서 프로그램밍을 구성하는 방법
-클래스는 부품객체
-객체 상태(멤버변수)와 행위(멤버메서드)

Q2. OOP의 핵심 개념은 무엇인가?
-캡슐화:외부에서 직접 접근하지 못하게보호
-다형성:한가지의 타입으로 여러타입을 관리
-상속: 클래스의 재사용
-추상화:핵심적인 기능을 단순화해서 하는 설계( abstract vs interface)

Q3. 상속도를 그리시오.
Q4. 각 객체에서 사용할 수 있는 멤버변수와 메서드를 적으시오.

Object
  ↑
Parent7 {x=100 , method()→ Parent method}  
  ↑
Child7  {x=200 , method()→ Child method }  


Q5. Parent p = new Child(); 실행 시 객체 생성, 초기화, 참조값을 설명하시오.
//1. new 객체생성,주소 /child() 초기화/p(주소값) 
 method area (정보,static,final)-Parent.class, Chile.class, Repeat001_oop.class
 heap                    stack 
 
 #4) child()→Parent()→Object()
 Object(){    }
 Parent(){x=100 , method()→ Parent method}  
 Chile (){x=200 , method()→ Child method }  
 
 #3)new 1번지)Parent{x=100,method()}   ->p [1번지] #5
                                          [main]#2)
 
                        
 



Q6. Parent 클래스의 멤버변수/메서드의 종류와 메모리 구조를 설명하시오.
int x = 100 멤버변수 인스턴스변수-heap area-new-생성자-this 각각
void method() { System.out.println("Child method"); } 인스턴스 메서드

Q7. 출력 결과를 쓰시오.
- p.x의 값은?  100
- p.method() 실행 시 어떤 메서드가 호출되는가?  Child method
- c.x의 값은?  200
- c.method() 실행 시 어떤 메서드가 호출되는가?  Child method

Q8. @Override 키워드의 의미와 코드에서 오버라이딩된 부분을 설명하시오.
부모 클래스의 메서드를 자식클래스에서 재정의 한 것
상속시 부모클래스의 메서드를 자식클래스에서 재정의
Parent의 method()가 Chile에서 오버라이딩

Q9. Child c = new Child(); 호출 시 생성자 호출 순서와 객체 생성 순서를 설명하시오.
타입 사용할수 있는 범위: Child()->Parent()->Object()
객체생성순서:Object->Parent->Child

Object 3  {                }  4
  ↑
Parent7 2 {x=100 , method()} 5 Parent
  ↑
Child7 1 {x=200 , method()} 6 Child


 
class Parent {
    int x = 100;
    void method() { System.out.println("Parent method"); }
}

class Child extends Parent {
    int x = 200;
    void method() { System.out.println("Child method"); }
}

public class Repeat001_oop {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
    }
}


*/