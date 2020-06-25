package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.entity.Admin;
import com.eObrazovanje.studentServices.repository.AdminRepository;

@Service
public class AdminService implements AdminServiceInterface {
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin findOne(int id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id).orElse(null);
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public int save(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin).getId();
	}

}
