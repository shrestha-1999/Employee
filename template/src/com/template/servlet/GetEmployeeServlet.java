//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.template.servlet;

import com.template.model.Employee;
import com.template.repository.EmployeeRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/GetEmployee"})
public class GetEmployeeServlet extends HttpServlet {
    private EmployeeRepository emp;
    private static final long serialVersionUID = 1L;

    public GetEmployeeServlet() {
        emp = EmployeeRepository.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = emp.getEmployeeById(id);
        if (employee != null) {
            String name = employee.getName();
            int age = employee.getAge();
            request.setAttribute("name", name);
            request.setAttribute("age", age);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employeeDetails.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().println("Employee not found.");
        }

    }
}
