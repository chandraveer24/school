package com.example.school.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.school.model.SchoolModel;
import com.example.school.services.SchoolHardCodedService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/services/school")
public class SchoolHardCodedValuesController {
	
	private SchoolHardCodedService hardCodedValues;
	
	@GetMapping("/findAll")
	@ApiOperation(
			value = "find all schools", 
			notes = "Returns a list of schools",
			tags = {"SchoolModel" }
		)
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "A list of schools", responseContainer = "List", response = SchoolModel.class)
		})
	public ResponseEntity<?> getSchools() {
		List<SchoolModel> schoolModels = hardCodedValues.getAllSchools();
		
		return new ResponseEntity<List<SchoolModel>>(schoolModels, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(
			value = "find school by id", 
			notes = "Returns a school by id",
			tags = {"SchoolModel" }
		)
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "A list of schools", response = SchoolModel.class)
		})
	public ResponseEntity<?> getSchool(@PathVariable Integer id) {
		System.out.println(id);
		Optional<SchoolModel> schoolModel = hardCodedValues.getSchool(id);
		
		if(schoolModel.isPresent()) {
			return new ResponseEntity<SchoolModel>(schoolModel.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create")
	@ApiOperation(
			value = "find school by id", 
			notes = "Returns a school by id",
			tags = {"SchoolModel" }
		)
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "A list of schools", response = SchoolModel.class)
		})
	public ResponseEntity<?> addSchool(@RequestBody SchoolModel schoolModel ) {
		System.out.println(schoolModel);
		
		schoolModel = hardCodedValues.saveOrUpdate(schoolModel);
		
		if(schoolModel == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(schoolModel.getId()).toUri();
			System.out.println(uri);
			return new ResponseEntity<SchoolModel>(schoolModel, HttpStatus.CREATED);
		}
	}
	
	@PutMapping("/update/{id}")
	@ApiOperation(
			value = "find school by id", 
			notes = "Returns a school by id",
			tags = {"SchoolModel" }
		)
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "A list of schools", response = SchoolModel.class)
		})
	public ResponseEntity<?> addSchool(@RequestBody SchoolModel schoolModel, @PathVariable Integer id) {
		System.out.println(id);
		
		schoolModel = hardCodedValues.saveOrUpdate(schoolModel);
		
		if(schoolModel == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<SchoolModel>(schoolModel, HttpStatus.OK);
		}
	}
	
}
