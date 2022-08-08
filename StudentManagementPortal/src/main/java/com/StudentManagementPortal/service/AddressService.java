package com.StudentManagementPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.StudentManagementPortal.dto.AddressDto;
import com.StudentManagementPortal.entity.AddressEntity;
import com.StudentManagementPortal.entity.StudentEntity;
import com.StudentManagementPortal.repository.AddressRepository;
import com.StudentManagementPortal.repository.StudentRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressrepo;
	
	@Autowired
	StudentRepository studentrepo;
	
	public AddressEntity saveAddress(@RequestBody AddressEntity address) {
		AddressEntity save = addressrepo.save(address);
		return save;
	}
	
//	public AddressEntity Updateaddress(AddressEntity address,Long stuId) {
//	
//		StudentEntity studententity = studentrepo.findById(stuId).orElseThrow(()->new RuntimeException("student address not found"));
//		
//		List<AddressEntity> addresslist = studententity.getAddress();
//		
//		
//		for(AddressEntity add:addresslist) {
//			
//			address.setCity(add.getCity());
//			address.setCountry(add.getCountry());
//			address.setPincode(add.getPincode());
//			address.setId(add.getId());
//		}
//		
//	 AddressEntity save = addressrepo.save(address);
//	return save;
//	
//	}
	
	public AddressEntity updateAddress(Long id,AddressDto entity) {
		if(addressrepo.findById(id).isPresent()) {
			AddressEntity addressEntity = addressrepo.findById(id).get();
			addressEntity.setCity(entity.getCity());
			addressEntity.setId(entity.getId());
			addressEntity.setCountry(entity.getCountry());
			addressEntity.setPincode(entity.getPincode());
			AddressEntity save = addressrepo.save(addressEntity);
			return new AddressEntity(save.getId(),save.getCity(),save.getCountry(),save.getPincode());
			
		}else {
			return null;
		}
			
		
	}
}
