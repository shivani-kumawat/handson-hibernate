package org.example;

public enum Doctor {

	shivani("shivani kumawat"), chavi("chavi kumawat"), uri("uri sharma");

	private String doctorName;

	public String getDoctorName() {
		return doctorName;
	}

	private Doctor(String doctorName) {
		this.doctorName = doctorName;
	}

}
