package com.cdac.StartupProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdac.StartupProject.dao.LoginDao;
import com.cdac.StartupProject.model.Login;

@Repository
public class LoginDaoImple implements LoginDao{

	@Autowired
	private JdbcTemplate jt;
	
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public Login login(Login login) {
		
		System.out.println("inside login"+login.getUsername());
		String sql = "select *from login where username=? and password = ?";
		
		Login lg = jt.queryForObject(sql, new Object [] {login.getUsername(),login.getPassword()}, new RowMapper<Login>() {
			
			@Override
			public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				System.out.println("inside row mapper ");
				Login temp = new Login();
				temp.setUsername(rs.getString(1));
				temp.setPassword(rs.getString(2));
				temp.setFlag(Integer.parseInt(rs.getString(3)));
				return temp;		
				
			}
		});
		System.out.println(lg.getFlag());
		return lg;
	}

}
