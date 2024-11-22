package com.friendly.friendly.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.friendly.friendly.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByUsername(String username);
    User findByUsername(String username);
    boolean existsByUsername(String username);
    
}
