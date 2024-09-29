package com.freelancer.platform.freelancer_matching_platform.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Otomatik artan ID

    @NotNull(message = "Title cannot be null")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title; // Proje başlığı

    @NotNull(message = "Description cannot be null")
    @Size(min = 2, max = 200, message = "Description must be between 2 and 200 characters")
    private String description; // Proje açıklaması

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false) // İşveren ile ilişkilendirir
    private User employer; // İşveren

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL) // Projeye ait teklifler
    private List<Bid> bids; // Teklifler

    @Column(name = "is_payment_done")
    private Boolean isPaymentDone; // Ödeme durumu (yapıldı/yapılmadı)

}
