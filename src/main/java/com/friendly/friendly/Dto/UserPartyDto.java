package com.friendly.friendly.Dto;

import com.friendly.friendly.Model.Party;

import com.friendly.friendly.Model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserPartyDto {
    private Long id;
    private User user;
    private Party party;
    private Boolean isOrganize;
    private Boolean isPay;
}
