package com.example.beanproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "addZservlet", value = "/addZ")
public class addZ extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("myBean1") == null) {
            session.setAttribute("myBean", new BeanOne());
            // if bean not found create a new one with the default constuctor
        }
        BeanOne aBean = (BeanOne) session.getAttribute("myBean1");
        aBean.setName(aBean.getName() + "z"); // adding a "z" to the name
        request.getRequestDispatcher("jspTwo.jsp").forward(request, response); // forward control to jspTwo
    }
}
