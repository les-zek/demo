package com.example.demo.controller;

import com.example.demo.mapper.TaskMapper;
import com.example.demo.model.dtos.CreateTaskDto;
import com.example.demo.model.dtos.CreateUserDto;
import com.example.demo.model.dtos.TaskDto;
import com.example.demo.model.dtos.UpdateTaskDto;
import com.example.demo.model.enums.Status;
import com.example.demo.model.enums.Type;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {


    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;
    // tworzenie zadania dla podanego użytkownika


    @PostMapping("/addTask")
    public void addTask(CreateTaskDto createTaskDto) {
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

    @GetMapping("/tasks/filterTasks")
    private List<TaskDto> getTasksByStatusAndTypeAndUser(
            @RequestParam("status") Status status,
            @RequestParam("type") Type type,
            @RequestParam("userId") long userId
    ) {
        return taskMapper.toDtos(taskService.getTaskByStatusAndTypeAndUser(status, type, userId));

    }
    @PutMapping("/updateTask")
    public void updateTask(UpdateTaskDto updateTaskDto) {
        taskService.updateTask(taskMapper.fromDto(updateTaskDto));
    }

    @PutMapping("/updateTaskUser")
    public void updateTaskUser(@RequestParam("taskId") long taskId,
                               @RequestParam("userId") long userId)
    {
        taskService.updateTaskUser(taskId,userId);
    }
    // dodatkowa metoda - wyswietl wszystkie taski o wybranym statusie

    @GetMapping("/tasks/filterTasksByStatus")
    private List<TaskDto> getTasksByStatus(
            @RequestParam("status") Status status
    ) {
        return taskMapper.toDtos(taskService.getTasksByStatus(status));
    }
    // dodatkowa metoda - wyswietl wszystkie taski o wybranym typie

    @GetMapping("/tasks/filterTasksByType")
    private List<TaskDto> getTasksByType(
            @RequestParam("type") Type type
    ) {
        return taskMapper.toDtos(taskService.getTasksByType(type));
    }
}
