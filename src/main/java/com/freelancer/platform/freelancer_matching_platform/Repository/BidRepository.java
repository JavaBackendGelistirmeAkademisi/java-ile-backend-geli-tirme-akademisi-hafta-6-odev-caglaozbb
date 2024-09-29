package com.freelancer.platform.freelancer_matching_platform.Repository;

import com.freelancer.platform.freelancer_matching_platform.Entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findByFreelancerId(Long freelancerId); // Freelancer'ın teklifleri
    List<Bid> findByProjectId(Long projectId); // Belirli bir proje için verilen teklifler
}