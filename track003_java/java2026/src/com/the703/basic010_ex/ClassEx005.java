package com.the703.basic010_ex;



class Card{
	 int cardNum;
	 boolean isMembership;
	 @Override
	 public String toString() {
		return "Card [cardNum=" + cardNum + ", isMembership=" + isMembership + "]";
	 } 
	 
	 
}

public class ClassEx005 {

	public static void main(String[] args) {
		   Card  c1= new Card(); 
		   System.out.println(c1);  

	}

}
