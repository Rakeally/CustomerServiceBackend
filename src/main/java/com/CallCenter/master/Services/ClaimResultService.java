package com.CallCenter.master.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.CallCenter.master.Entities.ClaimResult;
import com.CallCenter.master.Repositories.ClaimResultRepository;

@Service
public class ClaimResultService {

	@Autowired
	private ClaimResultRepository claimResultRepository;
	
	public ClaimResult addClaimResult(ClaimResult claimResult) {
		return claimResultRepository.save(claimResult);
	}
}
