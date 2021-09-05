package com.example.edm_system.service.appService;

import com.example.edm_system.model.Department;
import com.example.edm_system.repository.RepositoryDepartment;
import com.example.edm_system.service.Iservice.IServiceDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDeparment implements IServiceDepartment {

    private RepositoryDepartment repository;

    @Autowired
    public ServiceDeparment(RepositoryDepartment repository) {
        this.repository = repository;
    }

    @Override
    public Department getDepartmentById(Long id) {
        return repository.getById(id);
    }

    @Override
    public void removeDepartmentById(Long id) {
        Department department = repository.getById(id);
        if (department == null){
            System.out.println("ERROR ОШИБКА УДАЛЕНИЯ:  department С ID: "+id+"нету !");
        }else {
            repository.deleteById(id);
        }
    }

    @Override
    public void addDepartment(Department newDepartment) {
        repository.save(newDepartment);
    }

    @Override
    public void updateDepartment(Department updateDepartment) {
        repository.save(updateDepartment);
    }

    @Override
    public List<Department> getAllDepartment() {
        return repository.findAll();
    }
}
