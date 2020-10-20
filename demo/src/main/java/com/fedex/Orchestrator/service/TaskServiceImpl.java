package com.fedex.Orchestrator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedex.Orchestrator.model.Task;
import com.fedex.Orchestrator.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Override
	public List<Task> findByWorkflowId(long id) {

		return taskRepository.findByWorkflowId(id);
	}

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

}
