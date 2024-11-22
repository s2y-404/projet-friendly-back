package com.friendly.friendly.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "user_party")
public class UserParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    private Party party;

    @Column(name = "is_organize", nullable = false)
    private Boolean isOrganize;

    @Column(name = "is_pay", nullable = false)
    private Boolean isPay;
}