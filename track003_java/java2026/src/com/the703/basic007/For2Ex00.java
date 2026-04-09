package com.the703.basic007;

public class For2Ex00 {
	

	public static void main(String[] args) {
		//for
		for(int i=1; i<=6; i++) {
			for(int i2=1; i2<=6; i2++) {
				if(i+i2==6) {
					System.out.println(i+"+"+i2+"="+6);
				}
			}
		}System.out.println();
		
		//while
		int i=1;
		while(i<=6) {
			for(int i2=1; i2<=6; i2++) {
				if(i+i2==6) {
					System.out.println(i+"+"+i2+"="+6);
				}
				
		}i++;
		
		
		//do while
//		int i3=1;
//		do {
//			for(int i4=1;i4<=6;i4++) {
//				if(i3+i4==6) {
//					System.out.print(i3+"+"+i4+"=6");
//				}i3++;
//			}
//			
//			System.out.println();
//		}while(i3<=6);
//			
//		 
		
		

	}

}
}
