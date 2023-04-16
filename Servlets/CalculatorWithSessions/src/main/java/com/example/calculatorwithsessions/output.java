package com.example.calculatorwithsessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

@WebServlet(name = "output", value = "/output")
public class output extends Calculator{
    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

        String name = getValueFromSession(request, "name");

        if (name == null) {
            /*
                Session expired, cookies disabled or something else.

             */
            dealWithInvalidSession(request,response);
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("./header.html").include(request, response);
            String op1 = request.getParameter("op1");
            String op = request.getParameter("op");
            String op2 = request.getParameter("op2");
            out.println(compute_operation(op1, op, op2, name));
            out.println("Do you want to do another operation?<br>");
            print_continue_form(out, name);
            request.getRequestDispatcher("./footer.html").include(request, response);
        }
    }
}
