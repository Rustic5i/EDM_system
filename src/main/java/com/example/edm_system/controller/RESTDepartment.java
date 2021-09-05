package com.example.edm_system.controller;

import com.example.edm_system.model.Department;
import com.example.edm_system.repository.RepositoryDepartment;
import com.example.edm_system.service.Iservice.IServiceDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:63342/")
@RestController
@RequestMapping("/api/organization/")
public class RESTDepartment {

    private IServiceDepartment service;
    @Autowired
    private RepositoryDepartment repository;

    @Autowired
    public RESTDepartment(IServiceDepartment service) {
        this.service = service;
    }

    @GetMapping("/department")
    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> list = service.getAllDepartment();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id){
        Department department = service.getDepartmentById(id);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }
    @GetMapping("/{id}/department/")
    public ResponseEntity<List<Department>> getAllDepartmentByIdOrg(@PathVariable("id") Long id){
        List<Department> list = repository.getAllDepartmentByIdOrg(id);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
