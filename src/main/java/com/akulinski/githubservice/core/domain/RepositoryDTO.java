package com.akulinski.githubservice.core.domain;

import lombok.Data;

@Data
public class RepositoryDTO {
    private Long id;
    private String note;
    private String description;
    private String name;
}
