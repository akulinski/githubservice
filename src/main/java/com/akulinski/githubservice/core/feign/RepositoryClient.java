package com.akulinski.githubservice.core.feign;

import com.akulinski.githubservice.core.domain.RepositoryDTO;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface RepositoryClient {

    @RequestLine("GET /{user}/repos")
    List<RepositoryDTO> getAllRepos(@Param("user") String user);
}
