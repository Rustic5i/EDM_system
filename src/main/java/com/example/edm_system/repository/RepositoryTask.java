package com.example.edm_system.repository;

import com.example.edm_system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryTask extends JpaRepository<Task,Long> {
    @Query("SELECT task FROM Task task WHERE task.authorTask.id=:idAuthorTask")
    List<Task> getListTaskByAuthorTask(@Param("idAuthorTask") Long idAuthorTask);

    @Query("SELECT task FROM Task task WHERE task.executorsTask.id=:idExecutorsTask")
    List<Task> getListTaskByExecutorsTask(@Param("idExecutorsTask") Long idExecutorsTask);
}
