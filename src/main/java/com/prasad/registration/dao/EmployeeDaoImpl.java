package com.prasad.registration.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.prasad.registration.DataSourceConfiguration;
import com.prasad.registration.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	
	@Autowired
    private DataSourceConfiguration dataSourceConfiguration;
	
	@Override
	public List<Employee> findEmployeeData() {
		
		String GET_EMPLOYEES="select * from employee";
		JdbcTemplate template =new JdbcTemplate(dataSourceConfiguration.dataSource());
		
		List<Employee> empList=template.query(GET_EMPLOYEES, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Employee emp=new Employee();
				emp.setEMP_ID(rs.getInt(1));
				emp.setEMP_NAME(rs.getString(2));
				emp.setEMAIL(rs.getString(3));
				emp.setADDRESS(rs.getString(4));
				emp.setPHONE(rs.getString(5));
				
				return emp;
			}
			
		});
		
		return empList;
	}

	@Override
	public int deleteEmployeeData(int id) {
		// TODO Auto-generated method stub
		
		String DELETE_EMPLOYEE="delete from employee where EMP_ID="+id;
		JdbcTemplate template =new JdbcTemplate(dataSourceConfiguration.dataSource());
		int status=template.update(DELETE_EMPLOYEE);
		System.out.println("EmployeeDaoImpl.deleteEmployeeData()"+status);
		return status;
		
	}

	@Override
	public Employee getEmployeeData(int id) {
		String GET_EMPLOYEE="select * from employee where EMP_ID = "+id;
		JdbcTemplate template =new JdbcTemplate(dataSourceConfiguration.dataSource());
		
		Employee employee=template.queryForObject(GET_EMPLOYEE, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Employee emp=new Employee();
				emp.setEMP_ID(rs.getInt(1));
				emp.setEMP_NAME(rs.getString(2));
				emp.setEMAIL(rs.getString(3));
				emp.setADDRESS(rs.getString(4));
				emp.setPHONE(rs.getString(5));
				
				return emp;
			}
			
		});
		
		return employee;
	}

	@Override
	public int updateEmployee(Employee emp) {
		System.out.println("EmployeeDaoImpl.updateEmployee()"+emp.getEMP_ID()+emp.getEMP_NAME());
		
		JdbcTemplate template =new JdbcTemplate(dataSourceConfiguration.dataSource());
		String sql = "UPDATE employee SET EMP_NAME=?, EMAIL=?, ADDRESS=? WHERE EMP_ID=?";
               
		int  status= template.update(sql, emp.getEMP_NAME(),  emp.getEMAIL(),
    		 emp.getADDRESS(),  emp.getEMP_ID());
		return status;
	}

}
