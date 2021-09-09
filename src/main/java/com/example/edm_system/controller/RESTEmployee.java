package com.example.edm_system.controller;

import com.example.edm_system.model.Department;
import com.example.edm_system.model.Employee;
import com.example.edm_system.service.appService.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/", "/api/organization/{id}/department",
        "/api/organization/department"})
public class RESTEmployee {
    private ServiceEmployee service;

    @Autowired
    public RESTEmployee(ServiceEmployee service) {
        this.service = service;
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        Employee employee = service.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/{IdDepartment}/employee")
    public ResponseEntity<List<Employee>> getListEmployeeByIdDepartment(@PathVariable Long IdDepartment) {
        List<Employee> employees = service.findByEmployeeByIdDepartment(IdDepartment);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
