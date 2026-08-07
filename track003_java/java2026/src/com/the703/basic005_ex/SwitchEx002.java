package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx002 {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int num;
		System.out.println("숫자 하나를 입력>");
		num=scanner.nextInt();
		switch(num) {
		case 3: 
		case 4: 
		case 5: System.out.println("봄");break;
		//3/3=1(몫) 4/3=1(몫) 5/3=1(몫)
		
		case 6:
		case 7: 
		case 8: System.out.println("여름");break;
		//6/3=2(몫) 7/3=2 8/3=2
		
		case 9: 
		case 10:
		case 11: System.out.println("가을");break;
		//12/3=4(몫) 1/3=0 2/3=0
		
		case 12: 
		case 1:
		case 2: System.out.println("겨울");break;
		
		//switch(num/3){
		//case1: System.out.println("봄");
		//case 0: System.out.println("겨울");
		//case 2: System.out.println("여름");
		//case 3: System.out.println("가을");
		//case 4: System.out.println("겨울");
		
		
		}

	}

}
