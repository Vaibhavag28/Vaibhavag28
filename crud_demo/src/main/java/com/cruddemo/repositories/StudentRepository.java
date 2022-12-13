package com.cruddemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cruddemo.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
}
