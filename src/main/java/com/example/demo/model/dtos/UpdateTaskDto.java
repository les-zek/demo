package com.example.demo.model.dtos;

import com.example.demo.model.enums.Status;
import com.example.demo.model.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskDto {
    private long taskId;
    private String title;
    private Type type;
    private Status status;
}
