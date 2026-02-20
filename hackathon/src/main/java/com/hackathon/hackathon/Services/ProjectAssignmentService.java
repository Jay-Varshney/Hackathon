package com.hackathon.hackathon.Services;


import com.hackathon.hackathon.entities.*;
import com.hackathon.hackathon.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectAssignmentService {

    private final ProjectAssignmentRepository assignmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public ProjectAssignment assignEmployee(
            Long projectId,
            Long employeeId,
            String role,
            Double compatibilityScore
    ) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (employee.getAvailabilityStatus() == AvailabilityStatus.ASSIGNED) {
            throw new RuntimeException("Employee already assigned");
        }

        ProjectAssignment assignment = ProjectAssignment.builder()
                .project(project)
                .employee(employee)
                .assignedRole(role)
                .compatibilityScore(compatibilityScore)
                .build();

        employee.setAvailabilityStatus(AvailabilityStatus.ASSIGNED);
        employeeRepository.save(employee);

        return assignmentRepository.save(assignment);
    }

    public List<ProjectAssignment> getAssignmentsByProject(Long projectId) {
        return assignmentRepository.findByProjectId(projectId);
    }

    public void removeAssignment(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }
}