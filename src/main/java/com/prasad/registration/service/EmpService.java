package com.prasad.registration.service;

import java.util.List;

import com.prasad.registration.model.Employee;

public interface EmpService {
	
	List<Employee> getEmployeeData();
	int removeEmployeeData(int id);
	Employee getEmployeeData(int id);
	int updateEmployee(Employee emp);

}
