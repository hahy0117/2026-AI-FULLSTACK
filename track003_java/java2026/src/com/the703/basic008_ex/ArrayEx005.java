package com.the703.basic008_ex;

public class ArrayEx005 {

	public static void main(String[] args) {
	 char [] ch= {'B','a','n','a','n','a'};
	 int count=0;
	 int count2=0;
	 for(int i=0; i<ch.length;i++) {
		 if(ch[i]>='A'&& ch[i]<='Z') {
			 count++;
		 }else if(ch[i]>='a'&&ch[i]<='z') {
			 count2++;
		 }
	 }System.out.println("대문자 갯수:"+count);
	 System.out.println("소문자 갯수:"+count2);

	}

}
