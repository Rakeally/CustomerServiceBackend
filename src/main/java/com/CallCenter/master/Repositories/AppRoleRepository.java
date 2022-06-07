package com.CallCenter.master.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CallCenter.master.Entities.AppRole;



@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long>{
    public AppRole findByRole(String role);

}
