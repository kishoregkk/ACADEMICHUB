package com.kishore.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.studentservice.Enitity.Student;
import com.kishore.studentservice.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	
	 @PostMapping("/create")
	 public  ResponseEntity<Student> createtheStudent(@RequestBody Student student)
	 {
		return ResponseEntity.ok(studentService.createStudent(student)) ; 
	 }
	 
	   @DeleteMapping("/delete/{id}")
	   public ResponseEntity<String>  deletetheStudent(@PathVariable long id)
	   {
		  return  ResponseEntity.ok(studentService.deleteStudent(id));
	   }
	   
	   @PutMapping("/update/{id}/{name}")
	   public ResponseEntity<Student> updatetheStudent
	   (@PathVariable long id,@PathVariable String name)
	   {
		  return   ResponseEntity.ok(studentService.updateStudent(id, name)); 
	   }
	   
	   @GetMapping("/all")
	   public ResponseEntity<List<Student>> getAllStudents()
	   {
		   return ResponseEntity.ok(studentService.getAllStudents());
	   }
	   
	   @GetMapping("/{id}")
	   public ResponseEntity<Student> findStudentById(@PathVariable long id)
	   {
		   return ResponseEntity.ok(studentService.findStudentById(id));
	   }
	   
	   @GetMapping("/depid/{departmentid}")
	   public ResponseEntity<List<Student>> findallstudentbydepid(@PathVariable long departmentid)
	   {
		   return ResponseEntity.ok(studentService.findbytheDepartmentid(departmentid));
	   }
	
	

}
