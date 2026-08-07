package com.the703.basic008_ex;

public class ArrayNewEx001 {

	public static void main(String[] args) {
		double [] arr= new double[5];
		double data=1.1;
		//arr[0] = 1.1;
		 
		
		for(int i =0; i<arr.length; i++) {
			arr[i]=data;   data+=0.1;
			System.out.printf("%.1f\t",arr[i]);
		}
		

	}

}
