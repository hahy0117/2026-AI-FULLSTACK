package com.the703.basic006;

public class RepeatEx003 {

	public static void main(String[] args) {
		// 1~30 범위에서 3의 배수 이면서 2의배수인 숫자와 갯수를 구하는 프로그램을 작성하시오
		int sum=0;
		for(int i=1;i<=30;i++) {
			if(i%6==0) {
				sum=sum+1;
				System.out.print("3의배수 이면서 2의배수인 숫자:"+i+"\n");
			}			
		}System.out.print("갯수는:"+sum);
		System.out.println();
		
		//while
		int i=1;
		int sum1=0;
		while(i<=30) {
			if(i%6==0) {
				sum1=sum1+1;
				System.out.print("3의배수 이면서 2의배수인 숫자:"+i+"\n");
			}i++;
		}
		System.out.print("갯수는:"+sum1);
		System.out.println();
		
		//do while
		int i1=0;
		int sum2=0;
		do {
			if(i1%6==0) {
				sum2=sum2+1;
				System.out.print("3의배수 이면서 2의배수인 숫자:"+i1+"\n");
			}
			i1++;
		}while(i1<=30);
			
			System.out.print("합은:"+sum);
		
	}
	
		

}
