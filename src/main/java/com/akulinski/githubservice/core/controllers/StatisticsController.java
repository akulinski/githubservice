package com.akulinski.githubservice.core.controllers;

import com.akulinski.githubservice.core.services.UserStatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StatisticsController {

    private final UserStatisticsService userStatisticsService;

    public StatisticsController(UserStatisticsService userStatisticsService) {
        this.userStatisticsService = userStatisticsService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/statistics/{username}")
    public ResponseEntity getStatisticsForUser(@PathVariable String username) {
        log.debug(String.format("getStatisticsForUser|%s", username));
        return ResponseEntity.ok(userStatisticsService.getProfileStatistics(username));
    }
}
