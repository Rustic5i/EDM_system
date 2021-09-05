package com.example.edm_system.service.Iservice;

import com.example.edm_system.model.Department;

import java.util.List;

public interface IServiceDepartment {
    Department getDepartmentById(Long id);

    void removeDepartmentById(Long id);

    void addDepartment(Department newDepartment);

    void updateDepartment(Department updateDepartment);

    List<Department> getAllDepartment();
}
