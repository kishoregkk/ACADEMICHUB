package com.kishore.departmentservice.Feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kishore.departmentservice.Entity.Student;

@FeignClient("STUDENT-SERVICE")
public interface StudentClient {

	@GetMapping("student/depid/{departmentid}")
	public ResponseEntity<List<Student>>
	findallstudentbydepid(@PathVariable long departmentid);
	   
}
