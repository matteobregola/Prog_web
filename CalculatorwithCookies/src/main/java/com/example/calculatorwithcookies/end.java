package com.example.calculatorwithcookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "end", value = "/end")
public class end extends Calculator {

    @Override
    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getValueFromCookie(request, "name");
        /*
         As explained before, the name is passed as hidden and not only kept
         in the cookie because they can be disabled
         */
        if (name == null) {
            name = getValueFromParameters(request, "name");
        }
        String ds = request.getParameter("ds");
        if (ds.equals("true")) {
            /*
            I have to destroy the cookies: iterate over all the cookies and
            add a cookie with the same name and expiration time=0
             */
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("./header.html").include(request, response);
            out.println("<b>See you next time, " + name + "!!!</b>");
            request.getRequestDispatcher("./footer.html").include(request, response);
        }
    }

}

