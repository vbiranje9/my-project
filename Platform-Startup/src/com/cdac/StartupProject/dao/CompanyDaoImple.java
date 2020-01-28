package com.cdac.StartupProject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.HomesUserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cdac.StartupProject.controller.StartupController;
import com.cdac.StartupProject.model.Bidding;
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
		
		
		sql= "insert into user values(?,?,?,?,?,?)";
		
		a=template.update(sql, new Object [] {
				
				comp.getCompName(),
				comp.getGstId(),
				comp.getContactNo(),
				comp.getEmail(),
				comp.getPassword(),
				flag
		});
		
		
		
		sql="insert into company(description,email,flag) values(?,?,?)";
		
		a=template.update(sql, new Object [] {
				
				comp.getDescription(),
				comp.getEmail(),
				flag
		});
		
	
		sql="select * from Company where email=?";
		Company comp1 = template.queryForObject(sql,new Object[] {comp.getEmail()}, new RowMapper<Company>(){
			@Override
			public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
				Company temp = new Company();
				temp.setCompanyId(rs.getInt(3));
				return temp;
			}
		});
		
	
		int cid=comp1.getCompanyId();
		
		sql="insert into gst_company values(?,?,?)";
		template.update(sql, new Object[] {
				
				comp.getGstId(),
				cid,
				flag
		});
		

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
		
		 if(comp.getEmail()==comp1.getEmail() && comp.getPassword()==comp1.getPassword())
			 	return true;
		 else
			 	return false;
		 
		}

	@Override
	public Boolean addProject(Project pro,Login lg) {
		
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
		 
		return true;
	}

	@Override
	public List<Funding> selectStp() {
		
		List<Funding> list = new ArrayList<Funding>();
		
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

		return list;
	}

	
	@Override
	public List<Bidding> selectStpBid() {
		
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession sesion = sra.getRequest().getSession();
		int id = Integer.parseInt(sesion.getAttribute("id").toString());
		
		
		List<Bidding> list = new ArrayList<Bidding>();
		
		String sql="select *from bidding_details where bid_status='Applied' and company_id=?";
		list = template.query(sql, new Object[] { id } , new ResultSetExtractor<List<Bidding>>(){

			@Override
			public List<Bidding> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Bidding> li = new ArrayList<Bidding>();
				
				while(rs.next())
				{
					Bidding st = new Bidding();
					st.setBidId(rs.getInt(1));
					st.setProjectId(rs.getInt(2));
					st.setCompanyId(rs.getInt(3));
					st.setStartupId(rs.getInt(4));
					st.setBidAmount(rs.getDouble(5));
					st.setBidDuration(rs.getString(6));
					st.setBidStatus(rs.getString(7));
					st.setFlag(rs.getString(8));
					
					li.add(st);
				}
				return li;
			}
			
		});
		
		return list;
	}

	@Override
	public List<String> sname(List<Integer> sid) {
		List<String>startupname  = new ArrayList<String>();
		for (Integer integer : sid) {
			String sql = "select user_name from user where email =(select email from startup where startup_id = ?)";
			String s = template.queryForObject(sql,new Object[] {integer},String.class);
			startupname.add(s);
		}
		
		return startupname;
	}
	
	@Override
	public List<String> pname(List<Integer> pid) {
		
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession sesion = sra.getRequest().getSession();
		int id = Integer.parseInt(sesion.getAttribute("id").toString());
		 
		List<String>projectname  = new ArrayList<String>();
		
		for (Integer integer : pid) {
			
			String sql = "select project_name from project where project_id=? and company_id=?";
			String p = template.queryForObject(sql,new Object[] { integer, id },String.class);
			projectname.add(p);
		}
		return projectname;
	}
	
	@Override
	public void selectProject(int projetcId) {
		
		
		String sql="update bidding_details set bid_status='selected' where project_id=?";
		template.update(sql,new Object[] {projetcId});
		
	}
	
}