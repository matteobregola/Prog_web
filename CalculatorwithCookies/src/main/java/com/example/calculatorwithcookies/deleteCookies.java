package com.example.calculatorwithcookies;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deleteCookies", value = "/deleteCookies")
public class deleteCookies extends Calculator {

    @Override
    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getValueFromCookie(request,"name");
        /*
         As explained before, the name is passed as hidden and not only kept
         in the cookie because they can be disabled
         */
        if (name == null) {
            name = getValueFromParameters(request,"name");
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("./header.html").include(request, response);
            out.println("<b>Good, " + name + "! See you soon!!!</b><br><br>");
            out.println("Delete cookies?<br>");
            print_delete_cookies_form(out, name);
            request.getRequestDispatcher("./footer.html").include(request, response);
        }
    }
}
