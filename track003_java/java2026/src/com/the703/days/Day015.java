package com.the703.days;

public class Day015 {

	public static void main(String[] args) {
	 for(int i=3; i>=1;i--) {
		 System.out.print(i);
	 }System.out.println();
	 
	 int i=3;
	 while(i>=1) {
		 System.out.print(i);
		 i--;
	 }System.out.println();
	 
	 int i2=3;
	 do {
		 System.out.print(i2);
		 i2--;
	 }while(i2>=1);
	 System.out.println();
	 
	 for(int i3=1; i3<=3;i3++) {
		 for(int i4=3;i4>=i3; i4--) {
			 System.out.print("★");
		 }System.out.println();
	 }
	 
	 char []arr=new char[4];
	 char ch='A';
	 for(int i5=0;i5<=3;i5++) {
		 arr[i]=ch++;
		 System.out.println(arr[i]);
	 }

	}

}
