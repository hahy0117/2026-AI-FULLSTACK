package com.the703.basic008_ex;

public class Array2Ex002 {

	public static void main(String[] args) {
		int [][]arr2 =new int[2][3]; //2층3칸
		int data=101;
		for(int ch=0;ch<arr2.length;ch++) {
			for(int kan=0; kan<arr2[ch].length;kan++) {
				arr2[ch][kan]=data; 
				data+=1;
				System.out.print(arr2[ch][kan]+"\t");
			}
			System.out.println();
		}
				

	}

}
