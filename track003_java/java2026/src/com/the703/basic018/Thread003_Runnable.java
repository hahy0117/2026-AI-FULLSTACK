package com.the703.basic018;

class Animal{
	String name;
}
class Dog extends Animal implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}
		for(int i=0;i<5;i++){
			System.out.print("멍");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
	}
	
}

public class Thread003_Runnable {

	public static void main(String[] args) {
		Thread sound=new Thread(new Dog()); sound.start();
		
		for(int i=0;i<5;i++){
			System.out.print("◖⚆ᴥ⚆◗");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}

}
