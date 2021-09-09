package com.example.edm_system.service.appService;

import com.example.edm_system.model.Organization;
import com.example.edm_system.repository.RepositoryOrganization;
import com.example.edm_system.service.Iservice.IServiceOrganizatio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrganization implements IServiceOrganizatio {

    private RepositoryOrganization repository;

    @Autowired
    public ServiceOrganization(RepositoryOrganization repository) {
        this.repository = repository;
    }

//    По сути, getOne - это операция отложенной загрузки. Таким образом,
//    вы получаете только ссылку (прокси) на объект. Это означает,
//    что доступ к БД фактически не осуществляется. Только когда вы вызываете
//    его свойства, он будет запрашивать БД. findByID выполняет вызов «нетерпеливо» / немедленно,
//    когда вы его вызываете, таким образом, у вас есть фактическая сущность полностью заполненной.
    @Override
    public Optional<Organization> getOrganizationById(Long id) {
      //  return repository.getById(id);
        return repository.findById(id);
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
