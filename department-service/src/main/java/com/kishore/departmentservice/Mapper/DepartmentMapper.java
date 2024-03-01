package com.kishore.departmentservice.Mapper;

import com.kishore.departmentservice.Entity.Department;
import com.kishore.departmentservice.dto.Departmentdto;

public class DepartmentMapper {
	
	public static Department departmentdtotodepatment(Departmentdto departmentdto)
	{
	
		Department department= new Department
				(departmentdto.getId(),departmentdto.getDepartmentName());
		return department;
	}
	
	public static Departmentdto departmenttodepartmentdto(Department department)
	{
		Departmentdto departmentdto=new Departmentdto(department.getId(),
				department.getDepartmentName());
		return departmentdto;
	}

}
