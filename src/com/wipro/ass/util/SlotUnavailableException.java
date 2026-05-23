package com.wipro.ass.util;

public class SlotUnavailableException  extends Exception{
	@Override
	public String toString() {
		return "The requested appointment slot is already booked by another user.";
	}
}
