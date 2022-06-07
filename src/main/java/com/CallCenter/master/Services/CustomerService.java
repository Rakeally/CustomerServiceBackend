package com.CallCenter.master.Services;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.CallCenter.master.Entities.Address;
import com.CallCenter.master.Entities.AppRole;
import com.CallCenter.master.Entities.AppUser;
import com.CallCenter.master.Entities.ClaimStatus;
import com.CallCenter.master.Entities.Claims;
import com.CallCenter.master.Entities.Customer;
import com.CallCenter.master.Objects.RegistrationForm;
import com.CallCenter.master.Repositories.AddressRepository;
import com.CallCenter.master.Repositories.AppRoleRepository;
import com.CallCenter.master.Repositories.AppUserRepository;
import com.CallCenter.master.Repositories.ClaimRepository;
import com.CallCenter.master.Repositories.ClaimStatusRepository;
import com.CallCenter.master.Repositories.CustomerRepository;
import com.example.jpa.exception.ApiRequestException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	
	@Autowired
	private AccountServicesImp accountServicesImp;
	
	@Autowired
	public ClaimRepository claimRepository;
	
	@Autowired
	public ClaimStatusRepository claimStatusRepository;

	
	@Autowired
	private AppRoleRepository appRoleRepository;
	
	@Autowired
	private AppUserRepository appUserRepository;

	
	@Transactional
	public RegistrationForm addCustomer(RegistrationForm userInfo) throws MessagingException {
		Customer customerExist = customerRepository.findByEmailIgnoreCase(userInfo.getEmail());
        if (customerExist != null) throw new ApiRequestException("This customer already exist, try again with a different email");
		AppUser existUser = appUserRepository.findByEmailIgnoreCase(userInfo.getEmail());
        if (existUser != null) throw new ApiRequestException("This appUser already exist, try again with a different email");

		String password= userInfo.getPassword();
		String repassword= userInfo.getConfirmPassword();
		
		if(!password.equals(repassword)) throw new RuntimeException("Password doesn't match");
		
		//Add customer infos
		Customer customer = new Customer();
		
        customer.setName(userInfo.getFirstName() +" "+ userInfo.getLastName());
        customer.setAccountNumber(userInfo.getAccountNumber());
        customer.setEmail(userInfo.getEmail());
        customer.setFirstName(userInfo.getFirstName());
        customer.setLastName(userInfo.getLastName());
        customer.setTaxId(userInfo.getTaxId());
        customer.setTel(userInfo.getTel());
        
        customerRepository.save(customer);
		
		 AppUser user = new AppUser();
		 AppRole role = appRoleRepository.findByRole("Customer");

        Random rand = new Random();
        System.out.println(customer.getFirstName()+ rand.nextInt(5) );

        
        //Add user info
		 user.setUsername(customer.getEmail());
		 user.setPassword(userInfo.getPassword());
		 user.setCustomer(customer);
		 user.setToken(UUID.randomUUID().toString());
	     user.setRole(role);
	     user.setEmail(customer.getEmail());
	     user.setActive(true);
		 accountServicesImp.saveUser(user);
		
		 System.out.println("User account created");
		 
		 return userInfo;
	}
	
	public List<Customer> listAllCustomers(){
		return customerRepository.findAll();
	}
	

}
