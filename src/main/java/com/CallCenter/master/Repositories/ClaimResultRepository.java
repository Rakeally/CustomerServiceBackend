package com.CallCenter.master.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CallCenter.master.Entities.ClaimResult;

@Repository
public interface ClaimResultRepository extends JpaRepository<ClaimResult, Long> {


}
