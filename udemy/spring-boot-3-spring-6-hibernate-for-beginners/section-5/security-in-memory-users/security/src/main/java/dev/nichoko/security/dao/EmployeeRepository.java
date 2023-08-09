package dev.nichoko.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.nichoko.security.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
