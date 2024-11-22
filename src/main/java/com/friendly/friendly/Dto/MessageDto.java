package com.friendly.friendly.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Schema(name = "MessageDto", description = "Message Data Transfer Object")
public class MessageDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String content;
    private Long senderId; 
    private Long receiverId;    
}
