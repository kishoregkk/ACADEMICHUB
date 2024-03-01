package com.kishore.studentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kishore.studentservice.Enitity.Student;

public interface studentRepo extends JpaRepository<Student, Long>{

	List<Student> findByDepartmentid(long departmentid);
}                    
