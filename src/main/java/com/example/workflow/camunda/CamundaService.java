package com.example.workflow.camunda;

import com.example.workflow.camunda.dto.ProcessDefinitionDto;
import com.example.workflow.camunda.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CamundaService
{
    private final RepositoryService repositoryService;
    private final RuntimeService runtimeService;
    private final TaskService taskService;
    public List<ProcessDefinitionDto> getDeployedProcessDefinitions()
    {
        return repositoryService
                .createProcessDefinitionQuery()
                .list()
                .stream()
                .map( ProcessDefinitionDto::of)
                .collect(Collectors.toList());
    }

    public void startProcess(String processKey)
    {
        runtimeService.startProcessInstanceById(processKey);
    }

    public List<TaskDto> getActiveTasks()
    {
        return taskService.createTaskQuery()
                .active()
                .list()
                .stream()
                .map(TaskDto::of)
                .collect(Collectors.toList());
    }
}
