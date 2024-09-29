package com.freelancer.platform.freelancer_matching_platform.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Payment amount cannot be null")
    private Double amount; // Ödeme tutarı

    @ManyToOne
    @JoinColumn(name = "bid_id", nullable = false)
    private Bid bid; // İlgili teklif

    @Column(name = "status")
    private String status; // Ödeme durumu (Başarılı, Başarısız vb.)

    // Proje ile ilişkiyi Bid üzerinden al
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project; // İlgili proje

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Ödeme sahibi

}
