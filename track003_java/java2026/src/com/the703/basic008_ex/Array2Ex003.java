package com.the703.basic008_ex;

public class Array2Ex003 {

	public static void main(String[] args) {
		 int[][] arr = {
				   { 1, 1, 1,},
				   { 2, 2, 2,},
				   { 3, 3, 3,},
				   { 4, 4, 4,},
				 };
		 int total=0;  double avg=0.0;
		 for(int ch=0; ch<arr.length;ch++) {
			 for(int kan=0;kan<arr[ch].length;kan++) {
				 total=arr[ch][kan]+total;
				 
			 }
		 }
		 avg=(double)total/(arr.length *arr[0].length);
		 System.out.println("총점은:"+total);
		 System.out.println("평균:"+avg);
		 


	}

}
