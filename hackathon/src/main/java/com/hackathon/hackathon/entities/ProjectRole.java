package com.hackathon.hackathon.entities;


import jakarta.persistence.*;
import lombok.*;

// import java.util.List;

@Entity
@Table(name = "project_roles",
       uniqueConstraints = @UniqueConstraint(columnNames = {"project_id", "role_name"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "project")
public class ProjectRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many roles belong to one project
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "role_name", nullable = false, length = 100)
    private String roleName;

    // JSON column
    @Column(name = "required_skills", columnDefinition = "JSON", nullable = false)
    private String requiredSkills;

    @Column(name = "min_experience", nullable = false)
    private Integer minExperience;

    @Column(name = "priority_level", nullable = false)
    private Integer priorityLevel;

    @PrePersist
    @PreUpdate
    private void normalizeRoleName() {
        if (this.roleName != null) {
            this.roleName = this.roleName.trim();
        }
    }
}