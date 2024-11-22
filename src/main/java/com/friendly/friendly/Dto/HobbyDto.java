package com.friendly.friendly.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Schema(name = "HobbyDto", description = "Hobby Data Transfer Object")
public class HobbyDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String label;
    private String description;
}
