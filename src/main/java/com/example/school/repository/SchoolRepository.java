package com.example.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.school.entity.School;

@Repository
public interface SchoolRepository extends MongoRepository<School, String> {

}
