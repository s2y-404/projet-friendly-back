package com.friendly.friendly.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.friendly.friendly.Dto.LocalisationDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Mapper.LocalisationMapper;
import com.friendly.friendly.Model.Localisation;
import com.friendly.friendly.Repository.LocalisationRepository;

@Service
public class LocalisationService {
    
    @Autowired
    private LocalisationRepository localisationRepository;
    
    @Autowired
    private LocalisationMapper localisationMapper;

    public Page<LocalisationDto> findAll(int page, int size) {
        return localisationRepository
                .findAll(PageRequest.of(page, size))
                .map(localisationMapper::toDto);
    }

    public LocalisationDto findById(long id) throws ResourceNotFoundException {
        Localisation localisation = localisationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Localisation not found"));
        return localisationMapper.toDto(localisation);
    }

    public LocalisationDto save(LocalisationDto localisationDto) {
        Localisation localisation = localisationMapper.toEntity(localisationDto);
        return localisationMapper.toDto(localisationRepository.save(localisation));
    }

    public LocalisationDto update(LocalisationDto localisationDto) throws ResourceNotFoundException {
        localisationRepository.findById(localisationDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Message not found"));

        Localisation updatedLocalisation = localisationMapper.toEntity(localisationDto);
        return localisationMapper.toDto(localisationRepository.save(updatedLocalisation));
    }

    public void delete(Long id) {
        if (!localisationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Localisation with ID " + id + " does not exist.");
        }
        localisationRepository.deleteById(id);
    }
}
