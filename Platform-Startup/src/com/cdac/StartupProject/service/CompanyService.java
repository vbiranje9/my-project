package com.cdac.StartupProject.service;

import java.util.List;

import com.cdac.StartupProject.model.Company;
import com.cdac.StartupProject.model.Funding;
import com.cdac.StartupProject.model.Project;
import com.cdac.StartupProject.model.Login;;

public interface CompanyService {

	 void insert(Company comp);
	 boolean compLogin(Company comp);
	 boolean addProject(Project pro,Login lg);
	 List<Funding> selectStp();
}
