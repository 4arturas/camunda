package com.example.workflow.camunda;

import com.example.workflow.camunda.dto.ProcessDefinitionDto;
import com.example.workflow.camunda.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/camunda")
@RequiredArgsConstructor
public class CamundaController
{

    private final CamundaService camundaService;

    @GetMapping("/process-definitions")
    public List<ProcessDefinitionDto> getProcessDefinitions()
    {
        return camundaService.getDeployedProcessDefinitions();
    }

    @PostMapping("/process/{processKey}/start")
    public void startProcess(@PathVariable String processKey )
    {
        camundaService.startProcess( processKey );
    }

    @GetMapping("/tasks/active")
    public List<TaskDto> getProcessInstances()
    {
        return camundaService.getActiveTasks();
    }
}
