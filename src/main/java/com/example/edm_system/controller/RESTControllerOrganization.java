package com.example.edm_system.controller;

import com.example.edm_system.model.Organization;
import com.example.edm_system.service.Iservice.IOrganizatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTControllerOrganization {
    private IOrganizatioService service;

    @Autowired
    public RESTControllerOrganization(IOrganizatioService service) {
        this.service = service;
    }

    @GetMapping("/organization")
    public ResponseEntity<List<Organization>> getOrganization(){
        List<Organization> list = service.getAllOrganization();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
