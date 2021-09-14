package com.example.edm_system.controller;

import com.example.edm_system.model.Task;
import com.example.edm_system.service.Iservice.IServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTTask {

    private IServiceTask service;

    @Autowired
    public RESTTask(IServiceTask service) {
        this.service = service;
    }

    @GetMapping("/task")
    private ResponseEntity<List<Task>> getAllTask() {
        List<Task> list = service.getAllTask();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/task", params = "executors")
    private ResponseEntity<List<Task>> getListTaskByExecutors(@RequestParam(value = "executors", required = false) Long executors) {
        List<Task> list = service.getListTaskByExecutorsTask(executors);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/task", params = "author")
    private ResponseEntity<List<Task>> getListTaskByAuthorTask(@RequestParam(value = "author", required = false) Long idAuthor) {
        List<Task> list = service.getListTaskByAuthorTask(idAuthor);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
