package com.freelancer.platform.freelancer_matching_platform.Entity;
import com.freelancer.platform.freelancer_matching_platform.Entity.UserType;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Otomatik artan ID

    @NotNull(message = "User name cannot be null")
    @Size(min = 2, max = 50, message = "User name must be between 2 and 50 characters")
    private String name; // Kullanıcı adı

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email; // Kullanıcı e-postası

    @NotNull(message = "Password  cannot be null")
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    private String password; // Kullanıcı şifresi

    @Enumerated(EnumType.STRING)
    private UserType userType; // Freelancer veya İşveren

    @OneToMany(mappedBy = "employer")
    private List<Project> projects; // İşverenin projeleri

    @OneToMany(mappedBy = "freelancer")
    private List<Bid> bids; // Freelancer'ın teklifleri

    @OneToMany(mappedBy = "user")
    private List<Payment> payments; // Kullanıcının ödemeleri
    public User() {
    }
}
