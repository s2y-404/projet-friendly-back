package com.friendly.friendly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendly.friendly.Dto.UserScoreDto;
import com.friendly.friendly.Repository.UserScoreRepository;
import com.friendly.friendly.Service.ScoreService;
import com.friendly.friendly.View.UserScoreView;

@RestController
@RequestMapping("/users-scores")
public class UserScoreController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private UserScoreRepository userScoreRepository;

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshMaterializedView() {
        scoreService.refreshMaterializedView();
        return ResponseEntity.ok("Materialized view refreshed successfully.");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserScoreDto> getAverageScoreByUserId(@PathVariable Long userId) {
        UserScoreView userScore = userScoreRepository.findByUserId(userId);

        if (userScore == null) {
            return ResponseEntity.notFound().build();
        }

        UserScoreDto response = new UserScoreDto();
        response.setUserId(userScore.getUserId());
        response.setUsername(userScore.getUsername());
        response.setAverageScore(userScore.getAverageScore());

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserScoreView>> getTotalAverageScore() {
        List<UserScoreView> totalAverage = userScoreRepository.findAll();
        return ResponseEntity.ok(totalAverage);
    }
}

