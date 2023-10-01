//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.template.repository;

import com.template.model.Employee;

import java.util.ArrayList;

public class EmployeeRepository {
    private ArrayList<Employee> employees;

    private static EmployeeRepository emp;

    private EmployeeRepository() {

        employees = new ArrayList<>();
    }


    public static EmployeeRepository getInstance() {
        if (emp == null) {
            synchronized (EmployeeRepository.class) {
                if (emp == null) {
                    emp = new EmployeeRepository();
                }
            }
        }

        return emp;
    }

    public void addEmployee(String name, int age) {
        Employee e1 = new Employee(name, age);
        this.employees.add(e1);
    }
    public int getEmployeeId(String name, int age) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getName().equals(name) && employee.getAge() == age) {
                return i; // Index of the employee in the ArrayList
            }
        }
        return -1;
    }


    public Employee getEmployeeById(int id) {
        if (id >= 0 && id < employees.size()) {
            return employees.get(id);
        }
        return null; // Employee not found
    }
}
