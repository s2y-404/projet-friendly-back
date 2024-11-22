package com.friendly.friendly.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.friendly.friendly.Model.Party;

public interface PartyRepository extends JpaRepository<Party, Long> {
    
    @Query(value = "SELECT * FROM party_2023", nativeQuery = true)
    Page<Party> findAllFromParty2023(Pageable pageable);

    @Query(value = "SELECT * FROM party_2024", nativeQuery = true)
    Page<Party> findAllFromParty2024(Pageable pageable);

    @Query(value = "SELECT * FROM party_2025", nativeQuery = true)
    Page<Party> findAllFromParty2025(Pageable pageable);

}
