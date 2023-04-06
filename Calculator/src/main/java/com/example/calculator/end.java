package com.example.calculator;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet(name = "end", value = "/end")
public class end extends CalculatorServlet {

    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            request.getRequestDispatcher("/header.html").include(request,response);
            out.println("<b> Thanks, " + name + "! End of the conversation!!!</b><br><br>");
            request.getRequestDispatcher("/footer.html").include(request,response);
        }
    }

}