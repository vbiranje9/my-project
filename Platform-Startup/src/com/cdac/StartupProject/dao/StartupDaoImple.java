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

import com.cdac.StartupProject.dao.StartupDao;
import com.cdac.StartupProject.model.Project;
import com.cdac.StartupProject.model.Startup;

@Repository
public class StartupDaoImple implements StartupDao {

	@Autowired
	private JdbcTemplate jt;
	
	

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public boolean add(Startup startup) {
	
			//for date
			/*String date = "'";
			date += startup.getDate();
			date += "'";*/
			//
			
			//for gstId
			String gstId = startup.getGstId();
			//
	
			String sql;
			//setAutoCommit(false);
			 sql = "select * from gst where gst_id = ? and pan =?";
			Startup st = jt.queryForObject(sql,new Object [] {startup.getGstId(),startup.getPan()},new RowMapper<Startup>(){

				@Override
				public Startup mapRow(ResultSet rs, int rowNum) throws SQLException {
					Startup temp = new Startup();
					
					temp.setGstId(rs.getString(1));
					temp.setPan(rs.getString(3));
					return temp;
				}
			
			});
		
			
			if(st == null)
				return false;
			
		System.out.println("here");
			//jdbcTemplate.update(q,new Object[] {student.getRno(),student.getStudentName(),student.getMarks(),student.getJdate()});
			String flag = "1";
			 sql = "insert into login values(?,?,?)";
			
			int i = jt.update(sql,new Object[] {
					startup.getEmail(),
					startup.getPassword(),
					flag
			});
			
			//System.out.println(sql);
			
			sql = "insert into user values(?,?,?,?,?,?)";
			System.out.println(sql);
			int j = jt.update(sql,new Object[]
					{
						startup.getName(),
						startup.getGstId(),
						startup.getContactNo(),
						startup.getEmail(),
						startup.getPassword(),
						flag
					});
			
			sql = "insert into startup(description,no_of_Employee,email,flag) values(?,?,?,?)";
			
			int k = jt.update(sql,new Object[] {
				startup.getDiscription(),
				startup.getNoOfEmployee(),
				startup.getEmail(),
				flag
			});
	
			//for startUpId
			System.out.println("inserted into startup");
			
			sql = "select * from startup where email = ?";
			Startup st1 = jt.queryForObject(sql,new Object[] {startup.getEmail()}, new RowMapper<Startup>(){

				@Override
				public Startup mapRow(ResultSet rs, int rowNum) throws SQLException {
					Startup temp = new Startup();
					temp.setStartUpId(rs.getInt(5));
					return temp;
				}
			});
			
			if(st1 == null)
				return false;
			
			System.out.println("selected from startup");
			
			int sid = st1.getStartUpId();
			System.out.println(sid);
			sql = "insert into gst_startup values(?,?,?)";
			int z = jt.update(sql, new Object [] {
				startup.getGstId(),
				sid,
				flag
				
			});
			System.out.println("inserted into gst startup");
		return true;
	}

	@Override
	public List<Project> selectAll() {
		
		List<Project> list = new ArrayList<Project>();
		System.out.println("inside select all");
		String sql= "select * from project";
		list = jt.query(sql, new ResultSetExtractor<List<Project>>(){

			@Override
			public List<Project> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Project> li = new ArrayList<Project>();
				
				while(rs.next())
				{
					Project st = new Project();
					st.setProjectName(rs.getString(2));
					st.setProjetcId(rs.getInt(1));
					li.add(st);
				}
				return li;
			}
	
		});
		System.out.println("selected project");
		return list;
	}

	@Override
	public List<Startup> selectStp() {
		
		List<Startup> list = new ArrayList<Startup>();
		System.out.println("inside select stp");
		String sql= "select * from startup";
		list = jt.query(sql, new ResultSetExtractor<List<Startup>>(){

			@Override
			public List<Startup> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Startup> li = new ArrayList<Startup>();
				
				while(rs.next())
				{
					Startup st = new Startup();
					
					st.setStartUpId(rs.getInt(5));
					st.setNoOfEmployee(rs.getInt(3));
					st.setEmail(rs.getString(4));
					st.setDiscription(rs.getString(2));
					//st.setName();
					
					li.add(st);
				}
				return li;
			}
	
		});
		System.out.println("selected stp");
		return list;
			
	}

	@Override
	public int getCompanyId(String username) {
		String sql = "select company_id from company where email =?";
		Integer id =jt.queryForObject(sql,new Object[] {username},Integer.class);
		return id.intValue();
	}
	
	@Override
	public List<String> sname(List<Integer> sid) {
		List<String>startupname  = new ArrayList<String>();
		for (Integer integer : sid) {
			String sql = "select user_name from user where email =(select email from startup where startup_id = ?)";
			String s = jt.queryForObject(sql,new Object[] {integer},String.class);
			startupname.add(s);
		}
		
		return startupname;
	}
}
