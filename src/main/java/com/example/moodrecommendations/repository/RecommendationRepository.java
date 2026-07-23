package com.example.moodrecommendations.repository;

import com.example.moodrecommendations.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository
        extends JpaRepository<Recommendation, Long> {

    List<Recommendation> findByMoodAndType(
            String mood,
            String type
    );

    List<Recommendation> findByMood(
            String mood
    );
}