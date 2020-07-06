package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;

public class LoggedInUserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public int id;
	public String username;
	public String password;
	public String role;
	
	public LoggedInUserDTO() {
		super();
	}

	public LoggedInUserDTO(int id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
}
