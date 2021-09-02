package com.example.edm_system.service.appService;
import com.example.edm_system.model.Task;
import com.example.edm_system.repository.RepositoryTask;
import com.example.edm_system.service.Iservice.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTask implements ITaskService {

    private RepositoryTask repository;

    @Autowired
    public ServiceTask(RepositoryTask repository) {
        this.repository = repository;
    }

    @Override
    public Task getTaskById(Long id) {
        return repository.getById(id);
    }

    @Override
    public void removeTaskById(Long id) {
        Task task = repository.getById(id);
        if (task == null){
            System.out.println("ERROR ОШИБКА УДАЛЕНИЯ:  task С ID: "+id+"нету !");
        }else {
            repository.deleteById(id);
        }
    }

    @Override
    public void addTask(Task newTask) {
        repository.save(newTask);
    }

    @Override
    public void updateTask(Task updateTask) {
        repository.save(updateTask);
    }
}
