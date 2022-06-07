package com.CallCenter.master.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CallCenter.master.Entities.ClaimResult;
import com.CallCenter.master.Services.ClaimResultService;

@RestController
@RequestMapping("/claimResult")
public class ClaimResultController {

	@Autowired
	private ClaimResultService claimResultService;
	
	@PostMapping("/add")
	public ClaimResult addClaimResult(@RequestBody ClaimResult claimResult) {
		
		return claimResultService.addClaimResult(claimResult);
	}
}
