package com.example.edm_system.service.Iservice;

import com.example.edm_system.model.Organization;
import com.example.edm_system.model.Task;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IServiceTask {
    Task getTaskById(Long id);

    void removeTaskById(Long id);

    void addTask(Task newTask);

    void updateTask(Task updateTask);

    List<Task> getAllTask();

    List<Task> getListTaskByAuthorTask(Long idAuthorTask);

    List<Task> getListTaskByExecutorsTask(Long idExecutorsTask);
}
