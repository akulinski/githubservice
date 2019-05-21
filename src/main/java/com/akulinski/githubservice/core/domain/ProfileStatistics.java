package com.akulinski.githubservice.core.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ProfileStatistics {

    private String userName;
    private Integer repositoriesCount = 0;
    private Map<String, Long> languages;
    private String avatarLink;

    public ProfileStatistics() {
        this.languages = new HashMap<>();
    }
}
