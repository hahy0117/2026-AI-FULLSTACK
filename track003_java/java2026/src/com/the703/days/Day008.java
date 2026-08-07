package com.the703.days;

import java.util.Scanner;

public class Day008 {

	public static void main(String[] args) {
		//x>=60
		//ch=='a'||ch='A'
		//ch>='0' && ch<='9'
		//ch>='A' && ch<='Z'
		Scanner scanner=new Scanner(System.in);
		int  kor=-1,math=-1,eng=-1,total;
		String sh,scholar="학생",lev="가",pass="불합격";
		double avg=0;
		System.out.println("학번을 입력하세요>");
		sh=scanner.next();
		System.out.println("국어점수 입력>");
		kor=scanner.nextInt();
		System.out.println("수학점수 입력>");
		math=scanner.nextInt();
		System.out.println("영어점수 입력>");
		eng=scanner.nextInt();
		total=kor+math+eng;
		System.out.println("총점은:"+total);
		avg=(double)total/3;
		System.out.printf("평균은:%.2f\n",avg);
		
		if(avg>=60 && kor>40 && math>40 && eng>40) {
			pass="합격";
		}else {
			pass="불합격";
		}
		if(avg>=95) {
			scholar="장학생"; lev="수";
		}else if(avg>=90) {
			scholar="학생"; lev="수";
		}else if(avg>=80) {
			scholar="학생"; lev="우";
		}else if(avg>=70) {
			scholar="학생"; lev="미";
		}else if(avg>=60) {
			scholar="학생"; lev="양";
		}else {
			scholar="학생"; lev="가";
		}
		System.out.println("===============================================================");
		System.out.println("학번\t국어\t수학\t영어\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("===============================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\t",sh,kor,math,eng,total,avg,pass,lev,scholar);
		

	}

}
