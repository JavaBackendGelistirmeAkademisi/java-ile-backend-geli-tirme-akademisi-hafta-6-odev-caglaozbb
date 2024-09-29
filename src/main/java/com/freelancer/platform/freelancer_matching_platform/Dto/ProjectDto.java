package com.freelancer.platform.freelancer_matching_platform.Dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProjectDto {
    private Long id; // Proje ID

    @NotNull(message = "Project title cannot be null")
    @Size(min = 2, max = 100, message = "Project title must be between 2 and 100 characters")
    private String title; // Proje başlığı

    @NotNull(message = "Description cannot be null")
    private String description; // Proje açıklaması

    @NotNull(message = "Budget cannot be null")
    private Double budget; // Proje bütçesi

    private Long employerId; // İşveren ID'si
}
