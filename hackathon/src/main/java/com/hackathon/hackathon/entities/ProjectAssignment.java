package com.hackathon.hackathon.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "project_assignments",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"project_id", "employee_id"})
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProjectAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many assignments can belong to one project
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    // Many assignments can belong to one employee
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "assigned_role", nullable = false, length = 100)
    private String assignedRole;

    @Column(name = "compatibility_score", nullable = false)
    private Double compatibilityScore;
}