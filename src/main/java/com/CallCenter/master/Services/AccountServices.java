package com.CallCenter.master.Services;


import java.util.Optional;

import com.CallCenter.master.Entities.AppRole;
import com.CallCenter.master.Entities.AppUser;



public interface AccountServices {

	public AppUser saveUser(AppUser u);
	public AppRole saveRole(AppRole r);
	public AppUser findUserByUsername(String username);
	public AppUser findUserByEmail(String email);
	public AppUser findUserByPack(String email);

    public Optional<AppUser> findUserByResetToken(String resetToken);
   public Optional<AppUser> findUserByactiveAccountToken(String activeAccountToken);


	public void addRoleToUser(String username, String role);
	public void save(AppUser user);}
