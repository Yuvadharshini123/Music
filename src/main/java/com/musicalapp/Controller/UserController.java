package com.musicalapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musicalapp.Dto.UserDto;
import com.musicalapp.Entity.User;
import com.musicalapp.Service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")

public class UserController {
	
     
	
	
	@Autowired
	private UserService userService;
	


	 @GetMapping("/registration")
	    public String registrationForm(Model model) {
	        model.addAttribute("user", new User());
	        return "registration";
	    }
	 @GetMapping("/register")
	 public String showRegistrationForm(Model model) {
	     model.addAttribute("user", new User());
	      
	     return "signup_form";
	 }
	
	@GetMapping({"/forAdmin"})
    public String forAdmin()	{
			return "This Url is Accessible for Admin Only";
		}
	
	@GetMapping({"/forUser"})
    public String forUser()	{
			return "This Url is Accessible for Admin Only";
		}
    
	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUser();
	}
	@PostMapping("/addNewUser")
	public User registerNewUser(@RequestBody User user) {
	
		return userService.addUsers(user);
	}
	
    @GetMapping("/loggin")
    public String login() {
        return "login"; // Return the login page (create a login.html or login.jsp)
    }

	@GetMapping("/login/{emailIdd}/{password}")
	public ResponseEntity<String> doLogin(@PathVariable("emailIdd") String emailIdd, @PathVariable("password") String password) {
		String user = userService.userLogin(emailIdd, password);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		return responseEntity;
	}
	
	
	
	
	//GetAllUsers
	@GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
    	List<User> user=userService.findAll();
    	return user;
	}
  //GetUserById
	@GetMapping("getUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
		User response = userService.getUserById(userId);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		return responseEntity;

	}
	
	@PutMapping("UpdateUserDetails")
	public ResponseEntity<User> modifyUser(@RequestBody User user) {
		User user1 = userService.updateUser(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<>(user1, HttpStatus.OK);
		return responseEntity;
	}

	
	//Delete User 
 	@DeleteMapping("DeleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
		String response = userService.deleteUserById(userId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		return responseEntity;

	}
	
}
