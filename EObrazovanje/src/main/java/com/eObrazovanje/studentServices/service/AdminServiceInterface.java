package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.entity.Admin;

public interface AdminServiceInterface {

	Admin findOne(int id);
	List<Admin> findAll();
	int save(Admin valuta);
}
