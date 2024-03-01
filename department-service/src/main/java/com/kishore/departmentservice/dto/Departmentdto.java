package com.kishore.departmentservice.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kishore.departmentservice.Entity.Student;

@Component
public class Departmentdto {
	
	private Long id;
	private String departmentName;
	private List<Student> students;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Departmentdto(Long id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}
	public Departmentdto() {
	}
	
	

}
