package com.musicalapp.Service;

import java.util.List;

import com.musicalapp.Dto.UserDto;
import com.musicalapp.Entity.User;

public interface UserService {

	
	User addUsers(User user);

	List<User> findAll();

	User getUserById(Long userId);

	String deleteUserById(Long userId);

	 public void initRolesAndUser();


	public User updateUser(User user);

	String userLogin(String emailIdd, String password);




}
