package com.wipro.ass.util;

public class AppointmentOperationException  extends Exception{
	@Override
	public String toString() {
		return " Appointment has invalid date/time or duplicate scheduling";
	}
}
