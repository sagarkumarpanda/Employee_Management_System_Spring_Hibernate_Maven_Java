package com.hpSpring.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hpSpring.model.Employee;
import com.hpSpring.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/addemployee")
	public String addEmployee(@ModelAttribute Employee emp,Model m)
	{
		String msg = "failed";
		if(service.saveEmployee(emp))
			msg="Sucessful ....";
		m.addAttribute("msg",msg);
		return "view.jsp";
		}
	
	@GetMapping("/employee")
	public String getEmployee(@RequestParam("empId") int empId, Model m)
	{
		Employee emp = service .getEmployee(empId);
		m.addAttribute("emp",emp);
		return "viewemp.jsp";
		
	}
	
	@GetMapping("/employees")
	public String getAllEmployees(Model m) {
		List<Employee> empList =service.getAllEmployee();
		m.addAttribute("empList",empList);
		return "viewAll.jsp";
	}
	
	
	@PostMapping("/delete")
	public String deleteEmp(@RequestParam("empId") int empId,Model m)
	{
		String msg = "failed";
		if(service.deleteEmployee(empId))
			msg="Sucessful ....";
		m.addAttribute("msg",msg);
		return "view.jsp";
	}
	
	
	
	
}
