package com.hackathon.hackathon.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skills",
       uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id", "skill_name"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skill_name", nullable = false, length = 100)
    private String skillName;

    @Column(name = "skill_level", nullable = false)
    private Integer skillLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @PrePersist
    @PreUpdate
    private void normalizeSkillName() {
        if (this.skillName != null) {
            this.skillName = this.skillName.trim().toLowerCase();
        }
    }
}