package com.friendly.friendly.Dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Schema(name = "PartyDto", description = "Party Data Transfer Object")
public class PartyDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime date;
    private Integer nbPlace;
    private Boolean isPaying;
    private Double price;
    private TypeDto type;
    private Long localisationId;
}
