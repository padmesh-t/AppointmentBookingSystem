package com.wipro.ass.service;
import com.wipro.ass.entity.*;
import com.wipro.ass.util.*;
import java.util.*;
public class AppointmentService {
	private ArrayList<User> users;
	private ArrayList<Provider> providers;
	private ArrayList<Appointment> appointments;
	public AppointmentService(ArrayList<User> users, ArrayList<Provider> providers, ArrayList<Appointment> appointments){
		this.users = users;
		this.appointments =appointments;
		this.providers = providers;
	}
	public boolean validateUser(String userId)throws InvalidUserException{
		for(User i: users) {
			if(i.getUserId().equals(userId)) return true ;
		}
		throw new InvalidUserException();
	}
	public Provider findProvider(String providerId)throws ProviderNotFoundException{
		for(Provider i: providers) {
			if(i.getProviderId().equals(providerId)) return i ;
		}
		throw new ProviderNotFoundException();
	}
	
	public boolean checkSlotAvailability(String providerId, String date, String timeSlot)throws SlotUnavailableException{
		try {
			Provider p = findProvider(providerId);
			int[] requestedRange = parseSlotTo24Hour(timeSlot);
	        int reqStart = requestedRange[0];
	        int reqEnd = requestedRange[1];
			for(Appointment i : appointments) {
				if (i.getProviderId().equals(providerId) && i.getDate().equals(date)) {
	                
	                // Convert existing slot (e.g., "2 PM - 4 PM") to 24h start/end ints
	                int[] existingRange = parseSlotTo24Hour(i.getTimeSlot());
	                int existStart = existingRange[0];
	                int existEnd = existingRange[1];

	                // Overlap formula: (StartA < EndB) AND (StartB < EndA)
	                if (reqStart < existEnd && existStart < reqEnd) {
	                    throw new SlotUnavailableException();
	                }
	            }
			}
		}catch(ProviderNotFoundException e) {
			e.toString();
		}
		return true;
	}
	// Helper method to convert "2 PM - 4 PM" into [14, 16]
	private int[] parseSlotTo24Hour(String slot) {
	    // Split "2 PM - 4 PM" into ["2 PM", "4 PM"]
	    String[] parts = slot.split("-");
	    int start = convertTo24Hour(parts[0].trim());
	    int end = convertTo24Hour(parts[1].trim());
	    return new int[]{start, end};
	}

	// Helper method to convert "2 PM" to 14, or "11 AM" to 11
	private int convertTo24Hour(String timeStr) {
	    // Split "2" and "PM"
	    String[] tokens = timeStr.split(" ");
	    int hour = Integer.parseInt(tokens[0]);
	    String amPm = tokens[1].toUpperCase();

	    if (amPm.equals("PM") && hour != 12) {
	        hour += 12;
	    } else if (amPm.equals("AM") && hour == 12) {
	        hour = 0; // Midnight
	    }
	    return hour;
	}
	public Appointment bookAppointment(String userId, String providerId, String date, String timeSlot)throws Exception{
		Appointment n = null;
		if(validateUser(userId) && findProvider(providerId) != null && checkSlotAvailability(providerId,date,timeSlot) ) {
			if( appointments.size() == 0 )
				n = new Appointment( 0 ,userId ,providerId , date ,timeSlot);
			else
				n = new Appointment( (appointments.get(appointments.size()-1).getAppointmentId() ) + 1 ,userId ,providerId , date ,timeSlot);
		}
		appointments.add(n);
		return n;
	}
	public void cancelAppointment(int appointmentId)throws AppointmentNotFoundException{
		Appointment n = null;
		for(Appointment i : appointments) {
			if(i.getAppointmentId() == appointmentId) n = i;
		}
		if(n == null) throw new AppointmentNotFoundException();
		else appointments.remove(n);
	}
	public void printUserAppointments(String userId) {
		for(Appointment i : appointments) {
			if(i.getUserId().equals(userId))
				System.out.println(i.getAppointmentId() +" "+ i.getProviderId() +" "+ i.getDate() +" "+ i.getTimeSlot());
		}
	}
	public void printProviderSchedule(String providerId, String date) {
		for(Appointment i : appointments) {
			if(i.getProviderId().equals(providerId) && i.getDate().equals(date))
				System.out.println(i.getAppointmentId() +" "+ i.getUserId() +" "+ i.getDate() +" "+ i.getTimeSlot());
		}
	}
}
