package com.freelancer.platform.freelancer_matching_platform.Entity;
import com.freelancer.platform.freelancer_matching_platform.Entity.BidStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bids")
@Getter
@Setter
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Otomatik artan ID

    @NotNull(message = "Bid amount cannot be null")
    private Double amount; // Teklif tutarı

    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = false)
    private User freelancer; // Teklifi veren freelancer

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project; // İlgili proje

    @Enumerated(EnumType.STRING)
    private BidStatus status; // Teklif durumu (Beklemede, Kabul edildi, Reddedildi)

    @Column(name = "payment_status")
    private Boolean paymentStatus; // Ödeme durumu (yapıldı/yapılmadı)

}

