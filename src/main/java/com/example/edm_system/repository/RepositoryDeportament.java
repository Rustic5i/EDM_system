package com.example.edm_system.repository;

import com.example.edm_system.model.Department;
import com.example.edm_system.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryDeportament extends JpaRepository<Department,Long> {
}
