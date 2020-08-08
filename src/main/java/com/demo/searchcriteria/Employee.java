package com.demo.searchcriteria;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Enum.GENDER gender;

    public  Employee(){

    }

    public Employee(String name, Enum.GENDER gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}