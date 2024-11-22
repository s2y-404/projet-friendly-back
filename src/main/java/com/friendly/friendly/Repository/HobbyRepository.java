package com.friendly.friendly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.friendly.friendly.Model.Hobby;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
    
}

