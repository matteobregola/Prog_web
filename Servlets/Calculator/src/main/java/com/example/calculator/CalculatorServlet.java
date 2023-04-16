package com.example.calculator;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CalculatorServlet", value = "/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {


    // Methods for printing forms
    protected void print_input_form(PrintWriter out, String name) {
        out.println("<form action=\"./output\">");
        out.println("<input type=\"hidden\" name=\"name\" value=\"" + name + "\"/>");
        out.println("<input type=\"hidden\" name=\"first_iteration\" value=\"false\"/>");
        out.println("<label for=\"op1\">Operand 1:</label><br>");
        out.println("<input type=\"text\" id=\"op1\" name=\"op1\" required ><br><br>");
        out.println("<input type=\"radio\" id=\"add\" name=\"op\" value=\"+\" required >");
        out.println("<label for=\"add\">+</label><br>");
        out.println("<input type=\"radio\" id=\"dif\" name=\"op\" value=\"-\">");
        out.println("<label for=\"dif\">-</label><br>");
        out.println("<input type=\"radio\" id=\"mul\" name=\"op\" value=\"*\">");
        out.println("<label for=\"mul\">*</label><br>");
        out.println("<input type=\"radio\" id=\"div\" name=\"op\" value=\"/\">");
        out.println("<label for=\"div\">/</label><br><br>");
        out.println("<label for=\"op2\">Operand 2:</label><br>");
        out.println("<input type=\"text\" id=\"op2\" name=\"op2\" required ><br><br>");
        out.println("<input type=\"submit\" value=\"Submit\">");
        out.println("</form>");
    }

    protected void print_continue_form(PrintWriter out, String name) {
        out.println("<form>");
        out.println("<input type=\"hidden\" name=\"name\" value=\"" + name + "\"/>");
        out.println("<input type=\"hidden\" name=\"first_iteration\" value=\"false\"/>");
        out.println("<input type=\"submit\" formaction=\"./input\" value=\"Yes\">");
        out.println("<input type=\"submit\" formaction=\"./end\"value=\"No\">");
        out.println("</form>");
    }

    // Data processing
    protected String compute_operation(String op1, String op, String op2, String name) throws ParseException {
        String result = null;
        Number n1 = NumberFormat.getInstance().parse(op1);
        Number n2 = NumberFormat.getInstance().parse(op2);
        double res = 0;
        int err = 0;
        switch (op) {
            case "+":
                res = n1.doubleValue() + n2.doubleValue();
                break;
            case "-":
                res = n1.doubleValue() - n2.doubleValue();
                break;
            case "*":
                res = n1.doubleValue() * n2.doubleValue();
                break;
            case "/":
                if (n2.intValue() != 0)
                    res = n1.doubleValue() / n2.doubleValue();
                else
                    err = 1;
                break;

        }
        switch (err) {
            case 0:
                result =  "Great, " + name  + "! <br><br> This is the result:<br>" +
                        op1 +  " " + op + " "  + op2 + "  = " + res + "<br><br>";
                break;
            case 1:
                result =  "<b>Attention, " + name + ": division by zero!</b><br><br>";
                break;

        }
        return result;
    }

    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("header.html").include(request,response);
        request.getRequestDispatcher("footer.html").include(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process_request(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        process_request(request, response);
    }

    public void log(String msg) {
        getServletContext().log(getServletName()+ " "+ msg);
    }
    @Override public void destroy() {
        log("destroy executed");
    }
    @Override public void init() {
        log("init executed");
    }

}