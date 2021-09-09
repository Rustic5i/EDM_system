package com.example.edm_system.controller;

import com.example.edm_system.model.Organization;
import com.example.edm_system.service.Iservice.IServiceOrganizatio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RESTOrganization {
    private IServiceOrganizatio service;

    @Autowired
    public RESTOrganization(IServiceOrganizatio service) {
        this.service = service;
    }

    @GetMapping("/organization")
    public ResponseEntity<List<Organization>> getAllOrganization(){
        List<Organization> list = service.getAllOrganization();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/organization/{id}")
    public ResponseEntity<Optional<Organization>> getDepartmentById(@PathVariable("id") Long id){
        Optional<Organization> organization = service.getOrganizationById(id);
        return new ResponseEntity<>(organization,HttpStatus.OK);
    }
}
