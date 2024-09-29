package com.freelancer.platform.freelancer_matching_platform.Repository;
import com.freelancer.platform.freelancer_matching_platform.Entity.User;
import com.freelancer.platform.freelancer_matching_platform.Entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // E-posta ile kullanıcıyı bul
    List<User> findByUserType(UserType userType); // Kullanıcı tipine göre kullanıcıları bul
}