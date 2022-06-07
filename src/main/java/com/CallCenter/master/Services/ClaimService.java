package com.CallCenter.master.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CallCenter.master.Entities.Address;
import com.CallCenter.master.Entities.AppUser;
import com.CallCenter.master.Entities.ClaimStatus;
import com.CallCenter.master.Entities.ClaimTypes;
import com.CallCenter.master.Entities.Claims;
import com.CallCenter.master.Entities.Customer;
import com.CallCenter.master.Objects.ClaimObject;
import com.CallCenter.master.Repositories.AddressRepository;
import com.CallCenter.master.Repositories.AppUserRepository;
import com.CallCenter.master.Repositories.ClaimRepository;
import com.CallCenter.master.Repositories.ClaimStatusRepository;
import com.CallCenter.master.Repositories.ClaimTypeRepository;
import com.CallCenter.master.Repositories.CustomerRepository;


@Service
public class ClaimService {

	@Autowired
	public ClaimRepository claimRepository;
	
	@Autowired
	public ClaimStatusRepository claimStatusRepository;
	
	@Autowired
	public AppUserRepository appUserRepository;
	
	@Autowired
	public ClaimTypeRepository claimTypeRepository;
	
	@Autowired
	public CustomerRepository customerRepository;
	
	@Autowired
	public AddressRepository addressRepository;
	
	public ClaimObject createClaim(ClaimObject claimObject) {
		Claims claims = new Claims();
		Optional<ClaimStatus> claimStatus = claimStatusRepository.findById(1L);
		Customer customer = customerRepository.findById(claimObject.getCustomerId()).orElse(null);
		ClaimTypes claimTypes = claimTypeRepository.findById(claimObject.getClaimTypesId()).orElse(null);
		
		claims.setClaimStatus(claimStatus.get());
		claims.setUniqueId(UUID.randomUUID().toString());
		claims.setAmount(claimObject.getAmount());
		claims.setClaimTypes(claimTypes);
		claims.setCustomer(customer);
		claims.setDescription(claimObject.getDescription());
		claims.setDateLostService(claimObject.getDateLostService());
		claims.setGasMeterReading(claimObject.getGasMeterReading());
		
		if(claimObject.getClaimTypesId() == 1L) {
			claims.setAmount(null);
			claims.setGasMeterReading(null);

		}
		else if(claimObject.getClaimTypesId() == 2L){
			claims.setDateLostService(null);
		}


		 claimRepository.save(claims);
		 

		 //Add address info
		 Address address = new Address();
		 address.setCity(claimObject.getCity());
		 address.setCountry(claimObject.getCountry());
		 address.setPostalCode(claimObject.getPostalCode());
		 address.setState(claimObject.getState());
		 address.setStreet(claimObject.getStreet());
		 addressRepository.save(address);

		 customer.setAddress(address);
		 customerRepository.save(customer);
		 
		 return claimObject;
	}
	
	public List<Claims> listAllClaims(){
		return claimRepository.findAll();
	}
	
	
}
