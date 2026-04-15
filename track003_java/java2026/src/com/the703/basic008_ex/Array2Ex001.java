package com.the703.basic008_ex;

public class Array2Ex001 {

	public static void main(String[] args) {
		int[][] arr2={
				{100,200,300},
				{400,500,600}
				};
		for(int ch=0; ch<arr2.length;ch++ ) {
			for(int kan=0; kan<arr2[ch].length;kan++) {
				System.out.print(arr2[ch][kan]+"\t");
			}
			System.out.println();
		}


	}

}
