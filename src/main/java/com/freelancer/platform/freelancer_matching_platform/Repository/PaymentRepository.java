package com.freelancer.platform.freelancer_matching_platform.Repository;

import com.freelancer.platform.freelancer_matching_platform.Entity.Payment;
import com.freelancer.platform.freelancer_matching_platform.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
//    List<Payment> findByUserId(Long userId); // Kullanıcıya ait ödemeler
    List<Payment> findByProjectId(Long projectId); // Belirli bir proje için ödemeler
    List<Payment> findByUser(User user); // Kullanıcıya ait ödemeler

}