package com.example.edm_system.repository;

import com.example.edm_system.model.Department;
import com.example.edm_system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryEmployee extends JpaRepository<Employee,Long> {
    @Query("SELECT depart.employee FROM Department depart where depart.id=:id")
    List<Employee> findByIdDepartment(@Param("id") Long id);

}
