package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn0011 {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
	      int kor=-1,eng=-1,math=-1,total=-1;
	      double avg=0;
	      String sh,scholar="학생",lev="가";
	      
	      System.out.println("학번입력");
	      sh=scanner.next();
	      
	      
	    	  for(;;) {
	    		      if(kor<0 || kor>100) {
	    			  System.out.println("국어점수 입력>");
	    			  kor=scanner.nextInt();
	    			  continue;} // 해당 범위 아니야?,입력받아
	    		      
	    		      if(math<0 || math>100) {
	    			  System.out.println("수학점수 입력>");
	    			  math=scanner.nextInt();
	    			   continue;}//해당 범위 아니야?,입력받아
	    			   
	    			   if(eng<0 || eng>100) {
	    			  System.out.println("영어점수 입력>");
	    			  eng=scanner.nextInt();
	    			   continue;}//해당 범위 아니야?,입력받아
	    		  break;
	    		  
	    	  }
	      
	      total=kor+eng+math;
	      avg=(double)total/3;
	      
	      
	      
	     String pass= (avg>=60 && kor>=40 && math>=40 && eng>=40) ? "합격":"불합격";
	     
	      if(avg>=95) {
	         lev="수"; scholar="장학생";
	      }else if(avg>=90) {
	         lev="수";scholar="학생";
	      }else if(avg>=80) {
	         lev="우"; scholar="학생";
	      }else if(avg>=70) {
	         lev="미";         scholar="학생";
	      }else if(avg>=60) {
	         lev="양";         scholar="학생";
	      }else {
	         lev="가";         scholar="학생";
	      
	      System.out.println("===============================================================");
	      System.out.println("학번\t국어\t수학\t영어\t총점\t평균\t합격여부\t레벨\t장학생");
	      System.out.println("===============================================================");
	      System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\t",sh,kor,math,eng,total,avg,pass,lev,scholar);
	      }  
	      //for(;;){무한반복}   
	      
	      
	      
	      
	      

	   }
	



	}


