package com.cdac.StartupProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.StartupProject.dao.CompanyDaoImple;
import com.cdac.StartupProject.model.Bidding;
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

	public List<Bidding> selectStpBid() {
		// TODO Auto-generated method stub
		return compimple.selectStpBid();
	}

	@Override
	public List<String> sname(List<Integer> sid) {
		
		return compimple.sname(sid) ;
	}

	public List<String> pname(List<Integer> pid) {
		// TODO Auto-generated method stub
		return compimple.pname(pid);
	}

	@Override
	public void selectProject(int projetcId) {
		
		compimple.selectProject(projetcId);
	}
}
