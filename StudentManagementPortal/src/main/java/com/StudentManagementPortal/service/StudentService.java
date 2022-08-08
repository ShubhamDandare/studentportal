package com.StudentManagementPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.StudentManagementPortal.entity.AddressEntity;
import com.StudentManagementPortal.entity.StudentEntity;
import com.StudentManagementPortal.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentrepo;
	
//	@Autowired
//	AddressEntity addressrepo;
	
	
	
	
	public List<StudentEntity> getallstudent() {
		List<StudentEntity> findAll = studentrepo.findAll();
		return findAll;
	}
	
	public StudentEntity savestudent(StudentEntity stu) {
		StudentEntity save = studentrepo.save(stu);
		return save;	
	}

	public StudentEntity findstudentbyid(Long id) {
		
		StudentEntity orElseThrow = studentrepo.findById(id).orElseThrow(()->new RuntimeException("student is not found"));
		return orElseThrow;
		
	}
	
	public StudentEntity updatestudent(@RequestBody StudentEntity stu) {
		StudentEntity save = studentrepo.save(stu);
		return save;
		
	}
	
	public AddressEntity changeaddress(AddressEntity address,Long stuId) {
		
		findstudentbyid(stuId);
		StudentEntity orElseThrow = studentrepo.findByIdAndAddressId(stuId, address.getId()).orElseThrow(()->new RuntimeException("address is not found"));
		updatestudent(orElseThrow);
		
		address.setCity(address.getCity());
		return null;
	}
	
}
