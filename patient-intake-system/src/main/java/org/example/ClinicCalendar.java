package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClinicCalendar {

	private List<PatientAppointment> appointmentsList;

	public ClinicCalendar() {
		this.appointmentsList = new ArrayList<PatientAppointment>();
	}

	//add appointment 
	public void addAppointment(String patientName, String appointmentTime, String doctor) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm a");
		LocalDateTime localDateTime;
		try {
			localDateTime = LocalDateTime.parse(appointmentTime, df);
		} catch (Throwable t) {
			throw new RuntimeException("Error! Please enter with format dd-mm-yyyy hh:mm a");
		}
		Doctor doctorName = Doctor.valueOf(doctor.toLowerCase());
		PatientAppointment newAppointment = new PatientAppointment(patientName, localDateTime, doctorName);
		appointmentsList.add(newAppointment);
	}

	public List<PatientAppointment> getAppointmentsList() {
		return appointmentsList;
	}

}