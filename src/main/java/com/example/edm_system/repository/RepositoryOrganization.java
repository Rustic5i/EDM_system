package com.example.edm_system.repository;

import com.example.edm_system.model.Department;
import com.example.edm_system.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryOrganization extends JpaRepository<Organization,Long> {
}
