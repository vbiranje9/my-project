package com.cdac.StartupProject.dao;

import com.cdac.StartupProject.model.Company;

public interface CompanyDao {

		public Boolean insert(Company comp);
		public Boolean compLogin(Company comp);
}
