package com.friendly.friendly.Repository;

import com.friendly.friendly.View.UserCountPerParty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCountPerPartyRepository extends JpaRepository<UserCountPerParty, Long> {
    
}
