package com.example.demo.controller;

import com.example.demo.mapper.TaskMapper;
import com.example.demo.model.dtos.*;
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
// dodatkowo metoda 1 - pokaz wszystkie taski w kolejnosci od najstarszego do najnowszego

    @GetMapping("/tasks")
    public List<TaskDto> getTasks(){
        return taskMapper.toDtos(taskService.getTasks());
    }
//  dodatkowa metoda 2 - pokaz wszystkie taski o wybranym statusie

    @GetMapping("/tasks/status={status}")
    public List<TaskDto> getTasksByStatus(@PathVariable("status") Status status) {
        return taskMapper.toDtos(taskService.getTasksByStatus(status));
    }
// dodatkowa metoda 3 - pokaz wszystkie taski o wybranym typie

    @GetMapping("/tasks/type={type}")
    public List<TaskDto> getTasksByType(@PathVariable("type") Type type) {
        return taskMapper.toDtos(taskService.getTasksByType(type));
    }
}
