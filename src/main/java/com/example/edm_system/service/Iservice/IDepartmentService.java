package com.example.edm_system.service.Iservice;

import com.example.edm_system.model.Department;

public interface IDepartmentService {
    Department getDepartmentById(Long id);

    void removeDepartmentById(Long id);

    void addDepartment(Department newDepartment);

    void updateDepartment(Department updateDepartment);
}
