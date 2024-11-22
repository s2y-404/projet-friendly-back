package com.friendly.friendly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.friendly.friendly.Model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
    
}
