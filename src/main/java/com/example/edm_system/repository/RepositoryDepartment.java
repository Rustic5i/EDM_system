package com.example.edm_system.repository;

import com.example.edm_system.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryDepartment extends JpaRepository<Department,Long> {

    @Query("SELECT org.department FROM Organization org where org.id=:id")
    List<Department> getAllDepartmentByIdOrg(@Param("id") Long id);
}
