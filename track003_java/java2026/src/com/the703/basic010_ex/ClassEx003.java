package com.the703.basic010_ex;


class Coffee{
	String name;
	int price,num;
	
	void show() {
		System.out.println("=====커피");
		System.out.println("커피명:"+name);
		System.out.println("커피잔수:"+num);
		System.out.println("커피가격:"+price*num);
	}
	public Coffee(){
		name="아메리카노";
		num=1;
		price=2000;
	}
	public Coffee(String name,int num,int price) {
		this.name=name;
		this.num=num;
		this.price=price;
		
		
		
		
	}
	
}
 

public class ClassEx003 {

	public static void main(String[] args) {
		Coffee a1 = new Coffee("까페라떼" ,2 , 4000); 
		a1.show();
		Coffee a2 = new Coffee();                     
		a2.show();

	}

}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보] class Coffee  ,class Coffee
------------------------------------
[HEAP:동적]            |  [STACK:지역]
1번지:{name="까페라떼",num=2,price=4000,show()} <-a1 [1번지]
                                              main#2
                                              
------------------------------------
*/
//////////////////////////////////////////////////////
