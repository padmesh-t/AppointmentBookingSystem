APPOINTMENT SCHEDULING SYSTEM 
PROJECT OBJECTIVE
The Appointment Scheduling System manages the process of booking appointments between clients 
and service providers (doctors, consultants, technicians, trainers, etc.).
It handles user registration, provider listing, appointment slot availability, booking creation, 
cancellation, and viewing of appointment history.
A functional appointment system must:
• Prevent overlapping appointments
• Validate clients and providers
• Allow booking only during available time slots
• Maintain consistent appointment logs
• Support cancellation workflows
• Compute fees (if applicable) during booking
A. SYSTEM DESIGN
Package Name Description
com.wipro.ass.entity Contains User, Provider, and Appointment entity classes that model users, 
service providers, and scheduled appointments.
com.wipro.ass.util Contains custom exceptions related to invalid users, unavailable slots, 
missing providers, or missing appointment records.
com.wipro.ass.service
Implements the main business logic such as validating users/providers, 
checking slot availability, booking appointments, handling cancellation, and 
printing booking history.
com.wipro.ass.main Contains the Main class demonstrating example bookings and cancellations.
B. PACKAGE: com.wipro.ass.util (EXCEPTION CLASSES)
Exception Class Methods / 
Fields Description
InvalidUserException public String 
toString()
Thrown when the client/user ID does not exist in 
the system.
Exception Class Methods / 
Fields Description
ProviderNotFoundException public String 
toString()
Thrown when attempting to book an 
appointment for a provider that is not registered.
SlotUnavailableException public String 
toString()
Thrown when the requested appointment slot is 
already booked by another user.
AppointmentNotFoundException public String 
toString()
Thrown when cancellation requests refer to non￾existent appointment IDs.
AppointmentOperationException public String 
toString()
Covers invalid or inconsistent operations like 
booking with invalid date/time or duplicate 
scheduling.
C. PACKAGE: com.wipro.ass.entity
Class: User
Class Fields / Methods Description
User private String userId Unique identifier for each client/user.
private String name User’s full name.
private String contactNumber Phone number for notifications and reminders.
Getters & Setters Safe encapsulated access to user data.
Class: Provider
Class Fields / Methods Description
Provider private String providerId Unique ID assigned to each service provider.
private String providerName Name of the provider (doctor, consultant, etc.).
private String specialty Field of expertise (e.g., Dentist, IT Consultant).
Getters & Setters Structured access to provider details.
Class: Appointment
Class Fields / Methods Description
Appointment private String 
appointmentId Unique identifier for each scheduled appointment.
private String userId User who booked the appointment.
private String providerId Provider assigned for that appointment.
private String date Appointment date.
private String timeSlot Scheduled time slot (e.g., “2 PM – 3 PM”).
Getters & Setters Provide clean and consistent access to appointment 
information.
D. PACKAGE: com.wipro.ass.service
FULLY ELABORATED SERVICE CLASS (Medium-Length Descriptions)
Class Methods / Members Description
AppointmentService
Constructor
AppointmentService(ArrayList<User> 
users, ArrayList<Provider> providers, 
ArrayList<Appointment> appointments)
Initializes the scheduling system by 
loading users, providers, and prior 
appointments. Ensures consistent 
reference data for all operations 
like booking, validation, and 
cancellation.
validateUser
public boolean validateUser(String 
userId)
throws InvalidUserException
Checks if the user exists. Throws 
InvalidUserException if not found. 
Ensures only registered users can 
schedule appointments.
findProvider
public Provider findProvider(String 
providerId)
throws ProviderNotFoundException
Retrieves the provider based on 
providerId. Throws exception if 
provider does not exist. Ensures 
bookings are always tied to valid 
service providers.
checkSlotAvailability
public boolean 
checkSlotAvailability(String providerId, 
String date, String timeSlot)
throws SlotUnavailableException
Checks existing appointments to 
ensure the provider is free during 
the specified date and time. 
Throws SlotUnavailableException if 
a conflict is found.
bookAppointment
public Appointment 
Full booking workflow: validate 
user → validate provider → check 
Class Methods / Members Description
bookAppointment(String userId, String 
providerId, String date, String timeSlot)
throws Exception
slot → generate appointmentId → 
create and store the appointment. 
Prevents scheduling conflicts and 
keeps appointment history 
organized.
cancelAppointment
public void cancelAppointment(String 
appointmentId)
throws AppointmentNotFoundException
Searches for the appointment and 
removes it from the list. Throws 
exception if appointmentId is 
invalid. Frees the provider’s slot for 
future use.
printUserAppointments
public void 
printUserAppointments(String userId)
Displays all appointments booked 
by the user, including date, time, 
and provider details. Useful for 
user history and reminders.
printProviderSchedule
public void printProviderSchedule(String 
providerId, String date)
Shows all appointments for a 
provider on the selected date, 
helping manage their daily 
timetable.
