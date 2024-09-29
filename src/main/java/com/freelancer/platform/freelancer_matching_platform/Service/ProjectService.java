package com.freelancer.platform.freelancer_matching_platform.Service;

import com.freelancer.platform.freelancer_matching_platform.Entity.Project;
import com.freelancer.platform.freelancer_matching_platform.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Yeni proje ekleme
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    // Tüm projeleri listeleme
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // ID ile proje bulma
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Proje bulunamadı"));
    }

    // Proje güncelleme
    public Project updateProject(Long id, Project updatedProject) {
        Project existingProject = getProjectById(id);
        existingProject.setTitle(updatedProject.getTitle());
        existingProject.setDescription(updatedProject.getDescription());
        // Diğer alanları güncelle...
        return projectRepository.save(existingProject);
    }

    // Proje silme
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}