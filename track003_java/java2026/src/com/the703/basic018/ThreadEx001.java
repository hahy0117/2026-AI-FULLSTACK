package com.the703.basic018;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

class QuestionCount extends Thread{

	@Override
	public void run() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=10; i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class ThreadEx001 {

	public static void main(String[] args) {
		Thread cnt=new QuestionCount();
		cnt.start();
		String answer=JOptionPane.showInputDialog("사과 알파벳 입력하세요.");
		//System.out.println(answer.toLowerCase().equals("apple") ? "정답":"오답");
		System.out.println(answer);
		if(answer.equals("apple")) {			
			System.out.println("정답");
		}else {
			System.out.println("노노");
		}
		
	}

}
