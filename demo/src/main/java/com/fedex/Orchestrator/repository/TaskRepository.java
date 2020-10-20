package com.fedex.Orchestrator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedex.Orchestrator.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	@Query("select t from Workflow w JOIN w.tasks t where w.id=:id")
	List<Task> findByWorkflowId(@Param("id") long id);
	
	@Query("select t from Workflow w JOIN w.tasks t where w.id=:id")
	Task findTaskByWorkflowId(@Param("id") long id);
	
	

}
