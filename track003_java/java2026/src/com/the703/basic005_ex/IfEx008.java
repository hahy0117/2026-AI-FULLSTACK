package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx008 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int kor,math,eng,total;
		String sh,pass="불합격",ch="가",ch1="";
		double avg=0;
		System.out.println("학번 입력>");
		sh=scanner.next();
		System.out.println("국어점수 입력>");
		kor=scanner.nextInt();
		System.out.println("수학점수 입력>");
		math=scanner.nextInt();
		System.out.println("영어점수 입력>");
		eng=scanner.nextInt();
		total=kor+math+eng;
		//System.out.println("총점은:"+total);
		
		avg=(double)total/3;
		System.out.printf("%.2f\n",avg);
				
		if(avg>=60 && kor<40 && math<40 && eng<40) {
			pass="합격";		 
		}else {
			pass="불합격";	
		}
		
		//pass=avg<60?"불합격":kor<40 ||eng<40 || math<40 ? "불합격":"합격";
		
		if(avg>=95) {
			ch1="장학생"; ch="수";
		}else if(avg>=90) {
			ch="수";	ch1="학생";
		}else if(avg>=80) {
			ch="우"; ch1="학생";
		}else if(avg>=70) {
			ch="미"; ch1="학생";
		}else if(avg>=60) {
			ch="양"; ch1="학생";
		}else {
			ch="가"; ch1="학생";
		}
		
		System.out.println("=========================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("=========================================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s",sh,kor,eng,math,total,avg,pass,ch,ch1);
		
		
		
	

	}

}
