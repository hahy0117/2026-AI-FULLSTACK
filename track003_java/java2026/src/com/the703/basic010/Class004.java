package com.the703.basic010;
//1.클래스는 부품객체
//2.클래스 상태(멤버변수)와 행위(멤버함수)
/*object            2)object(){
  ↑
 product{name,price} 2)product(){ super(); name=null,price=0 }4)
 * */
class product extends Object{//상속을 받을께,Object(클래스의 기본틀),Object 생략가능
	String name;
	int price;
	// alt+shift+s
	public product() {
		super();
		
	}// super-Object() -ctrl+alt+j (한줄)
	public product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}//this (각각의 내꺼)
	@Override
	public String toString() {
		return "product [name=" + name + ", price=" + price + "]";
	}
	
 } 

public class Class004 {	

	public static void main(String[] args) {
		product p1 = new product();//1) new 객체생성 2)생성자-초기화 3) p1 주소찾기
		System.out.println(p1); // product [name=null, price=0]
		
		product p2 = new product("아이폰17",100); //1)new 객체생성 2)생성자-초기화 3)p2 주소찾기(2번지)
		System.out.println(p2); //p2(2번지) -> 2번지:product [name=null,price=0]
	}

}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보] class product , class Class004
------------------------------------
[HEAP:동적]            |  [STACK:지역]
1번지:product  [name=null, price=0] <-p1(1번지)

                        main#2)
------------------------------------
*/
//////////////////////////////////////////////////////
