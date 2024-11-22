package com.friendly.friendly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.friendly.friendly.Model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    
}
