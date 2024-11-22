package com.friendly.friendly.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.friendly.friendly.Dto.TypeDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Mapper.TypeMapper;
import com.friendly.friendly.Model.Type;
import com.friendly.friendly.Repository.TypeRepository;

@Service
public class TypeService {
    
    @Autowired
    private TypeRepository typeRepository;
    
    @Autowired
    private TypeMapper typeMapper;

    public Page<TypeDto> findAll(int page, int size) {
        return typeRepository
                .findAll(PageRequest.of(page, size))
                .map(typeMapper::toDto);
    }

    public TypeDto findById(long id) throws ResourceNotFoundException {
        Type type = typeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Type not found"));
        return typeMapper.toDto(type);
    }

    public TypeDto save(TypeDto typeDto) {
        Type type = typeMapper.toEntity(typeDto);
        return typeMapper.toDto(typeRepository.save(type));
    }

    public TypeDto update(TypeDto typeDto) throws ResourceNotFoundException {
        typeRepository.findById(typeDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Type not found"));

        Type updatedType = typeMapper.toEntity(typeDto);
        return typeMapper.toDto(typeRepository.save(updatedType));
    }

    public void delete(Long id) {
        if (!typeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Type with ID " + id + " does not exist.");
        }
        typeRepository.deleteById(id);
    }
}
