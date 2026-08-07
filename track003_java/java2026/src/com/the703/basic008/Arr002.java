package com.the703.basic008;

import java.util.Arrays;

public class Arr002 {

	public static void main(String[] args) {
		//배열
		//[같은타입]의 데이터 [연속된 공간에] 저장한느 자료구조
		//arr(1000번지) = 1000번지{1,2,3} 만드는거와 동시에 값넣기
		int []arr= {1,2,3,};
		
		int[]arr2=new int[3];//new 공간 빌리기 int 형태의 자료형 몇개
		System.out.println(arr2);
		System.out.println(Arrays.toString(arr2));
		
		
		
		// ver-1  arr2[0]=0; arr2[1]=10; arr2[2]=20;
		int data=0;
		arr2[0]=data;  /* 0넣고*/    data+=10;/*10증가*/
		arr2[1]=data; /*10넣고*/      data+=10;/*10증가*/
		arr2[2]=data;  /*20넣고*/     data+=10;/*10증가*/
		
		for(int i=0; i<arr2.length;i++) {System.out.println(arr2[i]+"\t");}
		
		//ver-3
		for(int i=0; i<arr2.length;i++) {
			arr2[i]=data;     data+=10;}
		
		for(int i=0; i<arr2.length;i++) {
		System.out.println(arr2[i]+"\t");
		}
	

	}

}
