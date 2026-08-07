package com.the703.basic008_ex;

import java.util.Arrays;

public class Array2Ex004 {

	public static void main(String[] args) {
		int[][] datas = {  {  10, 10, 10 ,10},             
                           {  20, 20, 20 ,20},     
                           {  30, 30, 30 ,30},     
		};  // 3층 4칸
		int[][] result = new int[datas.length+1][datas[0].length+1]; 
		for(int ch=0; ch<datas.length;ch++) {
			for(int kan=0; kan<datas[ch].length;kan++) {
				result[ch][kan]=datas[ch][kan];
				
				result[ch][datas[0].length]+=datas[ch][kan];
				result[datas.length][kan]+=datas[ch][kan];
				result[datas.length][datas[0].length]+=datas[ch][kan];
				
				
				
			}
			
		}
		for(int ch=0; ch<result.length;ch++) {
			for(int kan=0; kan<result[ch].length;kan++) {
				
				System.out.print(result[ch][kan]+"\t");
			}
			System.out.println();

		}
	}

}
