package com.musicalapp.Service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.musicalapp.Entity.Role;
import com.musicalapp.Repository.RoleRepository;



@Service
public class RoleService {
      
	@Autowired
	private RoleRepository roleRepository;

	public Role createNewRole(Role role) {
	
		return roleRepository.save(role);
	}
}

