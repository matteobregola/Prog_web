package com.example.calculatorwithsessions;

import javax.servlet.annotation.WebServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "endSession", value = "/endSession")
public class endSession extends Calculator{
    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getValueFromSession(request,"name");
        if (name == null)
            dealWithInvalidSession(request, response);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("./header.html").include(request, response);
            out.println("<b>Good, " + name + "! See you soon!!!</b><br><br>");
            out.println("Close session?<br>");
            print_end_session_form(out, response);
            request.getRequestDispatcher("./footer.html").include(request, response);
        }
    }
}
