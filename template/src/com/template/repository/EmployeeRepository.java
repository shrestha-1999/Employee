//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.template.repository;

import com.template.model.Emp;

import java.util.ArrayList;

public class EmployeeRepository {
    private ArrayList<Emp> e = new ArrayList();
    private static EmployeeRepository emp;

    private EmployeeRepository() {
    }

    public static EmployeeRepository getInstance() {
        if (emp == null) {
            Class var0 = EmployeeRepository.class;
            synchronized(EmployeeRepository.class) {
                if (emp == null) {
                    emp = new EmployeeRepository();
                }
            }
        }

        return emp;
    }

    public void addEmployee(String name, int age) {
        Emp e1 = new Emp(name, age);
        this.e.add(e1);
    }

    public int getEmployeeId(String name, int age) {
        for(int i = 0; i < this.e.size(); ++i) {
            Emp em = (Emp)this.e.get(i);
            if (em.getName().equals(name) && em.getAge() == age) {
                return i;
            }
        }

        return -1;
    }

    public Emp getEmployeeById(int id) {
        return id >= 0 && id < this.e.size() ? (Emp)this.e.get(id) : null;
    }
}
