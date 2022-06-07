package com.CallCenter.master.Services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CallCenter.master.Entities.AppRole;
import com.CallCenter.master.Entities.AppUser;
import com.CallCenter.master.Entities.ClaimStatus;
import com.CallCenter.master.Entities.Claims;
import com.CallCenter.master.Entities.Customer;
import com.CallCenter.master.Entities.Employee;
import com.CallCenter.master.Objects.RegisterEmployee;
import com.CallCenter.master.Objects.RegistrationForm;
import com.CallCenter.master.Repositories.AppRoleRepository;
import com.CallCenter.master.Repositories.AppUserRepository;
import com.CallCenter.master.Repositories.ClaimStatusRepository;
import com.CallCenter.master.Repositories.EmployeeRepository;
import com.example.jpa.exception.ApiRequestException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AccountServicesImp accountServicesImp;
	
	@Autowired
	private AppRoleRepository appRoleRepository;
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Transactional
	public RegisterEmployee addEmployee(RegisterEmployee userInfo) throws MessagingException {
		Employee employeeExist = employeeRepository.findByEmailIgnoreCase(userInfo.getEmail());
        if (employeeExist != null) throw new ApiRequestException("This Employer already exist, try again with a different email");

		AppUser existUser = appUserRepository.findByEmailIgnoreCase(userInfo.getEmail());
        if (existUser != null) throw new ApiRequestException("This appUser already exist, try again with a different email");
        
		String password= userInfo.getPassword();
		String repassword= userInfo.getConfirmPassword();
		
		if(!password.equals(repassword)) throw new RuntimeException("Password doesn't match");
		
		//Add employer infos
		Employee employee = new Employee();
		
		employee.setName(userInfo.getFirstName() +" "+ userInfo.getLastName());
		employee.setEmail(userInfo.getEmail());
		employee.setTel(userInfo.getTel());
        employeeRepository.save(employee);
		
		 AppUser user = new AppUser();
		 AppRole role = appRoleRepository.findByRole("Employee");

        //Add user info
		 user.setUsername(employee.getEmail());
		 user.setPassword(userInfo.getPassword());
		 user.setEmployee(employee);
		 user.setToken(UUID.randomUUID().toString());
	     user.setRole(role);
	     user.setEmail(employee.getEmail());
	     user.setActive(true);
		 accountServicesImp.saveUser(user);
		
		 
		 System.out.println("User account created");

		 return userInfo;
	}
	

	public List<Employee> listEmployees(){
		
		return employeeRepository.findAll();
	}


}
