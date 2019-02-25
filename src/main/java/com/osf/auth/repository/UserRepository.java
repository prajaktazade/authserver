package com.osf.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osf.auth.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

    //Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
    
    //User findByUsername(String username);


}
