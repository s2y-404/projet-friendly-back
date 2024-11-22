package com.friendly.friendly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.friendly.friendly.Model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
}
