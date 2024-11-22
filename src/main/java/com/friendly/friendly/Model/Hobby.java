package com.friendly.friendly.Model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id")
    private Long id;

    @Column(name = "label", nullable = false, length = 50)
    private String label;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "hobbies")
    private Set<User> users;
}
