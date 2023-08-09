package dev.nichoko.data.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.nichoko.data.jpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
