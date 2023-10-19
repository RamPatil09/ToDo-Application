package com.practice.ToDo.service;

import java.util.List;

import com.practice.ToDo.dto.TaskDto;
import com.practice.ToDo.model.Task;

public interface TaskService {

	void save(TaskDto taskDto);

	List<Task> getAll();

	void deleteById(Long id);

	Task getById(Long id);

	boolean updateStatus(Long id);

	boolean saveOrUpdate(Task task);

	boolean editSave(TaskDto dto);
}
