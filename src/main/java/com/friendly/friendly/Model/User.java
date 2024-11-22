package com.friendly.friendly.Model;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 25)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "birth_date", columnDefinition = "DATE", nullable = false)
    private Date birthdate;

    @ManyToMany
    @JoinTable(
        name = "user_hobby",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "hobby_id")
    )
    private Set<Hobby> hobbies;

    @ManyToOne
    @JoinColumn(name = "localisation_id")
    private Localisation localisation;

    @OneToMany(mappedBy = "user")
    private Set<UserParty> userParties;
}
