package com.practice.ToDo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.ToDo.dto.TaskDto;
import com.practice.ToDo.model.Task;
import com.practice.ToDo.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repository;

	@Override
	public void save(TaskDto taskDto) {
		try {
			Task task = new Task();
			task.setTitle(taskDto.getTitle());
			task.setDescription(taskDto.getDescription());
			task.setDueDate(taskDto.getDueDate());
			task.setStatus(taskDto.getStatus());

			repository.save(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Task> getAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Task getById(Long id) {
		Task task = repository.findById(id).get();
		return task;
	}

	@Override
	public boolean updateStatus(Long id) {
		Task task = getById(id);
		task.setStatus("Completed");
		return saveOrUpdate(task);
	}

	public boolean saveOrUpdate(Task task) {
		Task task2 = repository.save(task);
		if (getById(task2.getId()) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean editSave(TaskDto dto) {
		Task saved = getById(dto.getId());
		saved.setTitle(dto.getTitle());
		saved.setDescription(dto.getDescription());
		saved.setDueDate(dto.getDueDate());
		saved.setStatus(dto.getStatus());
		Task save = repository.save(saved);
		if (getById(save.getId()) != null) {
			return true;
		}
		return false;
	}

}
