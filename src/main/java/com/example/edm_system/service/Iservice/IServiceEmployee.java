package com.example.edm_system.service.Iservice;

import com.example.edm_system.model.Department;
import com.example.edm_system.model.Employee;
import com.example.edm_system.model.Organization;

import java.util.List;

public interface IServiceEmployee {
    Employee getEmployeeById(Long id);

    void removeEmployeeById(Long id);

    void addEmployee(Employee newEmployee);

    void updateEmployee(Employee updateEmployee);

    List<Employee> findByEmployeeByIdDepartment(Long IdDepartment);

    List<Employee> getAllEmployee();
}
