package com.example.school.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "School")
// only collections should be marked with @Document, sub documents should not be marked as @Document as they are not separate collection.
public class School {

	//Marked as primary key, mongoDb has _id, _ is not required when mapping with java
	@Id
	private String id;
	// same like JPA only non matched fields should be marked with @Field but its good practice to mark all the fields.
	@Field(name = "schoolId")
	private Long schoolId;
	@Field(name = "name")
	private String name;
	@Field(name = "city")
	private String city;
	@Field(name = "student")
	private List<Student> student;
}
