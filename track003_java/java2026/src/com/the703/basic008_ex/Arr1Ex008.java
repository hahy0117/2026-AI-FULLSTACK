package com.the703.basic008_ex;

public class Arr1Ex008 {

	public static void main(String[] args) {
		int [] su= {-3,-5,-1,-9,-7};
		int max=-9999;
		int min=9999;
		
		for(int i=0; i<su.length; i++) {
			if(su[i]>max) {
				max=su[i];
			}
			if(su[i]<min) {
				min=su[i];
			}
			
		}System.out.println("최대값:"+max+"최소값:"+min);

	}

}
