package com.musicalapp.Service;

import java.util.HashSet;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.musicalapp.Entity.Role;
import com.musicalapp.Entity.User;
import com.musicalapp.Exception.UserNotFoundException;
import com.musicalapp.Repository.RoleRepository;
import com.musicalapp.Repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
//	@Autowired(required=true)
//	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private RoleRepository roleRepository;
	
	
//	@Override
//	public User registerUser(User user) {
//		user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
//        return userRepository.save(user);
//	}
//	

	@Override
	public String userLogin(String emailIdd, String password) {
		// TODO Auto-generated method stub
		User validateUser = userRepository.findByEmailId(emailIdd);
		if (validateUser == null) {
			throw new UserNotFoundException("There is no user with Id: " +emailIdd);
		}
		 String storedPassword = validateUser.getUserPassword();

		    // Logging the decrypted password for debugging
		    System.out.println("Decrypted Password: " + decryptPassword(storedPassword));

		    if (!decryptPassword(storedPassword).equals(password)) {
		        throw new UserNotFoundException("Invalid Password");
		    }
		    
		    	return "User Successfully Logged in";
		    
		    
		}

		// Utility method to decrypt the password
		private String decryptPassword(String encryptedPassword) {
		    char c;
		    for (int i = 0; i < encryptedPassword.length(); i++) {
		        c = (char) (encryptedPassword.charAt(i) - 3);
		        encryptedPassword = encryptedPassword.substring(0, i) + c + encryptedPassword.substring(i + 1);
		    }
		    return encryptedPassword;

//		//Decrypt(Shift 3) the password first and then validate it
//		String pwd = validateUser.getUserPassword();
//		char c;
//		for (int i = 0; i < pwd.length(); i++) {
//			c = (char) (pwd.charAt(i) - 3);
//			pwd = pwd.substring(0, i) + c + pwd.substring(i + 1);
//		}
//		if (!pwd.equals(userPassword)) {
//			throw new UserNotFoundException("Inalid Password");
//		}
//
//		
//		
//		//Succeded case
//		return "User Successfully Logged in";
	}

	
	@Override
	public User addUsers(User user) {
		
		return userRepository.save(user);
	}
	
	
	public void initRolesAndUser() {
		Role adminRole=new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDesc("Admin Rolesss");
		roleRepository.save(adminRole);
		
		Role userRole=new Role();
		userRole.setRoleName("user");
		userRole.setRoleDesc("Default Role for newly created");
		roleRepository.save(userRole);
		
		User  adminUser =new User();
		adminUser.setFirstName("admin1");
		adminUser.setLastName("admin");
		adminUser.setEmailId("admin@123");
		adminUser.setUserName("admin123");
	    adminUser.setUserPassword("Admin12345");
	
	    Set<Role> adminRoles=new HashSet<>();
		 adminRoles.add(adminRole);
		// adminUser.setRole(adminRoles);
     	 userRepository.save(adminUser);

			User user =new User();
			user.setFirstName("yuva");
			user.setLastName("yuva");
			user.setEmailId("yuva@123");
		    user.setUserName("yuva123");
	        user.setUserPassword("yuva@12345");
			
			Set<Role> userRoles=new HashSet<>();
			 userRoles.add(userRole);
			 //user.setRole(userRoles);
		
 			 userRepository.save(user);
	}


	@Override
	public List<User> findAll() {
		 List<User> user=userRepository.findAll();
	       return user;
	}


	  @Override
   	public User getUserById(Long userId) {
   		
   		Optional<User> optionalUser = userRepository.findById(userId);
   		if (optionalUser.isEmpty()) {
   			throw new UserNotFoundException("There is no User with Id:" + userId);
   		}
   		User user=optionalUser.get();
   		return user; 		
   	}


	@Override
	public String deleteUserById(Long userId) {
		
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			return "There is No User with Id:" + userId;
		}
		
		//delete user
		userRepository.deleteById(userId);
		return "User with Id: " + userId + " Delete Successfully";
	}
	


	@Override
	public User updateUser(User user) {
		//First find whether the user is existed to update if not throw exception
				Optional<User> user1 = userRepository.findById(user.getId());
				if (user1.isEmpty()) {
					throw new UserNotFoundException("There is no user existed with id: " + user.getId());
				}
				User user2 = new User();
				return userRepository.save(user2);
	}



}
