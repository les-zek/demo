package com.example.demo.repository;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.model.enums.Status;
import com.example.demo.model.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUser(User user);

    List<Task> findAllByStatusAndTypeAndUser(Status status, Type type, User user);
//  dodatkowa metoda 2 - pokaz wszystkie taski o wybranym statusie
    List<Task> findAllByStatus(Status status);
// dodatkowa metoda 3 - pokaz wszystkie taski o wybranym typie

    List<Task> findAllByType(Type type);



}



