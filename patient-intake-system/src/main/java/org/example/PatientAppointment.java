package org.example;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PatientAppointment {
	private String patientName;
	private LocalDateTime appointmentDateTime;
	private Doctor doctor;
}
