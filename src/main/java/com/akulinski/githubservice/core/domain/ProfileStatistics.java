package com.akulinski.githubservice.core.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ProfileStatistics {
    private Integer repositoriesCount;
    Map<String, Long> languageBytesMap;

    public ProfileStatistics() {
        this.languageBytesMap = new HashMap<>();
    }
}
