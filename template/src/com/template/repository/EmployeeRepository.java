//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.template.repository;

import com.template.model.Employee;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeRepository {
    private static EmployeeRepository emp;

    public EmployeeRepository() throws ClassNotFoundException {
        // Constructor (you can also set up the JDBC connection here if needed)
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public int addEmployee(String name, int age) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@99")) {
            connection.setAutoCommit(true);
            System.out.println("obtained connection");
            String sql = "INSERT INTO employee_db (name, age) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately

        }
        return -1;
    }

    public Employee getEmployeeById(int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@99");
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee_db WHERE id = ?")) {

            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                return new Employee(name, age, id);
            }

        } catch (Exception e) {
            System.out.println();
        }

        return null;
    }



}
