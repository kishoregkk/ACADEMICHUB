package com.kishore.studentservice.service;

import java.util.List;

import com.kishore.studentservice.Enitity.Student;

public interface StudentService {
	
   Student createStudent(Student student);
   
   String deleteStudent(long id);
   
   Student updateStudent(long id,String name);
   
   List<Student> getAllStudents();
   
   Student findStudentById(long id);
   
   List<Student> findbytheDepartmentid(long departmentid);
                   
}
