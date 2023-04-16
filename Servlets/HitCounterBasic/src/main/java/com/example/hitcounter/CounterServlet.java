package com.example.hitcounter;

import com.example.hitcounter.Counter;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CounterServlet", urlPatterns = {"/CounterServlet"})
public class CounterServlet extends HttpServlet {
    Counter counter = new Counter();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("/fragment1.html").include(request, response);
            counter.increase();
            out.println(counter);
            request.getRequestDispatcher("/fragment2.html").include(request, response);
        }
    }
}