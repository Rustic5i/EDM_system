package com.example.edm_system.service.Iservice;

import com.example.edm_system.model.Department;
import com.example.edm_system.model.Organization;

public interface IOrganizatioService {
    Organization getOrganizationById(Long id);

    void removeOrganizationById(Long id);

    void addOrganization(Organization newOrganization);

    void updateOrganization(Organization updateOrganization);
}
