package com.guilhermesantana.task_list.controller;

import com.guilhermesantana.task_list.config.EmailService;
import com.guilhermesantana.task_list.models.Tasks;
import com.guilhermesantana.task_list.models.dtos.TaskDTO;
import com.guilhermesantana.task_list.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final EmailService emailService;
    private TaskService taskService;

    public TaskController(TaskService taskService, EmailService emailService) {
        this.taskService = taskService;
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Tasks> CreateTask(@Valid @RequestBody Tasks task) {
        Tasks newTask = taskService.createTask(task);
        return ResponseEntity.ok(newTask);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAll() {
        List<TaskDTO> list = taskService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/emails")
    public String dispararTeste() {
        emailService.checkTasksComing();
        return "Emails disparados com Sucesso";
    }
}
