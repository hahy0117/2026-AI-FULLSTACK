package com.the703.di2;

import org.springframework.stereotype.Component;

@Component("cat")
public class Cat implements Animal{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return "Cat-sleep";
	}

	@Override
	public String sleep() {
		// TODO Auto-generated method stub
		return "Cat-eat";
	}

	@Override
	public String poo() {
		// TODO Auto-generated method stub
		return "Cat-poo";
	}

	

}
