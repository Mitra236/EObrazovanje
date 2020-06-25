package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.entity.Admin;
import com.eObrazovanje.studentServices.service.AdminServiceInterface;

@RestController
@RequestMapping("api/admin")
public class AdminController {
	
	@Autowired
	AdminServiceInterface adminServiceInterface;
	
	@GetMapping
	private List<Admin> getAdmins() {
		return adminServiceInterface.findAll();
	}

}
