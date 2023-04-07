package com.example.calculatorwithcookies;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "index", value = "/index")
public class index extends Calculator {

    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getValueFromCookie(request, "name");
        /*
        two options:
            Cookie present -> go to the input
            Cookie not present -> get the name
         */

        if (name != null) {
            request.getRequestDispatcher("./input").forward(request, response);
        } else {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            try (PrintWriter out = response.getWriter()) {
                request.getRequestDispatcher("./header.html").include(request, response);
                out.println("Hi! <br>");
                print_name_form(out);
                request.getRequestDispatcher("./footer.html").include(request, response);
            }
        }
    }
}
