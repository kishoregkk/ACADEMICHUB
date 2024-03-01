package com.kishore.departmentservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kishore.departmentservice.Entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>{

}
