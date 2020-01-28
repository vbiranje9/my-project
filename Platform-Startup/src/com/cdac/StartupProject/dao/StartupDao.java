package com.cdac.StartupProject.dao;

import java.util.List;

import com.cdac.StartupProject.model.Project;
import com.cdac.StartupProject.model.Startup;

public interface StartupDao {

	boolean add(Startup startup);
	//StartUp selectByEmail(String email);

	List<Project> selectAll();

	List<Startup> selectStp();

	int getCompanyId(String username);

	List<String> sname(List<Integer> sid);

}
