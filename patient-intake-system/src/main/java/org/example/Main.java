package org.example;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static ClinicCalendar calendar = new ClinicCalendar();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Select an option?");
		int ch = 0;
		do {
			System.out.println("\n1. Add a patient appointment" + "\n" + "2. View all appointments" + "\n" + "3. Exit");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				addPatientAppointment();
				break;
			case 2:
				viewAllAppointments();
				break;
			}
		} while (ch != 3);
	}
	
	//view all the appointments 
	private static void viewAllAppointments() {
		List<PatientAppointment> appointmentsList = calendar.getAppointmentsList();
		if (appointmentsList.isEmpty())
			System.out.println("Not available");
		else {
			for (PatientAppointment appointments : appointmentsList) {
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm a");
				String datetime = df.format(appointments.getAppointmentDateTime());
				System.out.println("Patient Name: " + appointments.getPatientName() + "\n" + "Appointment Date Time: "
						+ datetime + "\n" + "Doctor Name: " + appointments.getDoctor().getDoctorName() + "\n");
			}
		}
	}
	
	//add patient request 
	private static void addPatientAppointment() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter patient name:");
		String patientName = sc.nextLine();
		System.out.println("Enter appointment date and time (dd-mm-yyyy hh:mm a):");
		String appointmentTime = sc.nextLine();
		System.out.println("Enter doctor name:");
		String doctorName = sc.nextLine();
		try {
			calendar.addAppointment(patientName, appointmentTime, doctorName);
		} catch (Throwable t) {
			System.out.println(t.getMessage());
			return;
		}
	}
	}


