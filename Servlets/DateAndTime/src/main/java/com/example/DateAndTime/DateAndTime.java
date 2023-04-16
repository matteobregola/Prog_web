package com.example.DateAndTime;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "DateAndTIme", value = "/DateAndTime")
public class DateAndTime extends HttpServlet {

    public void create_response(HttpServletResponse response)
            throws IOException {

        DateTimeFormatter day = DateTimeFormatter.ofPattern("dd/MM/yyy");
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head><title>What time is it?</title></head>");
            out.println("<body>");
            out.println("<p>Hello, I am a servlet</p>");
            out.println("<p> Today is ");
            out.println(day.format(now));
            out.println("</p>");
            out.println("<p> and time is ");
            out.println(time.format(now));
            out.println("</p>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        create_response(response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        create_response(response);
    }
}