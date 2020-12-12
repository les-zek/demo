package com.example.demo.controller;

import com.example.demo.mapper.TaskMapper;
import com.example.demo.model.dtos.CreateTaskDto;
import com.example.demo.model.dtos.CreateUserDto;
import com.example.demo.model.dtos.TaskDto;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {


    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;
    // tworzenie zadania dla podanego użytkownika


    @PostMapping("/addTask")
    public void addTaks(CreateTaskDto createTaskDto) {
        taskService.createTask(taskMapper.fromDto(createTaskDto));
    }


    @GetMapping("/tasks/{taskId}")
    public TaskDto getTask(@PathVariable("taskId") long taskId) {
        return taskMapper.toDto(taskService.getTask(taskId));

    }

    @GetMapping("/tasks/userId={userId}")
    public List<TaskDto> getTaskByUser(@PathVariable("userId") long userId) {
        return taskMapper.toDtos(taskService.getTasksByUser(userId));

    }
}
