package com.the703.basic018_ex;

import javax.swing.JOptionPane;

class Count1 extends Thread {
    @Override  public void run() {
       for(int i=10; i>0; i--) {
    	   if(Thread.currentThread().isInterrupted()) {break;}
    	   
          System.out.println(i);
          try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
       } 
    }
}

//	
// class Count1 extends Thread{
//  
//	@Override
//	public void run() {
//		
//		for(int i=10;i>0;i--) {
//			System.out.println(i);
//	    
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				break;
//			}
//			
//		
//	}
//	
//}
//}


public class ThreadEx003 {

	public static void main(String[] args) {
		String info="계속 카운트 합니다";
		Thread count = new Count1();
		count.start();
		//  ##### 3. 입력받기
		String answer=JOptionPane.showInputDialog("Count STOP y/n");
		if(answer.toLowerCase().equals("y")) {
			count.interrupt(); info="count를 멈춥니다";
		}
		System.out.println(info);		
	    System.out.println(">main end...");
		
		
		
	}

}

