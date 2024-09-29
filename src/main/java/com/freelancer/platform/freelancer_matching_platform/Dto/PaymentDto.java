package com.freelancer.platform.freelancer_matching_platform.Dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PaymentDto {
    private Long id; // Ödeme ID

    @NotNull(message = "Payment amount cannot be null")
    private Double amount; // Ödeme tutarı

    private Long bidId; // Teklif ID'si

    private String paymentDate; // Ödeme tarihi
}
