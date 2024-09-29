package com.freelancer.platform.freelancer_matching_platform.Dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    private Long id; // Kullanıcı ID

    @NotNull(message = "User name cannot be null")
    @Size(min = 2, max = 50, message = "User name must be between 2 and 50 characters")
    private String name; // Kullanıcı adı

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email; // Kullanıcı e-postası

    // Şifre alanı genellikle DTO'da yer almaz, çünkü hassas bir bilgidir.
    // Eğer şifre güncelleniyorsa, bunu ayrı bir metotla yapabilirsiniz.

    private String userType; // Kullanıcının türü (Freelancer veya İşveren)
}
