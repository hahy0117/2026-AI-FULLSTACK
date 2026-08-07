package com.the703.basic010_ex;



class Score{
	String stidid;
	int kor,eng,math,total;
	float avg;
	
	void total() {
		total=kor+eng+math;
	}
	void avg() {
	 avg=total/3.0f;
	}
	void info() {
		total();  avg();
		System.out.printf("학번\tkor\teng\tmath\ttotal\tavg\n%s\t%d\t%d\t%d\t%d\t%.2f",stidid,kor,eng,math,total,avg);
		 
		
	}
	
	public Score() {
		
	}
	
	public Score(String stidid,int kor,int eng,int math) {
		this.stidid=stidid;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
		
	}
	
}

public class ClassEx006 {

	public static void main(String[] args) {
		Score  s1= new Score("std1234" , 100, 100 , 99 ); 
		 s1.info();
			
	}

}
