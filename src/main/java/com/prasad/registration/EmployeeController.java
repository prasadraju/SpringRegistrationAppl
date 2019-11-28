package com.prasad.registration;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prasad.registration.model.Employee;
import com.prasad.registration.model.User;
import com.prasad.registration.service.EmpService;
import com.prasad.registration.service.EmpServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	EmpService service;
	
	@RequestMapping("/employee/employeelist") 
	public ModelAndView employeeList() {
		List<Employee> emplist=service.getEmployeeData();
		System.out.println("EmployeeController.employeeList()"+emplist.size());
		//return 
		return new ModelAndView("successpage","emplist",emplist);
		
	}
	
	
	
	@RequestMapping("/employee/deleteEmployee")    
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		System.out.println("EmployeeController.deleteEmployee()"+id);
		
		int status=service.removeEmployeeData(id);
		
		System.out.println("EmployeeController.deleteEmployee()"+status);
		
		//if(status>0) {
			List<Employee> emplist=service.getEmployeeData();
			//return 
			return new ModelAndView("successpage","emplist",emplist);
		//}
		
		
		//return null;
		
		
		
	}
	
	
	
	@RequestMapping("/employee/editEmployee") 
	public ModelAndView getEmployee(HttpServletRequest request) {
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		Employee emp=service.getEmployeeData(id);
		
		//return 
		return new ModelAndView("updateemployee","command",emp);
		
	}
	
	@RequestMapping(value = "/employee/updateEmployee",method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("SpringWeb") Employee employee,  ModelMap model) {
		
		
		int status=service.updateEmployee(employee);
	
		System.out.println("EmployeeController.updateEmployee()"+employee.getEMP_NAME());
		
		List<Employee> emplist=service.getEmployeeData();
		//return 
		return new ModelAndView("successpage","emplist",emplist);
	}
	
	
	
	

	
	
}
