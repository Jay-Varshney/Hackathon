package com.hackathon.hackathon.Services;


import com.hackathon.hackathon.entities.Skill;
import com.hackathon.hackathon.Repositories.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> getSkillsByEmployee(Long employeeId) {
        return skillRepository.findByEmployeeId(employeeId);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}