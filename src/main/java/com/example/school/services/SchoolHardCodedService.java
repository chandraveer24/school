package com.example.school.services;

import java.util.List;
import java.util.Optional;

import com.example.school.model.SchoolModel;

public interface SchoolHardCodedService {
	List<SchoolModel> getAllSchools();
	Optional<SchoolModel> getSchool(Integer id);
	SchoolModel saveOrUpdate(SchoolModel schoolModel);
	void deleteById(Integer id);
}
