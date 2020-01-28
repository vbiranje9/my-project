package com.cdac.StartupProject.service;

import java.util.List;

import com.cdac.StartupProject.model.Project;
import com.cdac.StartupProject.model.Startup;

public interface StartupService {

	boolean add(Startup startup);
	Startup selectByEmail(String email);
	List<Project> selectAll();
	List<Startup> selectStp();
	int getCompanyId(String username);
	List<String> sname(List<Integer> sid);
	
}
