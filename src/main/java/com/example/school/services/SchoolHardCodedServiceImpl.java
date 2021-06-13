package com.example.school.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.school.model.SchoolModel;

@Service
@Qualifier("hardCodedValues")
public class SchoolHardCodedServiceImpl implements SchoolHardCodedService {
	private static List<SchoolModel> schoolModels = new ArrayList<>();
	
	static {
		schoolModels.add(new SchoolModel(1, "Southern Illinois University Carbondale", "Carbondale"));
		schoolModels.add(new SchoolModel(2, "Dayton University", "Dayton"));
		schoolModels.add(new SchoolModel(3, "Campbellsville University", "Louisville"));
	}

	@Override
	public List<SchoolModel> getAllSchools() {
		return schoolModels;
	}

	@Override
	public Optional<SchoolModel> getSchool(Integer id) {
		if(id != null) {
			return schoolModels.stream()
						   .filter(school -> school.getId().equals(id))
						   .findAny();
		}
		return null;
	}

	@Override
	public SchoolModel saveOrUpdate(SchoolModel schoolModel) {
		if(schoolModel == null) {
			return null;
		}
		if(schoolModel.getId() == null || schoolModel.getId().equals(0)) {
			schoolModel.setId(schoolModels.size() + 1);
			schoolModels.add(schoolModel);
			
			return schoolModel;
		} else {
			deleteById(schoolModel.getId());
			schoolModels.add(schoolModel);
			
			return schoolModel;
		}
	}

	@Override
	public void deleteById(Integer id) {
		Optional<SchoolModel> schoolModel = getSchool(id);
		if(schoolModel.isPresent()) {
			schoolModels.remove(schoolModel.get());
		}
	}
}
