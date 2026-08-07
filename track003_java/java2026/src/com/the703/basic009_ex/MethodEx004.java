package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx004 {
	public static int process_total(int kor ,int eng, int math) {
		 int total=kor+eng+math;
		return total;
	}
	public static float process_avg(int total) {
		return  total/3.0f;
	}
	public static String process_pass(float avg ,int kor,int eng,int math) {
		String pass="불합격";
		if(avg>=60&&kor>40&&eng>40&&math>40) {
			pass="합격";
		}else {
			pass="불합격";
		}
		return pass;
	}
	
	public static  String process_scholar(float avg) {
		
		String pass="학생";
		if(avg>=95) {
			pass="장학생";
		}else {
			pass="학생";
		}
		return pass;
	}
	public static String process_star(float avg) {
		String stars="";
		int aa=(int)avg/10;
		for(int i=0; i<=aa;i++) {
			stars=stars+"★";
		}return stars;
		
		
	}
	public static void  process_show(String name,int kor,int eng,int math,int total,float avg,String pass,String jang,String star) {
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
		System.out.println(" --------------------------------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\t%s\t%s",name,kor,eng,math,total,avg,pass,jang,star);
		System.out.println();
		System.out.println(" --------------------------------------------------------------------------------------------");
		
	}
	
	
	public static void main(String[] args) {
		String name  = ""; 
	      int kor, eng, math, total ;
	      float avg = 0.0f; 
	      String pass = "";
	      String jang = "";
	      String star= "";  
	      Scanner scanner = new Scanner(System.in);
	      
	      System.out.println("이름을 입력하세요>");
	      name=scanner.next();
	      System.out.println("국어점수 입력>");
	      kor=scanner.nextInt();
	      System.out.println("영어점수 입력>");
	      eng=scanner.nextInt();
	      System.out.println("수학점수 입력>");
	      math=scanner.nextInt();
	      
	      total = process_total(kor , eng, math); 
	      avg = process_avg(total); 
	      pass = process_pass(avg , kor, eng, math);  
	      jang = process_scholar(  avg   ); 
	      star = process_star(avg);
	      process_show(name, kor, eng, math, total, avg, pass, jang, star);
	       
	      
	      
	}

}
