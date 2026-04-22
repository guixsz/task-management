package com.guilhermesantana.task_list.service;

import com.guilhermesantana.task_list.models.Tasks;
import com.guilhermesantana.task_list.models.dtos.TaskDTO;
import com.guilhermesantana.task_list.repository.TasksRepository;
import com.guilhermesantana.task_list.util.DateFormat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private TasksRepository tasksRepository;

    public TaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public Tasks createTask(Tasks tasks) {
        return tasksRepository.creteTask(tasks);
    }

    public List<TaskDTO> findAll() {
        List<Tasks> tasksList = tasksRepository.findAll();
        return tasksList.stream()
                .map(task -> new TaskDTO(
                        task.getTitle(),
                        task.getDescription(),
                        DateFormat.dateFormatted(task.getDate()),
                        task.getLocation(),
                        DateFormat.toHour(task.getDate()),
                        task.getCategory()
                ))
                .collect(Collectors.toList());
    }
}
