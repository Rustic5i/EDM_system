package com.example.edm_system;

import com.example.edm_system.model.Employee;
import com.example.edm_system.repository.RepositoryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Test {
    @Autowired
    private RepositoryEmployee repository;

    @PostConstruct
    @Transactional
    public void test(){
//        System.out.println("START");
//        List<Employee> list = repository.getAllEmployeeByIdOrganizationAndIdDepartment(1L,1L);
//        System.out.println(list);
    }
}
