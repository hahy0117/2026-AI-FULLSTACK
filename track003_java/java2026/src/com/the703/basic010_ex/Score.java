package com.the703.basic010_ex;

public class Score{
	   private String name;
	   private int kor, eng, math , total;
	   private double aver;
	   private String p  , s  , rank;
	
	   static void info(){
		   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		   System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
		   System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\r\n"
		   		+ "");
	   }
	   void total() {
		   total=kor+eng+math;
	   }
	   void aver() {
		   aver=(double)total/3;
	   }
	   void p() {
		   if(aver>60) {
			   p="합격";
		   }else {
			   p="불합격";
		   }
	   }
	   void s() {
		   if(aver>95) {
			   s="장학생";
		   }else {
			   s="학생";
		   }
	   }

	   public Score() {
		super();		
	   }
	   

	   public Score(String name, int kor, int eng, int math, int total, double aver, String p, String s, String rank) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = total;
		this.aver = aver;
		this.p = p;
		this.s = s;
		this.rank = rank;
	   }

	 
	   
	  
}
