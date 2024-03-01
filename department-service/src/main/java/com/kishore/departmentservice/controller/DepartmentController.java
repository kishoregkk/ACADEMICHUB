package com.kishore.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.departmentservice.Entity.Department;
import com.kishore.departmentservice.Entity.Student;
import com.kishore.departmentservice.Feignclient.StudentClient;
import com.kishore.departmentservice.Mapper.DepartmentMapper;
import com.kishore.departmentservice.Repository.DepartmentRepo;
import com.kishore.departmentservice.dto.Departmentdto;
import com.kishore.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentServcie;
	
	@Autowired
	StudentClient studentClient;
	
	@Autowired
    DepartmentRepo departmentRepo;
	
	@GetMapping("/all")
	public ResponseEntity<List<Departmentdto>> getaltheDepartment()
	{
	  return ResponseEntity.ok(departmentServcie.getallDepartments());	
	}
	
	@PutMapping("/update/{id}/{depname}")
	public ResponseEntity<Departmentdto> updatetheDepartment(@PathVariable long id,@PathVariable String  depname)
	{
		return ResponseEntity.ok(departmentServcie.updateDepartment(id, depname));
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> deletetheDepartment(@PathVariable long id)
	{
		departmentServcie.deleteDepartment(id);
		return ResponseEntity.ok("Department is deleted");
	}
	
	@PostMapping("/create")
	public ResponseEntity<Departmentdto> createtheDepartment(@RequestBody
			Departmentdto departmentdto)
	{
		return  new ResponseEntity<>(
		departmentServcie.createDepartment(departmentdto),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/withstudent/{id}")
	public Departmentdto getstudentanddep(@PathVariable long id)
	{
		Department department=departmentRepo.findById(id)
				.orElseThrow(()->new RuntimeException("invalid id"));
		Departmentdto departmentdto=DepartmentMapper.departmenttodepartmentdto
				(department);
		departmentdto.setStudents( studentClient.findallstudentbydepid(id).getBody());
		return departmentdto;	
	}
	
	@GetMapping("withallstudent")
	public List<Departmentdto> getallthestduents() {
		List<Departmentdto> departmentdtoss=
				departmentServcie.getallDepartments();
		departmentdtoss.forEach
		(departmentdto-> departmentdto.setStudents
				(studentClient.findallstudentbydepid(departmentdto.getId()).getBody()));
		return departmentdtoss;
	}


}
