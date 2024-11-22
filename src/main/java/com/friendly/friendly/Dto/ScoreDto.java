package com.friendly.friendly.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Schema(name = "ScoreDto", description = "Score Data Transfer Object")
public class ScoreDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private Integer nbStar;
    private String remark;
    private Long partyId;
    private Long userId;
}
