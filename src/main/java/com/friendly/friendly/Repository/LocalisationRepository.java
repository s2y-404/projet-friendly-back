package com.friendly.friendly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.friendly.friendly.Model.Localisation;

public interface LocalisationRepository extends JpaRepository<Localisation, Long> {
    
}
