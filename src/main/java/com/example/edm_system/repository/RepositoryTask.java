package com.example.edm_system.repository;

import com.example.edm_system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTask extends JpaRepository<Task,Long> {
}
