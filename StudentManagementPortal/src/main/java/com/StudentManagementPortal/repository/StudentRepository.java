package com.StudentManagementPortal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentManagementPortal.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	
	
		Optional<StudentEntity> findByIdAndAddressId(Long studentId, Long addressId);
}
