package com.hackathon.hackathon.Repositories;


import com.hackathon.hackathon.entities.ProjectAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectAssignmentRepository extends JpaRepository<ProjectAssignment, Long> {

    List<ProjectAssignment> findByProjectId(Long projectId);

    List<ProjectAssignment> findByEmployeeId(Long employeeId);

    Optional<ProjectAssignment> findByProjectIdAndEmployeeId(Long projectId, Long employeeId);
}