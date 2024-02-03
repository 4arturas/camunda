package com.example.workflow.flow;

import camundajar.impl.scala.Int;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Slf4j
@Named(value="Flow1")
public class Flow1 implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution)
    {
        String creditor = (String) delegateExecution.getVariable("creditor");
        Double amount = (Double) delegateExecution.getVariable("amount");
        Integer counter = (Integer) delegateExecution.getVariable("counter");
        final Integer random = (Integer) delegateExecution
                .getVariable(
                        com.example.workflow.flow.Flow2.RANDOM
                );
        log.info( ":: Flow1 random=%d".formatted(random) );
    }
}
