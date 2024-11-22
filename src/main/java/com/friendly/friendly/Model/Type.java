package com.friendly.friendly.Model;

import jakarta.persistence.*;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String label;

    private String description;

    @OneToMany(mappedBy = "type")
    private Set<Party> parties;
}
