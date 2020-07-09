package com.repositories;

import com.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Iterable<Employee> findAllByBirthdayContainingOrCmndContaining (
            String birthday,
            String cmnd
    );
}
