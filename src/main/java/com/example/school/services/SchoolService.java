package com.example.school.services;

import java.util.List;
import java.util.Optional;

import com.example.school.model.School;

public interface SchoolService {
	List<School> getAllSchools();
	Optional<School> getSchool(Integer id);
	School saveOrUpdate(School school);
	void deleteById(Integer id);
}
