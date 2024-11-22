package com.friendly.friendly.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendly.friendly.View.UserCountPerParty;
import com.friendly.friendly.Repository.UserCountPerPartyRepository;
import com.friendly.friendly.Service.PartyService;

@RestController
@RequestMapping("/user-count-per-party")
public class UserCountPerPartyController {

    @Autowired
    private PartyService partyService;

    @Autowired
    private UserCountPerPartyRepository userCountPerPartyRepository;

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshMaterializedView() {
        partyService.refreshMaterializedView();
        return ResponseEntity.ok("Materialized view refreshed successfully.");
    }

    @GetMapping("/{partyId}")
    public ResponseEntity<UserCountPerParty> getUserCountByPartyId(@PathVariable Long partyId) {
        UserCountPerParty userCountPerParty = userCountPerPartyRepository.findById(partyId).orElse(null);

        if (userCountPerParty == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userCountPerParty);
    }

    @GetMapping
    public ResponseEntity<List<UserCountPerParty>> getAllUserCounts() {
        List<UserCountPerParty> userCounts = userCountPerPartyRepository.findAll();
        return ResponseEntity.ok(userCounts);
    }
}
