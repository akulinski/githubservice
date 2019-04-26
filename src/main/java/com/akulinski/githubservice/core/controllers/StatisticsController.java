package com.akulinski.githubservice.core.controllers;

import com.akulinski.githubservice.core.domain.ProfileStatistics;
import com.akulinski.githubservice.core.services.UserStatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StatisticsController {

    private final UserStatisticsService userStatisticsService;

    public StatisticsController(UserStatisticsService userStatisticsService) {
        this.userStatisticsService = userStatisticsService;
    }

    @GetMapping("/statistics/{username}")
    public ResponseEntity getStatisticsForUser(@PathVariable String username) {
        ProfileStatistics profileStatistics = new ProfileStatistics();
        profileStatistics.setRepositoriesCount(userStatisticsService.getRepositoryCount(username));
        return ResponseEntity.ok(profileStatistics);
    }
}
