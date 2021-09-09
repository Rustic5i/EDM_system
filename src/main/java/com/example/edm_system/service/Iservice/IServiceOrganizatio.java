package com.example.edm_system.service.Iservice;

import com.example.edm_system.model.Organization;

import java.util.List;
import java.util.Optional;

public interface IServiceOrganizatio {
    Optional<Organization> getOrganizationById(Long id);

    void removeOrganizationById(Long id);

    void addOrganization(Organization newOrganization);

    void updateOrganization(Organization updateOrganization);
    List<Organization> getAllOrganization();
}
