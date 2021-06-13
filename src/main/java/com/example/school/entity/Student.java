package com.example.school.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

// sub document so no need to mark as @Document
@Data
public class Student {
	@Field(name = "name")
	private String name;
	@Field(name = "currentLocation")
	private String location;
	@Field(name = "company")
	private String company;
}
