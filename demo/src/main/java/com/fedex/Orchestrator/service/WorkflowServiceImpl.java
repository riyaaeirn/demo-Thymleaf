package com.fedex.Orchestrator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fedex.Orchestrator.model.Workflow;
import com.fedex.Orchestrator.repository.WorkflowRepository;

@Service
public class WorkflowServiceImpl implements WorkflowService {

	@Autowired
	private WorkflowRepository workflowRepository;

	@Override
	public List<Workflow> getAllWorkflows() {
		return workflowRepository.findAll();
	}

	@Override
	public void saveWorkflow(Workflow workflow) {
		this.workflowRepository.save(workflow);
	}

	@Override
	public Workflow getWorkflowById(long id) {
		Optional<Workflow> optional = workflowRepository.findById(id);
		Workflow workflow = null;
		if (optional.isPresent()) {
			workflow = optional.get();
		} else {
			throw new RuntimeException(" Workflow not found for id :: " + id);
		}
		return workflow;
	}

	@Override
	public void deleteWorkflowById(long id) {
		this.workflowRepository.deleteById(id);
	}

	
}
