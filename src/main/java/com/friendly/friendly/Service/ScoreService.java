package com.friendly.friendly.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.friendly.friendly.Dto.ScoreDto;
import com.friendly.friendly.Exception.ResourceNotFoundException;
import com.friendly.friendly.Mapper.ScoreMapper;
import com.friendly.friendly.Model.Score;
import com.friendly.friendly.Repository.ScoreRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    @Autowired
    private ScoreMapper scoreMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public Page<ScoreDto> findAll(int page, int size) {
        return scoreRepository
                .findAll(PageRequest.of(page, size))
                .map(scoreMapper::toDto);
    }

    public ScoreDto findById(long id) throws ResourceNotFoundException {
        Score score = scoreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Score not found"));
        return scoreMapper.toDto(score);
    }

    public ScoreDto save(ScoreDto scoreDto) {
        Score score = scoreMapper.toEntity(scoreDto);
        return scoreMapper.toDto(scoreRepository.save(score));
    }

    public ScoreDto update(ScoreDto scoreDto) throws ResourceNotFoundException {
        scoreRepository.findById(scoreDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Score not found"));

        Score updatedScore = scoreMapper.toEntity(scoreDto);
        return scoreMapper.toDto(scoreRepository.save(updatedScore));
    }

    public void delete(Long id) {
        if (!scoreRepository.existsById(id)) {
            throw new ResourceNotFoundException("Score with ID " + id + " does not exist.");
        }
        scoreRepository.deleteById(id);
    }
    
    public void refreshMaterializedView() {
        entityManager.createNativeQuery("REFRESH MATERIALIZED VIEW user_score_avg").executeUpdate();
    }
}
