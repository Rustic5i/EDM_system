package com.example.edm_system.controller;

import com.example.edm_system.model.Department;
import com.example.edm_system.repository.RepositoryDepartment;
import com.example.edm_system.service.Iservice.IServiceDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:63342/")
@RestController
@RequestMapping(value = {"/api/organization/","/api/"})
public class RESTDepartment {

    private IServiceDepartment service;

    @Autowired
    public RESTDepartment(IServiceDepartment service) {
        this.service = service;
    }

    @GetMapping("/department")
    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> list = service.getAllDepartment();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable("id") Long id) {
        Optional<Department> department = service.getDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("{id}/department")
    public ResponseEntity<List<Department>> getAllDepartmentByIdOrg(@PathVariable Long id) {
        List<Department> list = service.getAllDepartmentByIdOrg(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
