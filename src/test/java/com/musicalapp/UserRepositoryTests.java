package com.musicalapp;










import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.musicalapp.Entity.User;
import com.musicalapp.Repository.UserRepository;



@DataJpaTest
@AutoConfigureTestDatabase//(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
     @Autowired
	    private TestEntityManager entityManager;
	     
	    @Autowired
	    private UserRepository userRepository;
	    
	    
	    @Test
    public void testCreateUser() {
	        User user = new User();
	        user.setEmailId("ravikumar@gmail.com");
	        user.setUserPassword("ravi2020");
	        user.setFirstName("Ravi");
	        user.setLastName("Kumar");
	         
        User savedUser = userRepository.save(user);
         
	        User existUser = entityManager.find(User.class, savedUser.getId());
	         
	  //      assertThat(user.getEmailId()).isEqualTo(existUser.getEmailId());	         
	    }
}
