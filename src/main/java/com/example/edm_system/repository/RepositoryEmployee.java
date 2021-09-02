package com.example.edm_system.repository;

import com.example.edm_system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEmployee extends JpaRepository<Employee,Long> {
}
