package com.example.demo.mapper;


import com.example.demo.model.Task;
import com.example.demo.model.dtos.CreateTaskDto;
import com.example.demo.model.dtos.TaskDto;
import com.example.demo.model.dtos.UpdateTaskDto;
import com.example.demo.model.dtos.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {
@Autowired
private UserService userService;
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getTaskId(),
                task.getTitle(),
                task.getDateAdded(),
                task.getType(),
                task.getStatus(),
                new UserDto(task.getUser().getId(), task.getUser().getName())
        );
    }

    public List<TaskDto> toDtos(List<Task> tasks) {
        return tasks.stream().map(task -> toDto(task)).collect(Collectors.toList());
    }

    public Task fromDto(CreateTaskDto createTaskDto) {
        Task task = new Task();
        task.setTitle(createTaskDto.getTitle());
        task.setDateAdded(LocalDateTime.now());
        task.setType(createTaskDto.getType());
        task.setStatus(createTaskDto.getStatus());
        // zwraca usera po id przypisujacej wlasciciela zadania
        task.setUser(userService.getUser(createTaskDto.getUserId()));
        // getUserbyId
        return task;
    }

    public Task fromDto(UpdateTaskDto updateTaskDto) {
        Task task = new Task();
        task.setTaskId(updateTaskDto.getTaskId());
        task.setTitle(updateTaskDto.getTitle());
//        task.setDateAdded(LocalDateTime.now());
        task.setType(updateTaskDto.getType());
        task.setStatus(updateTaskDto.getStatus());
        return task;
    }
}
