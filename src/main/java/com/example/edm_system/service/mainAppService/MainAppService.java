package com.example.edm_system.service.mainAppService;

import com.example.edm_system.service.appService.ServiceDeparment;
import com.example.edm_system.service.appService.ServiceEmployee;
import com.example.edm_system.service.appService.ServiceOrganization;
import com.example.edm_system.service.appService.ServiceTask;
import org.springframework.beans.factory.annotation.Autowired;

public class MainAppService {

    private ServiceDeparment serviceDeparment;
    private ServiceEmployee serviceEmployee;
    private ServiceOrganization serviceOrganization;
    private ServiceTask serviceTask;

    @Autowired
    public MainAppService(ServiceDeparment serviceDeparment, ServiceEmployee serviceEmployee, ServiceOrganization serviceOrganization, ServiceTask serviceTask) {
        this.serviceDeparment = serviceDeparment;
        this.serviceEmployee = serviceEmployee;
        this.serviceOrganization = serviceOrganization;
        this.serviceTask = serviceTask;
    }



}
