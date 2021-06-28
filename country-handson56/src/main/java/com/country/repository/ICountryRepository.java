package com.country.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.country.entity.Country;

public interface ICountryRepository extends JpaRepository<Country, String> {
	@Query("select s from Country s where s.name like :A%")
	public List<Country> findByName(@Param("A") String name);

	public List<Country> findByNameContaining(String string);

}
