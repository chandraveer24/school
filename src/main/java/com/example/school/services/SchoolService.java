package com.example.school.services;

import java.util.List;
import java.util.Optional;

import com.example.school.entity.School;

public interface SchoolService {
	List<School> getAllSchools();
	Optional<School> getSchool(String id);
	School saveOrUpdate(School school);
	void deleteById(String id);
}
