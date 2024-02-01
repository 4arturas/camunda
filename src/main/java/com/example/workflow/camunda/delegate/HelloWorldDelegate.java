package com.example.workflow.camunda.delegate;

import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.Expression;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Named("helloworld")
@Service
public class HelloWorldDelegate implements JavaDelegate
{
    private Expression text;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Hello world!");

        String var = (String) text.getValue(delegateExecution);
        System.out.println(var);

        String exampleVar = (String) delegateExecution.getVariable("example");
        System.out.println(exampleVar);

    }
}
