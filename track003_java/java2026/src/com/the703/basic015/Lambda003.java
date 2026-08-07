package com.the703.basic015;

class RefClass{       void method(String str) {  System.out.println(str);}  }
interface InterUsing{ void inter( RefClass c  , String str); }  

public class Lambda003 {

	public static void main(String[] args) {
		//#1.익명 클래스
		InterUsing a1= new InterUsing() {

			@Override
			public void inter(RefClass c, String str) {
				c.method(str);
				
			}
			
		};
		a1.inter(new RefClass(),"Hello:)"); //부품객체(RefClass)의 method를 사용
		//#2. 람다 ()->{} [RefClass]의 [method]를 사용
//		InterUsing a2=(RefClass c, String str)-> {
//			c.method(str);
//			
//		};
		
		
//		InterUsing a2=( c,  str)-> c.method(str);
//		a2.inter(new RefClass(),"hello :))");
		
		//#3. ::표현식(참고)
		InterUsing a3 = RefClass::method; //자오연결 1)RefClass 2)method
		a3.inter(new RefClass(),"hello :)))");
///////////////////////////////////////////////////////////
//	interface  InterBasic{  int method(int a, int b);         } 
		InterBasic basic1=(int a,int b)->{ return Math.max(a, b);};	// 두 값을 비교해서 큰 값을 내보냄
		//max static (바로사용가능)
		System.out.println(basic1.method(10,3));
		
		InterBasic basic2=(a, b)->  Math.max(a, b);//Math 부품,max 사용 static(바로사용가능)
		System.out.println(basic2.method(10,3));
		
		InterBasic basic3=  Math::max;
		System.out.println(basic3.method(10,3));
		
		InterBasic basic4= Math::min;
		System.out.println(basic4.method(4, 6));
		
		//String.compareTo
		InterString basic6 = ( a , b )-> a.compareTo(b);
		System.out.println(basic6.compare("apple", "banana"));
		//문자여7ㄹ이 같으면 0,음수 a<b a가 b보다 앞에와요 , (양수) a>b a가 b보다 뒤에 와요
		
		InterString basic7 =String::compareTo;
		System.out.println(basic6.compare("apple", "banana"));
		
		//interface  InterParse{  int parse(String s);              }
		InterParse basic8= s->Integer.parseInt(s);
		System.out.println(basic8.parse("10")+3); //13 문자열을 숫자로
		//->참조형으로 바꾸기
		InterParse basic9= Integer::parseInt;
		System.out.println(basic9.parse("10"+3));
		
		//Math::abs
		//interface  InterAbs  {  int apply(int a);                 }  
		InterAbs basic10=a-> Math.abs(a);
		System.out.println(basic10.apply(-10)); //abs :절대값으로 변경하는 기능박스
		//->참조형으로 바꾸기
		InterAbs basic11=Math::abs;
		System.out.println(basic11.apply(-10));
		
		//interface  InterPrint{  void print(String s);             }  
		InterPrint basic12=s->System.out.println(s);
		basic12.print("hello Lambda");
		
		//->참조형으로 바꾸기
		InterPrint basic13=System.out::println;
		basic13.print("hello Lambda");
		
		//interface  Ex1{  int getLength(String s);  }  
		Ex1 ex1=s->s.length();
		System.out.println(ex1.getLength("hello")); //결과 s
		//->참조형으로 바꾸기
		Ex1 ex2=String::length;
		System.out.println(ex2.getLength("hello"));
		//interface  Ex2{  void print(String s);     } 
		Ex2 ex3 =s-> System.out.println(s);
		ex3.print("lambda:");
		//->참조형으로 바꾸기
		Ex2 ex4= System.out::println;
		ex4.print("lambda:");
		
		
		
		
		
		
	}

}


interface  InterBasic{  int method(int a, int b);         }  
interface  InterString{ int compare(String a, String b);  }  
interface  InterParse{  int parse(String s);              }  
interface  InterAbs  {  int apply(int a);                 }  
interface  InterPrint{  void print(String s);             }  
interface  Ex1{  int getLength(String s);  }   
interface  Ex2{  void print(String s);     }  

