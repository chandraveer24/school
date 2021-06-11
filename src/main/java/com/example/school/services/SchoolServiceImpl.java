package com.example.school.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.school.model.School;

@Service
public class SchoolServiceImpl implements SchoolService {
	private static List<School> schools = new ArrayList<>();
	
	static {
		schools.add(new School(1, "Southern Illinois University Carbondale", "Carbondale"));
		schools.add(new School(2, "Dayton University", "Dayton"));
		schools.add(new School(3, "Campbellsville University", "Louisville"));
	}

	@Override
	public List<School> getAllSchools() {
		return schools;
	}

	@Override
	public Optional<School> getSchool(Integer id) {
		if(id != null) {
			return schools.stream()
						   .filter(school -> school.getId().equals(id))
						   .findAny();
		}
		return null;
	}

	@Override
	public School saveOrUpdate(School school) {
		if(school == null) {
			return null;
		}
		if(school.getId() == null || school.getId().equals(0)) {
			school.setId(schools.size() + 1);
			schools.add(school);
			
			return school;
		} else {
			deleteById(school.getId());
			schools.add(school);
			
			return school;
		}
	}

	@Override
	public void deleteById(Integer id) {
		Optional<School> school = getSchool(id);
		if(school.isPresent()) {
			schools.remove(school.get());
		}
	}
}
