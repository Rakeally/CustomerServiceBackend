package com.CallCenter.master.Controllers;


import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CallCenter.master.Entities.Customer;
import com.CallCenter.master.Objects.RegistrationForm;
import com.CallCenter.master.Services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public RegistrationForm createCustomer(@RequestBody RegistrationForm customer) throws MessagingException {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/listCustomers")
	public List<Customer> listAllCustomers(){
		return customerService.listAllCustomers();
	}


	
}
