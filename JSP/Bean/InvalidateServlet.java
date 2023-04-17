package com.example.beanproject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "InvalidateServlet", value = "/InvalidateServlet")
public class InvalidateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        // false avoids to create a new session if there isn't one
        if(session != null) {
            session.invalidate();
        }
    }
}
