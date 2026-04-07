package com.the703.basic005_ex;

public class ForEx004 {

	public static void main(String[] args) {
		int num2=-1;
		int sum=0;
	
		for(int num=1;num<=10;num++) {
			
			if(num%3==0) {
				sum=sum+1;
//			System.out.println(sum +"="+ sum +"+"+1);
				
				//0=	0+ 3
				//3=	3+ 6
				//6=	6+ 9
				System.out.println("3의배수:"+num);
			}
			
		}
		System.out.println("갯수는:"+sum);

	}

}
