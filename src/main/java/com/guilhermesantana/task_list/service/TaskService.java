package com.guilhermesantana.task_list.service;

import com.guilhermesantana.task_list.models.Tasks;
import com.guilhermesantana.task_list.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TasksRepository tasksRepository;

    public TaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public Tasks createTask(Tasks tasks) {
        return tasksRepository.creteTask(tasks);
    }

    public List<Tasks> findAll() {
        return tasksRepository.findAll();
    }
}
