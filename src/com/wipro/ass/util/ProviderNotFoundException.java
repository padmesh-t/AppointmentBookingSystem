package com.wipro.ass.util;

public class ProviderNotFoundException  extends Exception{
	@Override
	public String toString() {
		return "Provider is not registered in this system.";
	}
}
