package com.akulinski.githubservice.core.services;

import com.akulinski.githubservice.core.feign.RepositoryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserStatisticsService {

    private final RepositoryClient repositoryClient;

    public UserStatisticsService(RepositoryClient repositoryClient) {
        this.repositoryClient = repositoryClient;
    }


    public Integer getRepositoryCount(String username) {
        return repositoryClient.getAllRepos(username).size();
    }
}
