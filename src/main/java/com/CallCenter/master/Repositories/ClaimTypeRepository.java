package com.CallCenter.master.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CallCenter.master.Entities.ClaimTypes;

@Repository
public interface ClaimTypeRepository extends JpaRepository<ClaimTypes, Long> {

}
