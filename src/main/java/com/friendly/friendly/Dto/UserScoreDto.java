package com.friendly.friendly.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Schema(name = "UserScoreDto", description = "User score data transfer object")
public class UserScoreDto {
    private Long userId;
    private String username;
    private Double averageScore;
}
