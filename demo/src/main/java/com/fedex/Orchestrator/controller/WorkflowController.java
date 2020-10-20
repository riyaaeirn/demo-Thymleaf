package com.fedex.Orchestrator.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fedex.Orchestrator.model.Workflow;
import com.fedex.Orchestrator.service.WorkflowService;

@Controller
public class WorkflowController {

	@Autowired
	private WorkflowService workflowService;

	// For home Page
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return "index";
	}

	@GetMapping("/displayBarGraph")
	public String barGraph(Model model) {
		Map<String, Integer> surveyMap = new LinkedHashMap<>();
		surveyMap.put("CREATED", 15);
		surveyMap.put("INPROGRESS", 4);
		surveyMap.put("SCHEDULED", 5);
		surveyMap.put("COMPLETED", 9);

		model.addAttribute("surveyMap", surveyMap);
		return "barGraph";
	}

	@GetMapping("/displayPieChart")
	public String pieChart(Model model) {
		model.addAttribute("CREATED", 15);
		model.addAttribute("INPROGRESS", 4);
		model.addAttribute("SCHEDULED", 5);
		model.addAttribute("COMPLETED", 9);
		return "pieChart";
	}

	// END

	@GetMapping("/saveWokflowForm")
	public String saveWokflowForm(Model model) {
		Workflow workflow = new Workflow();
		model.addAttribute("workflow", workflow);
		return "saveWorkflow";
	}

	@PostMapping("/saveWorkflow")
	public String saveWorkflow(@ModelAttribute("workflow") Workflow workflow) {

		workflowService.saveWorkflow(workflow);
		return "redirect:/";
	}

	@GetMapping("/updateWorkflowForm")
	public String updateWorkflowForm(Model model) {

		List<Workflow> listWorkflows = workflowService.getAllWorkflows();

		model.addAttribute("listWorkflows", listWorkflows);
		return "updateWorkflowHome";

	}

	@GetMapping("/viewWorkflowForm")
	public String viewWorkflowForm(Model model) {
		List<Workflow> listWorkflows = workflowService.getAllWorkflows();
		model.addAttribute("listWorkflows", listWorkflows);
		return "viewWorkflowHome";
	}

	@GetMapping("/deleteWorkflowForm")
	public String deleteWorkflowForm(Model model) {
		List<Workflow> listWorkflows = workflowService.getAllWorkflows();
		model.addAttribute("listWorkflows", listWorkflows);
		return "deleteWorkflowHome";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		Workflow workflow = workflowService.getWorkflowById(id);

		model.addAttribute("workflow", workflow);
		return "update_workflow";
	}

	@GetMapping("/viewWorkflow/{id}")
	public String viewWorkflow(@PathVariable(value = "id") long id, Model model) {

		Workflow workflow = workflowService.getWorkflowById(id);

		model.addAttribute("workflow", workflow);
		return "view_workflow";
	}

	@GetMapping("/deleteWorkflow/{id}")
	public String deleteWorkflow(@PathVariable(value = "id") long id) {

		this.workflowService.deleteWorkflowById(id);
		return "redirect:/";
	}

}
