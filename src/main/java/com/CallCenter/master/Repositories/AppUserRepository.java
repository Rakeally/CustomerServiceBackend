package com.CallCenter.master.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CallCenter.master.Entities.AppRole;
import com.CallCenter.master.Entities.AppUser;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{

	 public AppUser findByEmailIgnoreCase(String email);

	 public Optional<AppUser> findByToken(String token);

	 public AppUser findByUsername(String username);
	 
	 public List<AppUser> findByRole(AppRole appRole);
	 
}
