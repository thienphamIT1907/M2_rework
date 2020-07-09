package com.services;

import com.models.Employee;
public interface EmployeeService {

    Iterable<Employee> findAll();

    void save(Employee e);

    Employee findById(Long id);

    void deleteById(Long id);

    Iterable<Employee> findAllByBirthdayContainingOrCmndContaining (
            String birthday,
            String cmnd
    );
}
