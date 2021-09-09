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

@CrossOrigin("http://localhost:63342/")
@RestController
@RequestMapping("/api/")
public class RESTDepartment {

    private IServiceDepartment service;

    @Autowired
    public RESTDepartment(IServiceDepartment service) {
        this.service = service;
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id) {
        Department department = service.getDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/department")
    public ResponseEntity<List<Department>> getAllDepartmentByIdOrg(HttpServletRequest request) {
        try {
            String idOrganization = request.getParameter("idOrganization");
            Long id =  Long.parseLong(idOrganization);
            List<Department> list = service.getAllDepartmentByIdOrg(id);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }catch (NumberFormatException e){
            List<Department> list = service.getAllDepartment();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
}
