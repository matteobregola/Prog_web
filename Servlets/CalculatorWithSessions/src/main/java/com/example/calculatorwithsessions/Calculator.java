package com.example.calculatorwithsessions;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;

public class Calculator extends HttpServlet {


    // Change1 (see readme.md for documentation)
    protected String getValueFromSession(HttpServletRequest request, String attr_name) {
        HttpSession session = request.getSession();
        return (String) session.getAttribute(attr_name);
    }

    // Change2
    protected void dealWithInvalidSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("error.html").forward(request, response);
    }

    // PARAMS :
    protected String getValueFromParameters(HttpServletRequest request, String name) {
        String x = request.getParameter(name);
        return x;
    }

    // FORMS :
    protected void print_name_form(PrintWriter out) {
        out.println("<form action=\"./input\" method = post>");
        out.println("<label for=\"name\">How should i call you?</label><br>");
        out.println("<input type=\"text\" id=\"name\" name=\"name\" required ><br><br>");
        out.println("<input type=\"submit\" value=\"Send\">");
        out.println("</form>");
    }

    protected void print_input_form(PrintWriter out, String name) {
        out.println("<form action=\"./output\" method = post>");
        out.println("<input type=\"hidden\" name=\"name\" value=\"" + name + "\"/>");
        out.println("<input type=\"hidden\" name=\"first_iteration\" value=\"false\"/>");
        out.println("<label for=\"op1\">Operand 1:</label><br>");
        out.println("<input type=\"text\" id=\"op1\" name=\"op1\" required><br><br>");
        out.println("<input type=\"radio\" id=\"add\" name=\"op\" value=\"+\" required>");
        out.println("<label for=\"add\">+</label><br>");
        out.println("<input type=\"radio\" id=\"dif\" name=\"op\" value=\"-\">");
        out.println("<label for=\"dif\">-</label><br>");
        out.println("<input type=\"radio\" id=\"mul\" name=\"op\" value=\"*\">");
        out.println("<label for=\"mul\">*</label><br>");
        out.println("<input type=\"radio\" id=\"div\" name=\"op\" value=\"/\">");
        out.println("<label for=\"div\">/</label><br><br>");
        out.println("<label for=\"op2\">Operand 2:</label><br>");
        out.println("<input type=\"text\" id=\"op2\" name=\"op2\" required><br><br>");
        out.println("<input type=\"submit\" value=\"Invia\">");
        out.println("</form>");
    }

    protected void print_continue_form(PrintWriter out, String name) {
        out.println("<form method = post>");
        out.println("<input type=\"hidden\" name=\"name\" value=\"" + name + "\"/>");
        out.println("<input type=\"hidden\" name=\"first_iteration\" value=\"false\"/>");
        out.println("<input type=\"submit\" formaction=\"./input\" value=\"Yes\">");
        out.println("<input type=\"submit\" formaction=\"./endSession\" value=\"No\">");
        out.println("</form>");
    }

    protected void print_end_session_form(PrintWriter out, HttpServletResponse response) {
        out.println("<form action = \"" + response.encodeURL("./end") + "\" method = post>");
        out.println("<label> Yes <input type = \"radio\" name = \"ds\" value= \"true\" required> </label>");
        out.println("<label> No <input type = \"radio\" name = \"ds\" value= \"false\"> </label><br><br>");
        out.println("<input type=\"submit\" value=\"Send\">");
        out.println("</form>");
    }


    // DATA PROCESSING

    protected String compute_operation(String op1, String op, String op2, String name) throws ParseException, ParseException {
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
                if (n2.intValue() != 0) res = n1.doubleValue() / n2.doubleValue();
                else err = 1;
                break;
            default:
                err = 2;
        }
        switch (err) {
            case 0:
                result = "Great, " + name + "! <br><br> This is the result:<br>" + op1 + " " + op + " " + op2 + "  = " + res + "<br><br>";
                break;
            case 1:
                result = "<b>Attention, " + name + ": Division by zero is not allowed!</b><br><br>";
                break;
            case 2:
                result = "<b>Attention, " + name + ": Operation not supported</b><br><br>";
                break;
        }
        return result;
    }

    protected void process_request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process_request(request, response);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process_request(request, response);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}