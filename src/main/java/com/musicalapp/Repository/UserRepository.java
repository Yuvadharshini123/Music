package com.musicalapp.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.musicalapp.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findById(Long userId);
	//Optional<User> findByUserName(String userName);

	User findByEmailId(String emailId);
	
}
