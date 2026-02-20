package com.hackathon.hackathon.Repositories;


import com.hackathon.hackathon.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findByEmployeeId(Long employeeId);

    Optional<Skill> findByEmployeeIdAndSkillName(Long employeeId, String skillName);
}