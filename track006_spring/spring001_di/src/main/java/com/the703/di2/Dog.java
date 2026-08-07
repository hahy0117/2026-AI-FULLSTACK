package com.the703.di2;

import org.springframework.stereotype.Component;

@Component("dog")
public class Dog implements Animal{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return "Dog-eat";
	}

	@Override
	public String sleep() {
		// TODO Auto-generated method stub
		return "Dog-sleep";
	}

	@Override
	public String poo() {
		// TODO Auto-generated method stub
		return "Dog poo";
	}

	

}
