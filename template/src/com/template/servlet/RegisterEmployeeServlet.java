//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.template.servlet;

import com.template.repository.EmployeeRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/Register"})
public class RegisterEmployeeServlet extends HttpServlet {
    private EmployeeRepository emp;

    public RegisterEmployeeServlet() {
       emp = EmployeeRepository.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String name = request.getParameter("n1");
        int age = Integer.parseInt(request.getParameter("a1"));
        emp.addEmployee(name, age);
        int id = emp.getEmployeeId(name, age);
        request.setAttribute("id", id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
