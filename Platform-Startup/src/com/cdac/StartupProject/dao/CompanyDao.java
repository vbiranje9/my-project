package com.cdac.StartupProject.dao;

import java.util.List;

import com.cdac.StartupProject.model.*;

public interface CompanyDao {

		 Boolean insert(Company comp);
		 Boolean compLogin(Company comp);
		 Boolean addProject(Project pro,Login lg);
		 List<Funding> selectStp();
		 List<Bidding> selectStpBid();
		 
		 List<String> sname(List<Integer> sid);
		 List<String> pname(List<Integer> pid);
		void selectProject(int projetcId);
		
}
