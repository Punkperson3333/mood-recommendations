package com.example.moodrecommendations.controller;

import com.example.moodrecommendations.Recommendation;
import com.example.moodrecommendations.repository.RecommendationRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@CrossOrigin
public class RecommendationController {

    private final RecommendationRepository repository;

    public RecommendationController(RecommendationRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Recommendation> getRecommendations(
            @RequestParam String mood,
            @RequestParam String type
    ) {

        if (type.equals("Both")) {
            return repository.findByMood(mood);
        }

        return repository.findByMoodAndType(mood, type);
    }
    @GetMapping("/")
    public String home() {
        return "Mood Recommendations Backend is running!";
    }
}