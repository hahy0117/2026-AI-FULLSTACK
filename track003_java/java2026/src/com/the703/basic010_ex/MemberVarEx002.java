package com.the703.basic010_ex;
class Student{
	String name="홍길동";
	int kor =90;
	int eng=85;
	
	static int studentCount=0;
	
	static int total=kor+eng;
	
	static int maxScore=100;
	
	public Student() {
		studentCount++;
	}
	public int getTotalScore() {
		return kor+eng;
	}
	public static void showName() {
		System.out.println(name);
	}
	public void showInfo() {
		System.out.println("이름:"+name);
		
		System.out.println("총점:"+getTotalScore());
	}
}

public class MemberVarEx002 {

	public static void main(String[] args) {
		    Student s1 = new Student();     
	        Student s2 = new Student();    
	        
	        s1.showInfo();                  
	        Student.showStudentCount();    

		

	}

}
