package com.example.calculatorwithsessions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "index", value = "/index")
public class index extends Calculator {
    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Change 1
        String name = getValueFromSession(request, "name");
        // Change 2
        String encoded_url = "";

        if (name != null) {
            encoded_url = response.encodeURL("./input");
            request.getRequestDispatcher(encoded_url).forward(request, response);
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
