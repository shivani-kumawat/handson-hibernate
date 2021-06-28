package com.country.service;

import java.util.List;

import java.util.Optional;

import javax.persistence.OrderBy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.repository.ICountryRepository;
import com.country.CountryApplication;
import com.country.entity.Country;

@Service("con")
public class CountryService {
	@Autowired
	public ICountryRepository coun;
	Logger logger = LoggerFactory.getLogger(CountryService.class);

	public String createCountry(Country c) {
		coun.saveAndFlush(c);
		return "added";
	}

	public List<Country> toGetAllCountry() {
		logger.info("Start : Fetching all countries");
		return coun.findAll();
	}

	public Optional<Country> findBasedOnCode(String code) {
		return coun.findById(code);
	}

	public String deleteById(String id) {
		Optional<Country> op = coun.findById(id);
		if (op.isPresent()) {
			coun.delete(op.get());
			return "deleted";
		} else {
			return "not available";
		}
	}

	public String updateCountry(Country c) {
		Optional<Country> op = coun.findById(c.getCode());
		System.out.println(c.getCode());
		if (op.isPresent()) {
			Country con = op.get();
			con.setName(c.getName());
			coun.saveAndFlush(con);
			return "updated";
		} else {
			return "Not updated";
		}
	}

	public List<Country> findByNameStarts(String string) {
		return coun.findByName(string);
	}

	public List<Country> findByPartialNameOfCountry(String str) {
		List<Country> results = coun.findByNameContaining(str);
		return results;
	}
}
