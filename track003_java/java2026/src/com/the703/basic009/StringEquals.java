package com.the703.basic009;

public class StringEquals {

	public static void main(String[] args) {
		String id= "abc";//기본값 X
		String id2="abc";//참조값 o
		String id3= new String("abc");// id id2 id3 참조값(주소값)
		
		System.out.println("1)" +(id==id2));//true
		System.out.println("2)" +(id==id3));//false
		
		System.out.println(System.identityHashCode(id));
		System.out.println(System.identityHashCode(id2));
		System.out.println(System.identityHashCode(id3));
		
		System.out.println("2)" +(id.equals(id3)));//true
		
		

	}

}
