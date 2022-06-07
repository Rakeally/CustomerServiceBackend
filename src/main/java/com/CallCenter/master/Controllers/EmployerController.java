package com.CallCenter.master.Controllers;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CallCenter.master.Entities.Employee;
import com.CallCenter.master.Objects.RegisterEmployee;
import com.CallCenter.master.Objects.RegistrationForm;
import com.CallCenter.master.Services.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployerController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	private RegisterEmployee createEmployee(@RequestBody RegisterEmployee registerEmployee) throws MessagingException {
		return employeeService.addEmployee(registerEmployee);
	}
	
	@GetMapping("/list")
	public List<Employee> listEmployees(){
		return employeeService.listEmployees();
	}
	
}
