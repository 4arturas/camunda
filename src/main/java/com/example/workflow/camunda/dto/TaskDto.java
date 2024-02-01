package com.example.workflow.camunda.dto;

import lombok.Value;
import org.camunda.bpm.engine.task.Task;

import java.util.Date;

@Value
public class TaskDto
{
    String id;
    String name;
    String assignee;
    Date created;
    String processInstanceId;
    String taskDefinitionKey;

    public static TaskDto of( Task t )
    {
        return new TaskDto(
                t.getId(),
                t.getName(),
                t.getAssignee(),
                t.getCreateTime(),
                t.getProcessDefinitionId(),
                t.getTaskDefinitionKey()
        );
    }
}
