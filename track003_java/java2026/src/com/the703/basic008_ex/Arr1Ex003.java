package com.the703.basic008_ex;

public class Arr1Ex003 {

	public static void main(String[] args) {
		char [] ch = new char[52];
		int count=0;
			
		for(int i=0; i<26; i++) {
			ch[i]='A';
		}
		for(int i2=26; i2<52; i2++) {
			ch[i2]='a';
		}
		for(int i=0; i<ch.length; i++) {
			if(ch[i]=='A'||ch[i]=='I'||ch[i]=='O'||ch[i]=='U'||ch[i]=='E') {
				count++;
			}
		}

	}

}
