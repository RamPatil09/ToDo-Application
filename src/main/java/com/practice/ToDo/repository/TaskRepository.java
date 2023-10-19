package com.practice.ToDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.ToDo.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
