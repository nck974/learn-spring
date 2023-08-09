package dev.nichoko.rest.dao.service;

import java.util.List;

import dev.nichoko.rest.dao.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void deleteById(int id);
    Employee save(Employee employee);
}
