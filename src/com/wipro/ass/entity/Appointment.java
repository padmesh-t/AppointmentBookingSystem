package com.wipro.ass.entity;

public class Appointment {
	private String userId ,providerId , date ,timeSlot ;
	int appointmentId ;
	public Appointment(int appointmentId , String userId , String providerId , String date , String timeSlot) {
		this.appointmentId=appointmentId;
		this.userId = userId;
		this.date = date;
		this.providerId=providerId;
		this.timeSlot=timeSlot;
	}
	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	
}
