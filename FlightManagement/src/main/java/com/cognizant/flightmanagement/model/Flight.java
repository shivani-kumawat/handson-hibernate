package com.cognizant.flightmanagement.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Flight {
	@Id
	private String id;
	private String flightType;

	@OneToMany
	private List<Passenger> passengers;

	public boolean addPassenger(Passenger p) {
		return passengers.add(p);
	}

	public boolean removePassenger(Passenger p) {
		return passengers.remove(p);

	}
}
