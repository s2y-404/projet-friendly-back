package com.friendly.friendly.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.friendly.friendly.Dto.PartyDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Mapper.PartyMapper;
import com.friendly.friendly.Model.Party;
import com.friendly.friendly.Repository.PartyRepository;

import jakarta.transaction.Transactional;

@Service
public class PartyService {
    
    @Autowired
    private PartyRepository partyRepository;
    
    @Autowired
    private PartyMapper partyMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Page<PartyDto> findAll(int page, int size) {
        Page<Party> partys = partyRepository.findAll(PageRequest.of(page, size));
        return partys.map(partyMapper::toDto);
    }

    public Page<PartyDto> findAllByYear(int year, int page, int size) {       
        switch (year) {
            case 2023:
                return partyRepository.findAllFromParty2023(PageRequest.of(page, size)).map(partyMapper::toDto);
            case 2024:
                return partyRepository.findAllFromParty2024(PageRequest.of(page, size)).map(partyMapper::toDto);
            case 2025:
                return partyRepository.findAllFromParty2025(PageRequest.of(page, size)).map(partyMapper::toDto);
            default:
                throw new IllegalArgumentException("Year not supported");
        }
    }

    public PartyDto findById(long id) throws ResourceNotFoundException {
        Party party = partyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Party not found"));
        return partyMapper.toDto(party);
    }

    public PartyDto save(PartyDto partyDto) {
        Party party = partyMapper.toEntity(partyDto);
        return partyMapper.toDto(partyRepository.save(party));
    }

    public PartyDto update(PartyDto partyDto) throws ResourceNotFoundException {
        Party existingParty = partyRepository.findById(partyDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Party not found"));
        partyDto.setId(existingParty.getId());

        Party partyUpdated = partyMapper.toEntity(partyDto);
        return partyMapper.toDto(partyRepository.save(partyUpdated));
    }

    public void delete(Long id) {
        if (!partyRepository.existsById(id)) {
            throw new ResourceNotFoundException("Party with ID " + id + " does not exist.");
        }
        partyRepository.deleteById(id);
    }
    
    @Transactional
    public void refreshMaterializedView() {
        jdbcTemplate.execute("REFRESH MATERIALIZED VIEW user_count_per_party");
    }
}
