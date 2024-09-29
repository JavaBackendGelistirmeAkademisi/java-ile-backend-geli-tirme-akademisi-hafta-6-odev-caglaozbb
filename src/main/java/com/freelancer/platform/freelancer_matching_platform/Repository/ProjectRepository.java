package com.freelancer.platform.freelancer_matching_platform.Repository;

import com.freelancer.platform.freelancer_matching_platform.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByEmployerId(Long employerId); // İşverenin tüm projeleri
}