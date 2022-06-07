package com.CallCenter.master.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CallCenter.master.Entities.Claims;

@Repository
public interface ClaimRepository extends JpaRepository<Claims, Long> {

	public Claims findByIdAndCustomerId(Long ClaimId, Long customerId);
	
	public Claims findByUniqueId(String uniqueId);
	
	public List<Claims> findByClaimStatusId(Long Id);
	
	public List<Claims> findByCustomerId(Long Id);
}
