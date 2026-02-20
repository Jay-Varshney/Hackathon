package com.hackathon.hackathon.Repositories;


import com.hackathon.hackathon.entities.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRoleRepository extends JpaRepository<ProjectRole, Long> {

    List<ProjectRole> findByProjectId(Long projectId);

    List<ProjectRole> findByRoleName(String roleName);
}