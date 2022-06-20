package com.manage.college.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.college.models.Login;
import com.manage.college.repository.LoginRepo;
@Service
public class LoginSer {
	@Autowired
	private LoginRepo repo;

	public void save(Login login) {
		 repo.save(login);
	}


}

