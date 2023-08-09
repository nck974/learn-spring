package dev.nichoko.security.service;

import java.util.List;

import dev.nichoko.security.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void deleteById(int id);
    Employee save(Employee employee);
}
