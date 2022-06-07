package com.CallCenter.master.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.CallCenter.master.Entities.AppRole;
import com.CallCenter.master.Entities.AppUser;
import com.CallCenter.master.Repositories.AppRoleRepository;
import com.CallCenter.master.Repositories.AppUserRepository;

import javax.transaction.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AccountServicesImp implements AccountServices {

	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private AppRoleRepository roleRepository;


	@Override
	public AppUser saveUser(AppUser u) {
		// TODO Auto-generated method stub
		AppUser resultUser = new AppUser();
		u.setPassword(new BCryptPasswordEncoder() .encode(u.getPassword()));
         resultUser = userRepository.saveAndFlush(u);
		return resultUser;
	}

	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}


	@Override
	public AppUser findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailIgnoreCase(email);
		
	}

	@Override
	public AppRole saveRole(AppRole r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser findUserByPack(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AppUser> findUserByResetToken(String resetToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<AppUser> findUserByactiveAccountToken(String activeAccountToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRoleToUser(String username, String role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(AppUser user) {
		// TODO Auto-generated method stub
		
	}

	
}
