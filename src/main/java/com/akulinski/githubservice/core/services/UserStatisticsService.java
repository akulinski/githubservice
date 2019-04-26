package com.akulinski.githubservice.core.services;

import com.akulinski.githubservice.core.domain.ProfileStatistics;
import com.akulinski.githubservice.core.domain.RepositoryDTO;
import com.akulinski.githubservice.core.feign.RepositoryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserStatisticsService {

    private final RepositoryClient repositoryClient;

    public UserStatisticsService(RepositoryClient repositoryClient) {
        this.repositoryClient = repositoryClient;
    }

    public ProfileStatistics getProfileStatistics(String username) {

        log.debug(String.format("getProfileStatistics|username: %s", username));

        ProfileStatistics profileStatistics = new ProfileStatistics();

        final List<RepositoryDTO> allRepos = repositoryClient.getAllRepos(username);

        HashMap<String, Long> languageBytesStatsSum = new HashMap<>();

        allRepos.forEach(repositoryDTO -> {

            log.debug(String.format("parsing repository: %s", repositoryDTO.getName()));

            addBytesInRepoToSum(username, languageBytesStatsSum, repositoryDTO);
        });

        profileStatistics.setRepositoriesCount(allRepos.size());
        profileStatistics.setLanguages(languageBytesStatsSum);

        return profileStatistics;
    }

    private void addBytesInRepoToSum(String username, HashMap<String, Long> languageBytesStatsSum, RepositoryDTO repositoryDTO) {
        final Map<String, String> languageBytesForRepo = repositoryClient.getLanguageBytesForRepo(username, repositoryDTO.getName());

        languageBytesForRepo.forEach((s, s2) -> {

            if (languageBytesStatsSum.containsKey(s)) {
                languageBytesStatsSum.put(s, Long.parseLong(s2) + languageBytesStatsSum.get(s));
            } else {
                languageBytesStatsSum.put(s, Long.parseLong(s2));
            }
        });
    }

}
