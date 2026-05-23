package com.wipro.ass.main;
import java.util.ArrayList;
import com.wipro.ass.entity.*;
import com.wipro.ass.service.AppointmentService;
import com.wipro.ass.util.*;
public class Main {
	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<>();
		users.add(new User("U001", "Sanjay", "9876543210"));
		users.add(new User("U002", "Meera", "9123456780"));
		ArrayList<Provider> providers = new ArrayList<>();
		providers.add(new Provider("P001", "Dr. Kavitha", "Dentist"));
		providers.add(new Provider("P002", "Rahul Sharma", "Fitness Trainer"));
		ArrayList<Appointment> appointments = new ArrayList<>();
		AppointmentService service = new AppointmentService(users, providers, appointments);
		try {
			Appointment a1 = service.bookAppointment("U001", "P001", "2025-09-15", "2 PM - 3 PM");
			System.out.println("Appointment Scheduled: " + a1.getAppointmentId());
			System.out.println("\n--- User Appointments (U001) ---");
			service.printUserAppointments("U001");
			System.out.println("\nCancelling appointment...");
			service.cancelAppointment(a1.getAppointmentId());
			System.out.println("Appointment Cancelled!");
		} catch (InvalidUserException | ProviderNotFoundException |
			         SlotUnavailableException | AppointmentNotFoundException |
			         AppointmentOperationException ex) {
			System.out.println(ex);
		}
		catch (Exception ex) {
			System.out.println("Unexpected Error: " + ex);
			ex.printStackTrace();
		}
	}
}