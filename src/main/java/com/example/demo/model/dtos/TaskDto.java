package com.example.demo.model.dtos;

import com.example.demo.model.User;
import com.example.demo.model.enums.Status;
import com.example.demo.model.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private long taskId;
    private String title;
    private LocalDateTime dateAdded;
    private Type type;
    private Status status;
    private UserDto userDto;
}
