package com.valtech.training.day3;

import java.util.Random;

 

public class EmployeeGenerator {

    private static final String[] FIRST_NAMES = {"John", "Jane", "Michael", "Emily", "David", "Sarah"};


    private static final int MIN_AGE = 22;
    private static final int MAX_AGE = 65;
    private static final int MIN_SALARY = 30000;
    private static final int MAX_SALARY = 100000;
    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 5;
    private static final int MIN_EXPERIENCE = 0;
    private static final int MAX_EXPERIENCE = 20;
    private static Random random = new Random();

    public static class Employee {
        String name;
        int age;
        int salary;
        int level;
        int experience;

        public Employee(String name, int age, int salary, int level, int experience) {
        	this.name = name;
            this.age = age;
            this.salary = salary;
            this.level = level;
            this.experience = experience;

        }

 

        @Override
        public String toString() {
            return "Name: " + name + ", Age: " + age + ", Salary: $" + salary + ", Level: " + level + ", Experience: " + experience + " years";

        }

    }


    public static Employee generateRandomEmployee() {

        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String name = firstName;
        int age = random.nextInt(MAX_AGE - MIN_AGE + 1) + MIN_AGE;
        int salary = random.nextInt(MAX_SALARY - MIN_SALARY + 1) + MIN_SALARY;
        int level = random.nextInt(MAX_LEVEL - MIN_LEVEL + 1) + MIN_LEVEL;
        int experience = random.nextInt(MAX_EXPERIENCE - MIN_EXPERIENCE + 1) + MIN_EXPERIENCE;
        return new Employee(name, age, salary, level, experience);

    }

    public static void main(String[] args) {
        Employee randomEmployee = generateRandomEmployee();
        System.out.println(randomEmployee);

    }
}