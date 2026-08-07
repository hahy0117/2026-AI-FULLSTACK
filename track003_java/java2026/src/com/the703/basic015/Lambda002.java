package com.the703.basic015;

import java.util.Scanner;
////////////////////////////////////////////////////////////
interface InterA2{  void   hi(); }
interface InterB2{  void   hi(String name); }
interface InterC2{  String hi(); }
interface InterD2{  String   hi(int num , String name); }   
////////////////////////////////////////////////////////////

public class Lambda002 {

	public static void main(String[] args) {
		//interface InterA2{ void hi(); 
		System.out.println("\n\n[step1] 매개변수x,리턴값x");
		//1-1. 익명객체
		InterA2 a1= new InterA2() {

			@Override
			public void hi() {
				System.out.println("hello");
				
			}};
		//1-2.  ()->{}
		InterA2 a2=()->{ System.out.println("hello2");};
		a2.hi(); 
		
		InterA2 a3=()-> System.out.println("hello3");
		a3.hi(); 
		
		//interface InterB2{void hi(String name); }
		System.out.println("\n\n[step2] 매개변수o,리턴값x");
		//2-1 익명객체 hi ! hyewon
		
		
		InterB2 b1=new InterB2() {

			@Override
			public void hi(String name) {
				System.out.println("hi"+name);
				
			};			
		}; b1.hi("sally");
		//2-2람다식 ()->{}
		InterB2 b2=(String name)->{System.out.println("hi"+name);}; b2.hi("alpha");
		
		InterB2 b3=( name)->{System.out.println("hi"+name);}; b3.hi("혜원");
		
		InterB2 b4=name->{System.out.println("hi"+name);}; b4.hi("하루");
		
		//interface InterC2{String hi();}
		System.out.println("\n\n[step3] 매개변수x,리턴값o");
		//익명객체
		//System.out.println(c1.hi() ); 출력 결과: good:day
		InterC2 c1=new InterC2() {
			@Override
			public String hi() { return "good :day";} 
		};
		System.out.println(c1.hi()); //출력결과:good: day
				
		//interface InterD2 {String hi(int num,String name);}
		System.out.println("\n\n[step4] 매개변수o,리턴값o");
		InterD2 d1=new InterD2() {

			@Override
			public String hi(int num,String name) {//별의갯수, 이름
				String star="";
				for(int i=0;i<num;i++) { star+="*";}
				return "hi"+name+star;
				
				
			};
			
		};
		
		//4-1 익명객체 hi sally
		
		 System.out.println(d1.hi(1,"sally")); //hi sally
		 System.out.println(d1.hi(2,"sally")); //hi sally
		//4-2 람다식 ()->{}
		 InterD2 d2=(int num,String name)->{
			 String star="";
			 for(int i=0;i<num;i++) {
				 star=star+"♥";
				 
			 };return "hi"+name+star; 
			
			 };
			 System.out.println(d2.hi(3,"하루"));
			 
			 InterD2 d3=(num,name)->{
				 String star="";
				 
				 for(int i=0; i<num;i++) {
					 star=star+"*";
				 }; return "hi"+name+star;
			 };System.out.println(d3.hi(3, "하루"));
			 
			 InterD2 d4=(num,name)-> "hi"+name+"*".repeat(num);
			 System.out.println(d4.hi(2, "하하"));
	}

}
