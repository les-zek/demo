package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.model.enums.Status;
import com.example.demo.model.enums.Type;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
@Autowired
private UserRepository userRepository;

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public Task getTask(long taskId) {
        return taskRepository.findById(taskId).orElseGet(() -> new Task());
    }

    public List<Task> getTasksByUser(long userId) {
        User user = userRepository.findById(userId).orElseGet(()-> new User());
        return taskRepository.findAllByUser(user);
    }

    public List<Task> getTaskByStatusAndTypeAndUser(Status status, Type type, long userId){
        User user = userRepository.findById(userId).orElseGet(()-> new User());
        return taskRepository.findAllByStatusAndTypeAndUser(status, type, user);
    }

    public void updateTask(Task task) {
        taskRepository.save(task);

    }
    public void updateTaskUser(long taskId, long userId ){
        Task task=getTask(taskId);
        User user= userRepository.findById(userId).orElseGet(()-> new User());
        task.setUser(user);
        taskRepository.save(task);
    }
}
