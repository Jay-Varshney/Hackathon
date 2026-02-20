package com.hackathon.hackathon.Services;


import com.hackathon.hackathon.entities.ProjectRole;
import com.hackathon.hackathon.Repositories.ProjectRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectRoleService {

    private final ProjectRoleRepository projectRoleRepository;

    public ProjectRole createRole(ProjectRole role) {
        return projectRoleRepository.save(role);
    }

    public List<ProjectRole> getRolesByProject(Long projectId) {
        return projectRoleRepository.findByProjectId(projectId);
    }

    public void deleteRole(Long id) {
        projectRoleRepository.deleteById(id);
    }
}