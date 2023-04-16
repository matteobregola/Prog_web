package com.example.calculatorwithcookies;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

@WebServlet(name = "output", value = "/output")
public class output extends Calculator {

    @Override
    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String name = getValueFromCookie(request, "name");

        if (name == null) {
            /*
            Actually the Cookie is already set even if the user is new so this passage could be avoided.
            However, it can happen that the user has the cookies disabled.
             */
            name = getValueFromParameters(request, "name");
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
