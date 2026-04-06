package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001 {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		int kor=0,eng=-1,math=-1,total=-1;
		double avg=0;
		String sh,scholar="학생",pass="불합격",lev="가";
		System.out.println("학번입력");
		sh=scanner.next();
		
		for(;;) {
			System.out.println("국어점수입력>");
			kor=scanner.nextInt();
			if(kor>0 && kor<100) {
				break;
			}
		}
		for(;;) {
			System.out.println("영어점수입력>");
			eng=scanner.nextInt();
			if(eng>0 && eng<100) {
				break;
			}
		}
		for(;;) {
			System.out.println("수학점수입력>");
			math=scanner.nextInt();
			if(math>0 && math<100) {
				break;
			}
		}
		total=kor+eng+math;
		avg=(double)total/3;
		
		
		
		if(avg>=60&& kor<40 && eng<40 && math<40) {
			 pass="합격";
		}else {
			pass="불합격";
		}
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
		}
		System.out.println("===============================================================");
		System.out.println("학번\t국어\t수학\t영어\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("===============================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\t",sh,kor,math,eng,total,avg,pass,lev,scholar);
			
			
		
		
		
		
		

	}
}

