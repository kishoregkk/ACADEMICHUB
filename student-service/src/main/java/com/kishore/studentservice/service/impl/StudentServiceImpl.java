package com.kishore.studentservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishore.studentservice.Enitity.Student;
import com.kishore.studentservice.repository.studentRepo;
import com.kishore.studentservice.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	
	
	@Autowired
	studentRepo studentRepo;
	
	@Override
	public Student createStudent(Student student) {
		
		studentRepo.save(student);
		return student;
	}

	@Override
	public String deleteStudent(long id) {
		Student student=studentRepo.findById(id)
				.orElseThrow(()->new RuntimeException("give valid id"));
		studentRepo.delete(student);
		return "student is successfully deleted";
	}

	@Override
	public Student updateStudent(long id, String name) {
		Student student=studentRepo.findById(id)
				.orElseThrow(()->new RuntimeException("give valid id"));
		student.setName(name);
		studentRepo.save(student);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students=studentRepo.findAll();
		return students;
	
	}

	@Override
	public Student findStudentById(long id) {
		Student student=studentRepo.findById(id)
				.orElseThrow(()->new RuntimeException("give valid id"));
		return student;
	}

	@Override
	public List<Student> findbytheDepartmentid(long departmentid) {
		return studentRepo.findByDepartmentid(departmentid);
	}

}
