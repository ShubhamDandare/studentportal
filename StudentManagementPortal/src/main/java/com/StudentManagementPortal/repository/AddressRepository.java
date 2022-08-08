package com.StudentManagementPortal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentManagementPortal.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

//	Optional<AddressEntity> findByIdAndAddressId(Long studentId, Long addressId);

}
