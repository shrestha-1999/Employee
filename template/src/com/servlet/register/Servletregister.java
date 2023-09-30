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
import java.io.PrintWriter;

@WebServlet({"/Register"})
public class Servletregister extends HttpServlet {
    private EmployeeControl emp = EmployeeControl.getInstance();

    public Servletregister() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String name = request.getParameter("n1");
        int age = Integer.parseInt(request.getParameter("a1"));
        this.emp.addEmployee(name, age);
        int id = this.emp.getEmployeeId(name, age);
        request.setAttribute("id", id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
