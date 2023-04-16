package com.example.basicservlet;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Basic_Servlet_Test", value = "/Basic_Servlet_Test")
public class Basic_Servlet_Test extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        processRequest(request,response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Servlet ReadPost</title>");
            out.println("</head><body>");
            out.println("<h1>Servlet Basic_Servlet_Test at "+request.getContextPath()+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}