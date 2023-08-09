package dev.nichoko.data.jpa.service;

import java.util.List;

import dev.nichoko.data.jpa.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void deleteById(int id);
    Employee save(Employee employee);
}
