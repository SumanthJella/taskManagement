package com.pesto.tech.taskManagement.service;

import com.pesto.tech.taskManagement.entity.Task;
import com.pesto.tech.taskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService() {
    }

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    List<Task> findAll(){
        return taskRepository.findAll();
    }

    List<Task> findByStatus(String status){
        return taskRepository.findByStatus(status);
    }

    void save(Task task){
        taskRepository.save(task);
    }

    void deleteById(int id){
        taskRepository.deleteById(id);
    }

    void update(Task task){
        taskRepository.save(task);
    }

}
