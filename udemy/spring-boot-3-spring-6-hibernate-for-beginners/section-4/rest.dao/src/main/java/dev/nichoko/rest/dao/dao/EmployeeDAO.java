package dev.nichoko.rest.dao.dao;

import java.util.List;

import dev.nichoko.rest.dao.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    void deleteById(int id);
    Employee save(Employee employee);
}
