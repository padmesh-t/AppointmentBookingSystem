package com.wipro.ass.util;

public class InvalidUserException  extends Exception{
	@Override
	public String toString() {
		return "Client/User ID does not exist in the system";
	}
}
