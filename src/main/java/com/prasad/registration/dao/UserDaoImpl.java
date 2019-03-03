package com.prasad.registration.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.prasad.registration.DataSourceConfiguration;
import com.prasad.registration.model.User;



@Repository
public class UserDaoImpl implements UserDao{

//	JdbcTemplate jdbcTemplate;
	
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate=jdbcTemplate;
//	}
	
	@Autowired
    private DataSourceConfiguration dataSourceConfiguration;
	
	@Override
	public void insertUser(User user) {
		
		
		System.out.println("UserDaoImpl.insertUser()"+user.getUsername());
		JdbcTemplate template=new JdbcTemplate(dataSourceConfiguration.dataSource());
		
		template.update("INSERT INTO user (id,username, password) VALUES(?,?,?)",
                new Object[] { System.currentTimeMillis(),user.getUsername(), user.getPassword() });
	}

	@Override
	public boolean getUser(User user) {
		
		System.out.println("UserDaoImpl.getUser()");
	
		JdbcTemplate template=new JdbcTemplate(dataSourceConfiguration.dataSource());

		
		 String sql = "SELECT count(*) FROM user WHERE username = ? and password=?";
		    boolean result = false;
		    int count = template.queryForObject(sql, new Object[] { user.getUsername() ,user.getPassword()}, Integer.class);
		    if (count > 0) 
		      result = true;
		   
		    return result;
		   
		    
//			String USER_QUERY="Select * from user where username='"+user.getUsername()+"'"+ " and password='"+user.getPassword()+"'";
//			User userData=template.queryForObject(USER_QUERY, new RowMapper<User>() {
//				@Override
//				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//					User user=new User();
//					user.setUsername(rs.getString(2));
//					user.setPassword(rs.getString(3));
//					
//					
//					return user;
//				}
//				
//			});
//			
//			System.out.println("UserDaoImpl.getUser()"+userData.getUsername());
		    
		
		
	}
	
	

}
