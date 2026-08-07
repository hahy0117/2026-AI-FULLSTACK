package com.the703.basic008_ex;

public class Arr1Ex007 {

	public static void main(String[] args) {
		int []su= {-3,-5,-1,-9,-7};
		int rank=0;
		for(int i=0; i<su.length;i++) {
			if(su[i]>=su[4]) {
				rank++;
			}
		}System.out.println("등수는:"+rank);

	}

}
