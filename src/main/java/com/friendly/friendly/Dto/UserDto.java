package com.friendly.friendly.Dto;

import java.sql.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Schema(name = "UserDto", description = "User Data Transfer Object")
public class UserDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String username;
    private String password;
    private Date birthdate;
    private List<HobbyDto> hobbies;
}
