package com.example.workflow.flow;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


@Slf4j
public class Flow2 implements JavaDelegate
{
    final static String RANDOM = "random";
    @Override
    public void execute(DelegateExecution delegateExecution)
    {
        final int random = Math.random() > 0.5 ? 1 : 0;
        delegateExecution.setVariable(RANDOM, random);
        log.info(":: Flow2 %s=%d".formatted(RANDOM, random));
    }
}
