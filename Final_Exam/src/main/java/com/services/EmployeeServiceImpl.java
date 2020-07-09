package com.services;

import com.models.Employee;
import com.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee e) {
        employeeRepository.save(e);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Iterable<Employee> findAllByBirthdayContainingOrCmndContaining(String birthday, String cmnd) {
        return employeeRepository.findAllByBirthdayContainingOrCmndContaining(birthday, cmnd);
    }
}
