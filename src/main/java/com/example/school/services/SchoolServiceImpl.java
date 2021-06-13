package com.example.school.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;

import lombok.AllArgsConstructor;

@Service
@Qualifier("valuesFromMongoDb")
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService {

	private SchoolRepository schoolRepository;
	
	@Override
	public List<School> getAllSchools() {
		return schoolRepository.findAll();
	}

	@Override
	public Optional<School> getSchool(String id) {
		return schoolRepository.findById(id);
	}

	@Override
	public School saveOrUpdate(School school) {
		return schoolRepository.save(school);
	}

	@Override
	public void deleteById(String id) {
		schoolRepository.deleteById(id);
	}

}
