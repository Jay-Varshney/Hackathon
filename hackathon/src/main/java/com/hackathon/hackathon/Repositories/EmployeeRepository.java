package com.hackathon.hackathon.Repositories;


import com.hackathon.hackathon.entities.Employee;
import com.hackathon.hackathon.entities.AvailabilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    List<Employee> findByDepartment(String department);

    List<Employee> findByAvailabilityStatus(AvailabilityStatus status);

    List<Employee> findByExperienceYearsGreaterThanEqual(Integer years);
}