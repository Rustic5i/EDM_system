package com.example.edm_system.service.appService;

import com.example.edm_system.model.Organization;
import com.example.edm_system.repository.RepositoryOrganization;
import com.example.edm_system.service.Iservice.IServiceOrganizatio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOrganization implements IServiceOrganizatio {

    private RepositoryOrganization repository;

    @Autowired
    public ServiceOrganization(RepositoryOrganization repository) {
        this.repository = repository;
    }

    @Override
    public Organization getOrganizationById(Long id) {
        return repository.getById(id);
    }

    @Override
    public void removeOrganizationById(Long id) {
        Organization organization = repository.getById(id);
        if (organization == null){
            System.out.println("ERROR ОШИБКА УДАЛЕНИЯ:  organization С ID: "+id+"нету !");
        }else {
            repository.deleteById(id);
        }
    }

    @Override
    public void addOrganization(Organization newOrganization) {
        repository.save(newOrganization);
    }

    @Override
    public void updateOrganization(Organization updateOrganization) {
        repository.save(updateOrganization);
    }

    @Override
    public List<Organization> getAllOrganization() {
        return repository.findAll();
    }
}
