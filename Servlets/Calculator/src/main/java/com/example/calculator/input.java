package com.example.calculator;


import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "input", value = "/input")
public class input extends CalculatorServlet {
    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("/header.html").include(request, response);
            // Use the static HTML to avoid code repetition
            String name = request.getParameter("name");
            String first_iteration = request.getParameter("first_iteration");
            // obtain parameters from the url. NB: doesn't work if name lenght=1

            if (first_iteration.equals("true")) {
                out.println("<b>Nice To meet you, " + name + "!</b><br><br>");
                out.println("Let's try an operation: <br><br>");
            }
            else
                out.println("Go on, " + name + "!<br><br> Insert new data:: <br><br>");
            print_input_form(out, name); // method inherited from CalculatorServlet
            request.getRequestDispatcher("/footer.html").include(request, response);
        }

    }
}
