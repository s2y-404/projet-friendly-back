package com.friendly.friendly.View;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_count_per_party")
public class UserCountPerParty {
    @Id
    private Long partyId;
    private String partyName;
    private Long userCount;
}