package com.demo.searchcriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

@Configuration
@Component
@EnableJpaRepositories
public class ExampleClient {
    @Autowired
    private  EmployeeRepository employeeRepository;

    @Bean
    EntityManagerFactory entityManagerFactory() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("example-unit");
        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }


    public void startup()

    {

        List<Employee> em = createEmployees();
        employeeRepository.saveAll(em);

        Specification<Employee> es = EmployeeSpecifications.getEmployeesByGender(Enum.GENDER.MALE);
        List<Employee> employees = employeeRepository.findAll(es);
        for(Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public List<Employee> createEmployees() {
        return Arrays.asList(new Employee("Diana", Enum.GENDER.FEMALE), new Employee("Sandeepan", Enum.GENDER.MALE));
    }
}
