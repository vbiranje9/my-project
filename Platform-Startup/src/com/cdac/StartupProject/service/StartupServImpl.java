package com.cdac.StartupProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.StartupProject.dao.StartupDao;
import com.cdac.StartupProject.model.Project;
import com.cdac.StartupProject.model.Startup;;

@Service
public class StartupServImpl implements StartupService {

	@Autowired
	private StartupDao startupDao;
	
	
	public StartupServImpl() {
		super();
		
	}
	
	public void setStartUpDao(StartupDao startupDao) {
		this.startupDao = startupDao;
	}


	@Override
	public boolean add(Startup startup) {
	
		
		return startupDao.add(startup);
	}

	@Override
	public Startup selectByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> selectAll() {
		
		return startupDao.selectAll();
	}

	@Override
	public List<Startup> selectStp() {
		return startupDao.selectStp();
	}

	@Override
	public int getCompanyId(String username) {
		
		return startupDao.getCompanyId(username);
	}

	@Override
	public List<String> sname(List<Integer> sid) {
		
		return startupDao.sname(sid);
	}

	

	

	

}
