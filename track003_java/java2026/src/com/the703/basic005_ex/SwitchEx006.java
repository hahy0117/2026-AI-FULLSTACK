package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx006 {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		char i;
		System.out.println("문자한개입력>");
		i=scanner.next().charAt(0);
		switch(i) {
		case 'M': System.out.println("월요일: 공부하는 날");break;
		case 'T': System.out.println("화요일: 운동하는 날");break;
		case 'W': System.out.println("수요일: 독서하는 날");break;
		case 'F': System.out.println("금요일: 영화 보는 날");break;
		case 'S': System.out.println("토요일: 여행 가는 날");break;
		case 'U': System.out.println("일요일: 휴식하는 날");break;
		
		
		}
		
	}

}
