package com.example.edm_system.service.Iservice;

import com.example.edm_system.model.Organization;
import com.example.edm_system.model.Task;

public interface IServiceTask {
    Task getTaskById(Long id);

    void removeTaskById(Long id);

    void addTask(Task newTask);

    void updateTask(Task updateTask);
}
