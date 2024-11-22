package com.friendly.friendly.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "localisation_id")
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;
}
