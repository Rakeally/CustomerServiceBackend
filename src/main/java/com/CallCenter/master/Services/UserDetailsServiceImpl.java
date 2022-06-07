package com.CallCenter.master.Services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.CallCenter.master.Entities.AppUser;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private AccountServices accountService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser u=accountService.findUserByUsername(username);
		
		if(u==null) throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities=new ArrayList<>();
					authorities.add(new SimpleGrantedAuthority(u.getRole().getRole()));
		return new User(u.getUsername(), u.getPassword(), authorities);

	}

	
}
