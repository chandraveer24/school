package com.example.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class School {
	private Integer id;
	private String name;
	private String city;
}
