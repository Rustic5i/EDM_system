package com.example.edm_system.service.appService;

import com.example.edm_system.model.Employee;
import com.example.edm_system.repository.RepositoryEmployee;
import com.example.edm_system.service.Iservice.IServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEmployee implements IServiceEmployee {

    private RepositoryEmployee repository;

    @Autowired
    public ServiceEmployee(RepositoryEmployee repository) {
        this.repository = repository;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.getById(id);
    }

    @Override
    public void removeEmployeeById(Long id) {
        Employee employee = repository.getById(id);
        if (employee == null){
            System.out.println("ERROR ОШИБКА УДАЛЕНИЯ:  employee С ID: "+id+"нету !");
        }else {
            repository.deleteById(id);
        }
    }

    @Override
    public void addEmployee(Employee newEmployee) {
        repository.save(newEmployee);
    }

    @Override
    public void updateEmployee(Employee updateEmployee) {
        repository.save(updateEmployee);
    }
}
