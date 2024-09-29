package com.freelancer.platform.freelancer_matching_platform.Dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BidDto {
    private Long id; // Teklif ID

    @NotNull(message = "Bid amount cannot be null")
    private Double amount; // Teklif tutarı

    private Long freelancerId; // Freelancer ID'si

    private Long projectId; // Proje ID'si

    private String status; // Teklif durumu (Beklemede, Kabul edildi, Reddedildi)
}
