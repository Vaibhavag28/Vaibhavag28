package com.cruddemo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cruddemo.entities.Student;
import com.cruddemo.repositories.StudentRepository;

@SpringBootTest
class CrudDemoApplicationTests {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Test
	void saveOneStidentInformation() {
		Student s=new Student();
		s.setName("sith");
		s.setCourse("testing");
		s.setFee(10500);
		studentRepo.save(s);
	}
	@Test
	void deleteRecord() {
		studentRepo.deleteById(6l);
	}
	
	@Test
	void getOneStudent() {
		Optional<Student> findById = studentRepo.findById(1l);
		Student student = findById.get();
		student.setCourse("testing");
		studentRepo.save(student);
		
		}
	
	@Test
	void getAllStudent() {
		Iterable<Student> students=studentRepo.findAll();
		System.out.println(students);
		for (Student student : students) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());

		}
	}
	
}
