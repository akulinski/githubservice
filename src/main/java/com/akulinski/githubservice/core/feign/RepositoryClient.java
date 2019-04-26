package com.akulinski.githubservice.core.feign;

import com.akulinski.githubservice.core.domain.RepositoryDTO;
import feign.Param;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

public interface RepositoryClient {

    @RequestLine("GET /users/{user}/repos")
    List<RepositoryDTO> getAllRepos(@Param("user") String user);

    @RequestLine("GET /repos/{user}/{repo}/languages")
    Map<String,String> getLanguageBytesForRepo(@Param("user") String user, @Param("repo") String repo);
}
