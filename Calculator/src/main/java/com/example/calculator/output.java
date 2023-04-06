package com.example.calculator;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(name = "output", value = "/output")
public class output extends CalculatorServlet {

    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("/header.html").include(request, response);

            String op1 = request.getParameter("op1");
            String op = request.getParameter("op");
            String op2 = request.getParameter("op2");
            String name = request.getParameter("name");

            out.println(compute_operation(op1, op, op2, name));
            //method for computing an operation implemented in Calculator Servlet

            out.println("Do you want to execute another operation?<br>");

            print_continue_form(out, name);

            request.getRequestDispatcher("/footer.html").include(request, response);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
