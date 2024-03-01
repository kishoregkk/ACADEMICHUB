package com.kishore.departmentservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishore.departmentservice.Entity.Department;
import com.kishore.departmentservice.Mapper.DepartmentMapper;
import com.kishore.departmentservice.Repository.DepartmentRepo;
import com.kishore.departmentservice.dto.Departmentdto;
import com.kishore.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImplementation implements DepartmentService{

	@Autowired
	DepartmentRepo departmentRepo;
	
	
	@Override
	public Departmentdto createDepartment(Departmentdto departmentdto) {
		Department department=DepartmentMapper.departmentdtotodepatment(departmentdto);
		departmentRepo.save(department);
		return DepartmentMapper.departmenttodepartmentdto(department);
	}

	@Override
	public Departmentdto deleteDepartment(long id) {
		Department department=departmentRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("invalid id"));
		departmentRepo.delete(department);
		return DepartmentMapper.departmenttodepartmentdto(department);
	}

	@Override
	public Departmentdto updateDepartment(long id, String depname) {
		Department department=departmentRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("invalid id"));
		department.setDepartmentName(depname);
		return DepartmentMapper.departmenttodepartmentdto(department);
		
	}

	@Override
	public List<Departmentdto> getallDepartments() {
		 List<Department> departments= departmentRepo.findAll();
		 return departments.stream()
		.map((department)->DepartmentMapper.departmenttodepartmentdto(department))
		.collect(Collectors.toList());
		
	}

}
