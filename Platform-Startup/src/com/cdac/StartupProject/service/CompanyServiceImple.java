package com.cdac.StartupProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.StartupProject.dao.CompanyDaoImple;
import com.cdac.StartupProject.model.Company;
import com.cdac.StartupProject.model.Funding;
import com.cdac.StartupProject.model.Login;
import com.cdac.StartupProject.model.Project;

@Service
public class CompanyServiceImple implements CompanyService {

	@Autowired
	private CompanyDaoImple compimple;
	
	public void insert(Company comp) {
		
		compimple.insert(comp);
	}

	@Override
	public boolean compLogin(Company comp) {

		compimple.compLogin(comp);	
		return true;
	}

	@Override
	public boolean addProject(Project pro,Login lg) {
		
		return compimple.addProject(pro,lg);
	}

	@Override
	public List<Funding> selectStp() {
		
		return compimple.selectStp();
	}
}
