package com.wipro.ass.util;

public class AppointmentNotFoundException  extends Exception{
	@Override
	public String toString() {
		return  "Appointment Id Not Found " ;
	}
}
