package com.cdac.StartupProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.StartupProject.dao.LoginDao;
import com.cdac.StartupProject.model.Login;
import com.cdac.StartupProject.service.LoginSevice;

@Service
public class LoginServImple implements LoginSevice {

	
	@Autowired
	private LoginDao loginDao;
	
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}


	@Override
	public Login login(Login login) {
		
		return loginDao.login(login);
	}

}
