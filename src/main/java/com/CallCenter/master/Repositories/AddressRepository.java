package com.CallCenter.master.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CallCenter.master.Entities.Address;
import com.CallCenter.master.Entities.ClaimStatus;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
