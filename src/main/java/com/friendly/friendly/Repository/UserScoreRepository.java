package com.friendly.friendly.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.friendly.friendly.View.UserScoreView;

@Repository
public interface UserScoreRepository extends JpaRepository<UserScoreView, Long> {

    @Query(value = "SELECT * FROM user_score_avg WHERE user_id = :userId", nativeQuery = true)
    UserScoreView findByUserId(@Param("userId") Long userId);

    List<UserScoreView> findAll();
}

