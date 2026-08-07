package com.company.ioctest2;

import org.springframework.stereotype.Component;

@Component("chocolate")
public class Chocolate implements IceCream{

	 @Override public String flavor() { return "Choco-flavor"; }
	 @Override public String scoop()  { return "Choco-scoop"; }
	 @Override public String melt()   { return "Choco-melt"; }
}
