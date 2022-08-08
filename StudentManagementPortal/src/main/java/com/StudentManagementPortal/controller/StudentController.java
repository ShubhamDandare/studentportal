package com.StudentManagementPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagementPortal.entity.AddressEntity;
import com.StudentManagementPortal.entity.StudentEntity;
import com.StudentManagementPortal.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	
	@PostMapping("/")
	public StudentEntity savestudent(@RequestBody StudentEntity stu) {
		StudentEntity savestudent = service.savestudent(stu);
		return savestudent;
	}
	
	

}
