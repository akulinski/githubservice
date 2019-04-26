package com.akulinski.githubservice.core.controllers;

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
        return ResponseEntity.ok(userStatisticsService.getProfileStatistics(username));
    }
}
