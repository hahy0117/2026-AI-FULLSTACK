package com.the703.basic010_ex;
class Area1{
	static double pi=3.14159;
	
	static double rect(double width, double height) {
		double rect;
		rect=width*height;
		return rect;
	}
	static double triangle(double width,double height) {
		double triangle;
		triangle=width*height/2;
		return triangle;
	}

	
}

public class StaticEx001 {

	public static void main(String[] args) {
		   System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
		   System.out.println("사각형의 면적 : " + Area1.rect(10, 5));
	       System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));
		  }
	

}
