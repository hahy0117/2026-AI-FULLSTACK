package com.the703.basic006;

public class RepeatEx002 {

	public static void main(String[] args) {
		//for , while , do while 3가지 버젼으로 1~10까지 3의 배수의 합 : 18
		int sum=0;
		for(int i=1;i<=10;i++) {
			if(i%3==0) {				
				sum=sum+i;
				
			}
		}System.out.print("합은:"+sum);
		System.out.println();
		//while
		int i=1;
		int sum1=0;
		while(i<=10) {
			if(i%3==0) {
				sum1=sum1+i;
				
			}i++;
		}System.out.print("합은:"+sum);
		System.out.println();
		
		//do while
		int i1=1;
		int sum2=0;
		do {
			if(i1%3==0) {
				sum2=sum2+i;
			}
			i1++;
		}while(i1<=10);
		System.out.print("합은:"+sum);
		



	}

}
