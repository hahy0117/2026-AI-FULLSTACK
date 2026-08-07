package com.the703.basic006;

public class RepeatEx004 {

	public static void main(String[] args) {
	//for
		for(char a='A';a<='Z'; a++) {
			if(a%5==0) { 
				System.out.println();
				}
			System.out.print(a);
		}
		System.out.println();
		
		//while
		char a='A';
		while(a<='Z') {
			if(a%5==0) {
				System.out.println();
			}
			System.out.print(a);
			a++;
			}
		System.out.println();
		
		//do while
		char a1='A';
		do {
			if(a1%5==0) {
				System.out.println();
			}a1++;
		}while(a1<='Z');
		System.out.println();
	

	}

}
