//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.servlet.register;

import java.util.ArrayList;

public class EmployeeControl {
    private ArrayList<Emp> e = new ArrayList();
    private static EmployeeControl emp;

    private EmployeeControl() {
    }

    public static EmployeeControl getInstance() {
        if (emp == null) {
            Class var0 = EmployeeControl.class;
            synchronized(EmployeeControl.class) {
                if (emp == null) {
                    emp = new EmployeeControl();
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
