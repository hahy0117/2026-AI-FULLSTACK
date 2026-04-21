package com.the703.basic010_ex;

import java.util.Scanner;

class MyPrice001{
	String name;
	int price;
	//멤버함수:void input() 입력 받는 기능/void show() 출력해주는 기능
	//1) 모든클래스는 생성자 -컴파일러가 기본 생성자를 자동생성 MyPrice
	void input() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("상품이름 입력 \n");
		name=scanner.next();
		System.out.print("상품가격 입력 \n");
		price=scanner.nextInt();
	}
	void show() {
		System.out.println("상품정보입니다 \n");
		System.out.println("상품이름:"+name+"상품가격:"+price);
		//(상품이름:%s/상품가격:%d,name,price)
	}
}

public class ClassEx002 {
	

	public static void main(String[] args) {
		MyPrice001   p1 = new MyPrice001(); //1)new 객체생성 2)Myprice001() name=null,price=0 
		//초기화 3)p1 1번주
        p1.input(); //1번지.input()
        p1.show(); // 1번지.show()

	}

}//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보]MyPrice001, ClassEx002
------------------------------------
[HEAP:동적]            |  [STACK:지역]

1번지 Myprice001(객체,object,instance}
{name=null,price,input(),show()} <- p1[1번지]
                                    main#2
------------------------------------
*/
//////////////////////////////////////////////////////
