package com.demo.searchcriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class ExampleMain {
    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String [] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExampleClient.class);

        ExampleClient ec = context.getBean(ExampleClient.class);
        ec.startup();
    }
}
