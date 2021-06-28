package com.patientIntake;

import static org.junit.Assert.assertEquals;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.example.ClinicCalendar;
import org.example.PatientAppointment;
import org.junit.Test;

public class ClinicCalendarTest {

	@Test
	public void addAppointment() {
		ClinicCalendar calendar = new ClinicCalendar();
		calendar.addAppointment("shivani", "06-06-2021 11:15 pm", "uri");

		// verifying added appointment
		List<PatientAppointment> appointments = calendar.getAppointmentsList();
		assertEquals(1, appointments.size());

		// verifying date
		PatientAppointment appointment = appointments.get(0);
		assertEquals("03-12-2021 11:11 pm",
				appointment.getAppointmentDateTime().format(DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm a")));
	}

	@Test
	public void invalidDateAppointment() {
		ClinicCalendar calendar = new ClinicCalendar();
		calendar.addAppointment("surbhi", "03/07/2020", "shivani");
	}

}
