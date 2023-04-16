package com.example.calculatorwithsessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "end", value = "/end")
public class end extends Calculator{
    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = getValueFromSession(request, "name");

        if (name == null) {
            dealWithInvalidSession(request, response);
        }
        HttpSession session = request.getSession();
        String ds = request.getParameter("ds");
        if (ds.equals("true")) {
            session.invalidate();
        }
        else{
            session.setAttribute("first_iteration","true");
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("./header.html").include(request, response);
            out.println("<b>See you next time, " + name + "!!!</b>");
            request.getRequestDispatcher("./footer.html").include(request, response);
        }
    }
}
