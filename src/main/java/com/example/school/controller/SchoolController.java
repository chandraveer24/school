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

import com.example.school.model.School;
import com.example.school.services.SchoolService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/services/school")
public class SchoolController {
	
	private SchoolService schoolService;
	
	@GetMapping("/findAll")
	@ApiOperation(
			value = "find all schools", 
			notes = "Returns a list of schools",
			tags = {"School" }
		)
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "A list of schools", responseContainer = "List", response = School.class)
		})
	public ResponseEntity<?> getSchools() {
		List<School> schools = schoolService.getAllSchools();
		
		return new ResponseEntity<List<School>>(schools, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(
			value = "find school by id", 
			notes = "Returns a school by id",
			tags = {"School" }
		)
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "A list of schools", response = School.class)
		})
	public ResponseEntity<?> getSchool(@PathVariable Integer id) {
		System.out.println(id);
		Optional<School> school = schoolService.getSchool(id);
		
		if(school.isPresent()) {
			return new ResponseEntity<School>(school.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create")
	@ApiOperation(
			value = "find school by id", 
			notes = "Returns a school by id",
			tags = {"School" }
		)
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "A list of schools", response = School.class)
		})
	public ResponseEntity<?> addSchool(@RequestBody School school ) {
		System.out.println(school);
		
		school = schoolService.saveOrUpdate(school);
		
		if(school == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(school.getId()).toUri();
			System.out.println(uri);
			return new ResponseEntity<School>(school, HttpStatus.CREATED);
		}
	}
	
	@PutMapping("/update/{id}")
	@ApiOperation(
			value = "find school by id", 
			notes = "Returns a school by id",
			tags = {"School" }
		)
		@ApiResponses(value = {
				@ApiResponse(code = 200, message = "A list of schools", response = School.class)
		})
	public ResponseEntity<?> addSchool(@RequestBody School school, @PathVariable Integer id) {
		System.out.println(id);
		
		school = schoolService.saveOrUpdate(school);
		
		if(school == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<School>(school, HttpStatus.OK);
		}
	}
	
}
