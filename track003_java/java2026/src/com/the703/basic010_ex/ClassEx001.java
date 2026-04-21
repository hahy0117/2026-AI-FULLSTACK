package com.the703.basic010_ex;
class Student001{
	 String name;
	 int no,kor,eng,math;
	 
	 void info() {
		 int total=0;
		 double avg=0;
		 total=(kor+eng+math);
		 avg=total/(double)3;
		 
		 System.out.println("이름은"+name);
		 System.out.println("총점"+total);
		 System.out.printf("평균 %.2f",avg);
		 
	 }
}

public class ClassEx001 {
 

	public static void main(String[] args) {
		 Student001 s1 = new Student001(); //1) new 번지,객체생성 2) 생성자-초기화 3) s1주소
		 s1.name="first";
		 s1.no=11; 
		 s1.kor=100; 
		 s1.eng=100; 
		 s1.math=99;
		 
	     s1.info();

	}

}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보]  Student001, ClassEx001 #1
------------------------------------
[HEAP:동적]            |  [STACK:지역]
1번지:Student001{               <-s1[1번지]
 name=null,no=0,kor=0,eng=0,math=0
 info()
 }
                          main #2
------------------------------------
*/
//////////////////////////////////////////////////////
