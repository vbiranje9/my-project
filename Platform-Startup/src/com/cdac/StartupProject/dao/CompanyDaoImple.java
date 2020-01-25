package com.cdac.StartupProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cdac.StartupProject.model.Company;
import com.cdac.StartupProject.model.Funding;
import com.cdac.StartupProject.model.Login;
import com.cdac.StartupProject.model.Project;


@Repository
public class CompanyDaoImple implements CompanyDao {

	@Autowired
	private JdbcTemplate template;
	
	public CompanyDaoImple() {
		super();
	}
	
	public CompanyDaoImple(JdbcTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public Boolean insert(Company comp) {
		
		String flag="2";
		
		String sql;
		
		/*String sql = "insert into company values("+comp.getCompId()+",'"+comp.getCompName()+"')";
		System.out.println(sql);
		template.update(sql);//insert,update,delete*/
		
		sql="select * from gst where gst_id=? and pan=?";
		
		Company comp2=template.queryForObject(sql, new Object[] {comp.getGstId(),comp.getPan()} , new RowMapper<Company>(){

			@Override
			public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Company temp=new Company();
				temp.setGstId(rs.getString(1));
				temp.setPan(rs.getString(3));
				return temp;
			}
			
		});
		
		//if(comp2.getGstId()==comp.getPan() && comp.getGstId()==comp.getPan()) {
				
		
		 sql= "insert into login values (?,?,?)";
		
		int a=template.update(sql, new Object[] { 
				
				comp.getEmail(),
				comp.getPassword(),
				flag
		});
		
		System.out.println(a+"inserted into login");
		
		sql= "insert into user values(?,?,?,?,?,?)";
		
		a=template.update(sql, new Object [] {
				
				comp.getEmail(),
				comp.getGstId(),
				comp.getContactNo(),
				comp.getEmail(),
				comp.getPassword(),
				flag
		});
		
		System.out.println(a+"inserted into user");
		
		
		
		sql="insert into company(description,email,flag) values(?,?,?)";
		
		a=template.update(sql, new Object [] {
				
				comp.getDescription(),
				comp.getEmail(),
				flag
		});
		
		System.out.println(a+"inserted into company");
		
		
		
		sql="select * from Company where email=?";
		Company comp1 = template.queryForObject(sql,new Object[] {comp.getEmail()}, new RowMapper<Company>(){

			@Override
			public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
				Company temp = new Company();
				temp.setCompanyId(rs.getInt(3));
				return temp;
			}
		});
		
		//if(comp1 == null);
			//return false;
		System.out.println("selected comp id from table");
		
		int cid=comp1.getCompanyId();
		
		sql="insert into gst_company values(?,?,?)";
		template.update(sql, new Object[] {
				
				comp.getGstId(),
				cid,
				flag
		});
		
		System.out.println("inserted into gst_company");
		
		
		return true;
	}

	
	@Override
	public Boolean compLogin(Company comp) {
		
		String sql;
		sql="select * from login where username=? and password=?";
		
		 Company comp1=template.queryForObject(sql, new Object[] { comp.getEmail(),comp.getPassword() }, new RowMapper<Company>() {

			@Override
			public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Company temp=new Company();
				
				temp.setEmail(rs.getString(1));
				temp.setPassword(rs.getString(2));
				
				return temp;
			}
		 });
		
		 System.out.println("username is there"+comp1.getEmail());
		 
		 if(comp.getEmail()==comp1.getEmail() && comp.getPassword()==comp1.getPassword())
			 	return true;
		 else
			 	return false;
		 
		}

	@Override
	public Boolean addProject(Project pro,Login lg) {
		
		System.out.println("into dao add project");
		
		String sql;
		sql="select company_id,flag from company where email=?";
		
		 Project pro1=template.queryForObject(sql, new Object[] { lg.getUsername() }, new RowMapper<Project>() {

			@Override
			public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Project temp=new Project();		
				temp.setComapanyId(rs.getInt(1));
				temp.setFlag(rs.getString(2));
				
				return temp;
			}
		 });
		 
		System.out.println("selected id flag"+pro1.getComapanyId()+""+pro1.getFlag());
		
		 sql= "insert into project(project_name,project_technology,project_duration,project_description,project_bid_amount,company_id,flag) "
		 		+ "values(?,?,?,?,?,?,?)";
			
			template.update(sql, new Object [] {
					
					pro.getProjectName(),
					pro.getProjectTechnology(),
					pro.getProjectDuration(),
					pro.getProjectDescription(),
					pro.getProjectBidAmount(),
					pro1.getComapanyId(),
					pro1.getFlag()
			});
		 
		 System.out.println("inserted into project");
		return true;
	}

	@Override
	public List<Funding> selectStp() {
		
		List<Funding> list = new ArrayList<Funding>();
		System.out.println("inside select stp");
		
		String sql="select *from funds";
		list = template.query(sql, new ResultSetExtractor<List<Funding>>(){

			@Override
			public List<Funding> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Funding> li = new ArrayList<Funding>();
				
				while(rs.next())
				{
					Funding st = new Funding();
					st.setStartupId(rs.getInt(2));
					st.setFundAmount(rs.getDouble(4));
					st.setFundStatus(rs.getString(5));
					st.setFundDescription(rs.getString(6));
					li.add(st);
				}
				return li;
			}
	
		});
		System.out.println("returning list");
		return list;
	}
}