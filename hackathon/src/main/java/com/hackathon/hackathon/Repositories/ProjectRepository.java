package com.hackathon.hackathon.Repositories;


import com.hackathon.hackathon.entities.Project;
import com.hackathon.hackathon.entities.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByPriority(Priority priority);

    List<Project> findByCreatedBy(String createdBy);
}