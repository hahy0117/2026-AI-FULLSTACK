package com.the703.basic017;

public class StringStringBuffer {

	public static void main(String[] args) {
		//#1. String
		String str="ABC";
		System.out.println("1.str주소 >"+str+" "+System.identityHashCode(str));
		//                              1.str 주소>ABC 1521118594
		str+="D";
		System.out.println("2.str주소>"+str+" "+System.identityHashCode(str));
		//                             2.str주소 >ABCD 1156060786
		
		//#2.StringBuffer
		StringBuffer sb=new StringBuffer();
		sb.append("ABC");
		System.out.println("3.str주소>"+sb+" "+System.identityHashCode(str));
		
		sb.append("D");
		System.out.println("4.sb주소>"+sb+" "+System.identityHashCode(str));
		
		
		

	}

}
/*
Network

1)web (http 통신) -Jsp (java+html) ->Spring
2)socket

 

 */
 