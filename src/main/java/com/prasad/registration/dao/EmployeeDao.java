package com.prasad.registration.dao;

import java.util.List;

import com.prasad.registration.model.Employee;

public interface EmployeeDao {
	
	List<Employee> findEmployeeData();
	int deleteEmployeeData(int id);
	Employee getEmployeeData(int id);
	
	int updateEmployee(Employee emp);

}
