//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.servlet.register;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/GetEmployee"})
public class ServletEmployee extends HttpServlet {
    private EmployeeControl emp = EmployeeControl.getInstance();
    private static final long serialVersionUID = 1L;

    public ServletEmployee() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Emp employee = this.emp.getEmployeeById(id);
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
