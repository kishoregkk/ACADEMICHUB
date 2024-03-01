package com.kishore.departmentservice.service;

import java.util.List;
import com.kishore.departmentservice.dto.Departmentdto;

public interface DepartmentService {
	
  Departmentdto createDepartment(Departmentdto departmentdto);
   
  Departmentdto deleteDepartment(long id);
  
  Departmentdto updateDepartment(long id,String depname);
  
  List<Departmentdto> getallDepartments();
}
