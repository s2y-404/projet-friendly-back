package com.friendly.friendly.View;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "user_score_avg")
public class UserScoreView {
    @Id
    private Long userId;
    private String username;
    private Double averageScore;
}
