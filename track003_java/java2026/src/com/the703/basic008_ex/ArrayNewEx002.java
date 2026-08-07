package com.the703.basic008_ex;

public class ArrayNewEx002 {

	public static void main(String[] args) {
	char [] arr=new char[5];
	char data='A';
	for(int i=0; i<arr.length;i++) {
		arr[i]=data;
		data=(char)(data+1);
		
		System.out.println(arr[i]);
	}
	//2 번째 방법
	arr[0]=data++;
	arr[1]=data++;

	}

}
