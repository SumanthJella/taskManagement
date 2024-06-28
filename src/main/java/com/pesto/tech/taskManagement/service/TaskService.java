package com.pesto.tech.taskManagement.service;

import com.pesto.tech.taskManagement.entity.Task;
import com.pesto.tech.taskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository theTaskRepository;

    public TaskService() {
    }

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.theTaskRepository = taskRepository;
    }

    List<Task> findAll(){
        return theTaskRepository.findAll();
    }

    List<Task> findByStatus(String status){
        return theTaskRepository.findByStatus(status);
    }

    void save(Task task){
        theTaskRepository.save(task);
    }

    void deleteById(int id){
        theTaskRepository.deleteById(id);
    }

    void update(Task task){
        theTaskRepository.save(task);
    }

}
