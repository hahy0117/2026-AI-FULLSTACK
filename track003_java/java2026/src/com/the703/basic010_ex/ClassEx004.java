package com.the703.basic010_ex;

import java.util.Scanner;

class TV{
	String channel;
	int volume;
	void input(){
		Scanner scanner =new Scanner(System.in);
		System.out.println("채널 입력>");
		channel=scanner.next();
		System.out.println("볼륨 입력>");
		volume=scanner.nextInt();
			
	}
	public TV() {
		
	}
	public TV(String channel,int volume){
		this.channel=channel;
		this.volume=volume;
	}
	void show() {
		System.out.println("channel입력>"+channel);
		System.out.println("volume입력>"+volume);
		System.out.println(channel+":"+volume);
	}
	
}

public class ClassEx004 {

	public static void main(String[] args) {
		TV  t1 = new TV("JDBC" , 8);
		   t1.show(); 
		   TV  t2 = new TV();
		   t2.input();  
		   t2.show();

	}

}
