package com.cg.calltaxiapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.calltaxiapp.entity.Admin;
import com.cg.calltaxiapp.exception.InvalidLoginException;
import com.cg.calltaxiapp.repository.AdminRepository;
import com.cg.calltaxiapp.specification.AdminSpecification;

@Service
public class AdminService implements AdminSpecification {

	@Autowired
	private AdminRepository adminRepo;

	public boolean verifyAdmin(Admin admin) {

		Optional<Admin> email = adminRepo.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
		if (email.isPresent())
			return true;
		throw new InvalidLoginException("Invalid Login ", "admin");
	}
}
