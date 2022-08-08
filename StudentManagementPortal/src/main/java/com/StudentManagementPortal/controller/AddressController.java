package com.StudentManagementPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagementPortal.dto.AddressDto;
import com.StudentManagementPortal.entity.AddressEntity;
import com.StudentManagementPortal.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService service;

//	@PutMapping
//	public AddressEntity updateStudentAddress(@RequestBody AddressEntity address,Long stuId) {
//		AddressEntity updateaddress = service.Updateaddress(address, stuId);
//		return updateaddress;
//	}

	@PostMapping("/")
	public AddressEntity saveaddress(@RequestBody AddressEntity add) {
		AddressEntity saveAddress = service.saveAddress(add);
		return saveAddress;
	}

	@PutMapping(value = "{/ID}")
	public AddressEntity updateAddress(@PathVariable(value = "ID") Long id, @RequestBody AddressDto addressDto) {
		AddressEntity updateAddress = service.updateAddress(id, addressDto);
		return updateAddress;
	}
}
