package com.fedex.Orchestrator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fedex.Orchestrator.model.Task;
import com.fedex.Orchestrator.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/getTaskForm")
	public String getTaskForm(Model model) {
		List<Task> listTasks = taskService.getAllTask();

		model.addAttribute("listTasks", listTasks);
		return "taskForm";

	}

	@GetMapping("/getTaskFormByID/{id}")
	public String getTaskFormByID(@PathVariable(value = "id") long id, Model model) {

		List<Task> listTasks = taskService.findByWorkflowId(id);
		System.out.println("listTasks " + listTasks);
		model.addAttribute("listTasks", listTasks);
		return "taskForm";
	}

}
