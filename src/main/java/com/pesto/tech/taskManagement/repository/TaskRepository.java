package com.pesto.tech.taskManagement.repository;

import com.pesto.tech.taskManagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByStatus(String status);


}
