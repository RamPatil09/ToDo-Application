package com.practice.ToDo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.ToDo.dto.TaskDto;
import com.practice.ToDo.model.Task;
import com.practice.ToDo.service.TaskServiceImpl;

@Controller
public class TaskController {

	@Autowired
	private TaskServiceImpl impl;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage(Model model) {
		List<Task> all = impl.getAll();
		model.addAttribute("tasklist", all);
		return "index";
	}

	@RequestMapping(value = "/addtask", method = RequestMethod.GET)
	public String addTask(Model model) {
		TaskDto dto = new TaskDto();
		model.addAttribute("dto", dto);
		return "input";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("taskDto") TaskDto taskDto) {
		impl.save(taskDto);
		return "redirect:/home";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") long id) {
		impl.deleteById(id);
		return "redirect:/home";
	}

	@RequestMapping(value = "/statuschange/{id}", method = RequestMethod.GET)
	public String statusChange(@PathVariable Long id) {
		impl.updateStatus(id);
		return "redirect:/home";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		Task task = impl.getById(id);
		model.addAttribute("task", task);
		return "edit";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editSave(TaskDto dto) {
		if (impl.editSave(dto)) {
			return "redirect:/home";
		}
		return "redirect:/edit/" + dto.getId();
	}

}
