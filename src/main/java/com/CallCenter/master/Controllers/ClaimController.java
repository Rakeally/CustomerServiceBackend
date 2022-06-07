package com.CallCenter.master.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CallCenter.master.Entities.ClaimStatus;
import com.CallCenter.master.Entities.Claims;
import com.CallCenter.master.Entities.Employee;
import com.CallCenter.master.Objects.ClaimObject;
import com.CallCenter.master.Repositories.ClaimRepository;
import com.CallCenter.master.Repositories.ClaimStatusRepository;
import com.CallCenter.master.Repositories.EmployeeRepository;
import com.CallCenter.master.Services.ClaimService;
import com.example.jpa.exception.ApiRequestException;

@RestController
@RequestMapping("/claim")
public class ClaimController {

	@Autowired
	private ClaimService claimService;
	
	@Autowired
	private ClaimRepository claimRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ClaimStatusRepository claimStatusRepository;
	
	@PostMapping("/create")
	public ClaimObject registerClaim(@RequestBody ClaimObject claimObject) {
		return claimService.createClaim(claimObject);
	}
	
	@GetMapping("/list")
	public List<Claims> listAllClaims(){
		return claimService.listAllClaims();
	}
	
	@GetMapping("/listByStatusNotAttend")
	public List<Claims> getAllClaimsNotAttended(){
		return claimRepository.findByClaimStatusId(1L);
	}
	
	@GetMapping("/listByStatusInProcess")
	public List<Claims> getAllClaimsInProcess(){
		return claimRepository.findByClaimStatusId(2L);
	}
	
	@GetMapping("/listByStatusAttended")
	public List<Claims> getAllClaimsAttended(){
		return claimRepository.findByClaimStatusId(3L);
	}
	
	@PatchMapping("/assignEmployee/{employeeId}/{claimId}")
	public Claims assignEmployeeToClaim(@PathVariable(name="employeeId") Long employeeId, @PathVariable(name="claimId") Long claimId) {
		Claims claims = claimRepository.findById(claimId).orElse(null);
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
		ClaimStatus claimStatus = claimStatusRepository.findById(2L).orElse(null);
		
		claims.setClaimStatus(claimStatus);
		claims.setEmployee(employee);
		return claimRepository.save(claims);
	}
	
	@GetMapping("/getClaimsById/{customerId}")
	public List<Claims> listClaimsByCustomerId(@PathVariable(name="customerId") Long customerId){
		return claimRepository.findByCustomerId(customerId);
	}
	
	@GetMapping("/getClaimUniqueId/{claimId}")
	public String getClaimUniqueId(@PathVariable(name="claimId") Long claimId) {
		Claims claims = claimRepository.findById(claimId).orElse(null);
		return claims.getUniqueId();
	}
	
	@PatchMapping("/updateClaimStatus/{claimId}")
	public String confirmClaimResolved(@PathVariable(name="claimId") Long claimId) {
		Optional<ClaimStatus> claimStatus = claimStatusRepository.findById(3L);
		
		Claims existClaim = claimRepository.findById(claimId).orElse(null);
		existClaim.setClaimStatus(claimStatus.get());
		claimRepository.save(existClaim);
		
		return "Claim status updated to ATTENDED";
	}
	
	@PatchMapping("/validateClaimResolved/{claimId}")
	public String customerValidateClaimResolved(@PathVariable(name="claimId") Long claimId) {
		Optional<ClaimStatus> claimStatus = claimStatusRepository.findById(4L);
		
		Claims existClaim = claimRepository.findById(claimId).orElse(null);
		existClaim.setClaimStatus(claimStatus.get());
		claimRepository.save(existClaim);
		
		return "Claim status updated to Confirm";
	}
	
	@DeleteMapping("/deleteById/{claimId}")
	public String deleteComplain(@PathVariable(name="claimId") Long claimId) {
		 Claims existClaim= claimRepository.findById(claimId).orElse(null);
		 if(existClaim==null) {
			 
				throw new ApiRequestException(" Sorry that Id doesn't exist in the claim table, try again with a valid Id!!");
		 }
		 else {
		  claimRepository.deleteById(claimId);
		  return "Claim deleted";
		 }
	}
	


	

}

 

