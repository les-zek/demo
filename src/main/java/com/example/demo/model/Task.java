package com.example.demo.model;


import com.example.demo.model.enums.Status;
import com.example.demo.model.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;
    private String title;
    private LocalDateTime dateAdded;
    private Type type;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
}
