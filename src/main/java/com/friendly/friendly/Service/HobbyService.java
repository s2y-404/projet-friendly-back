package com.friendly.friendly.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.friendly.friendly.Dto.HobbyDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Mapper.HobbyMapper;
import com.friendly.friendly.Model.Hobby;
import com.friendly.friendly.Repository.HobbyRepository;

@Service
public class HobbyService {
    
    @Autowired
    private HobbyRepository hobbyRepository;
    
    @Autowired
    private HobbyMapper hobbyMapper;

    public Page<HobbyDto> findAll(int page, int size) {
        return hobbyRepository
                .findAll(PageRequest.of(page, size))
                .map(hobbyMapper::toDto);
    }

    public HobbyDto findById(long id) throws ResourceNotFoundException {
        Hobby hobby = hobbyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hobby not found"));
        return hobbyMapper.toDto(hobby);
    }

    public HobbyDto save(HobbyDto hobbyDto) {
        Hobby hobby = hobbyMapper.toEntity(hobbyDto);
        return hobbyMapper.toDto(hobbyRepository.save(hobby));
    }

    public HobbyDto update(HobbyDto hobbyDto) throws ResourceNotFoundException {
        hobbyRepository.findById(hobbyDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Hobby not found"));

        Hobby updatedHobby = hobbyMapper.toEntity(hobbyDto);
        return hobbyMapper.toDto(hobbyRepository.save(updatedHobby));
    }

    public void delete(Long id) {
        if (!hobbyRepository.existsById(id)) {
            throw new ResourceNotFoundException("Hobby with ID " + id + " does not exist.");
        }
        hobbyRepository.deleteById(id);
    }
}
