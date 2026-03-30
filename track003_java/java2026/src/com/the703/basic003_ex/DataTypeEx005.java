package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx005 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int kor=-1,eng=-1,math=-1,total=-1;
		double avg=0;
		
		System.out.println("국어점수를 입력하세요>");
		kor=sc.nextInt();
		System.out.println("영어점수를 입력하세요>");
		eng=sc.nextInt();
		System.out.println("수학점수를 입력하세요>");
		math=sc.nextInt();
		total=(kor+eng+math);
		avg=total / 3f;
		System.out.println("총점은"+total+"입니다");
		System.out.println("평균은"+avg+"입니다");
		System.out.printf("평균은: %.2f",avg);
		System.out.println("총점 :"+total+"\n평균:"+avg+"\n");
		
	}

}
