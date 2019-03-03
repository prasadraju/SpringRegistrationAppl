package com.prasad.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.registration.dao.EmployeeDao;
import com.prasad.registration.dao.UserDao;
import com.prasad.registration.model.Employee;

@Service
public class EmpServiceImpl implements EmpService{

	
	@Autowired
	EmployeeDao dao;
	
	@Override
	public List<Employee> getEmployeeData() {
		
		return dao.findEmployeeData();
	}

	@Override
	public int  removeEmployeeData(int id) {
		
		return dao.deleteEmployeeData(id);
		
		
	}

	@Override
	public Employee getEmployeeData(int id) {
		
		return dao.getEmployeeData(id);
		
	}

	@Override
	public int updateEmployee(Employee emp) {
		
		return dao.updateEmployee(emp);
	}

}
