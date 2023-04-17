<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true" %>
<html>
<head>
    <title>Piccola calcolatrice jsp</title>
</head>
<body>
      <%
          String name = (String) session.getAttribute("name");
          if (name == null) {
              request.getRequestDispatcher("error.html").forward(request, response);
          }
          String op1 = request.getParameter("op1");
          String op = request.getParameter("op");
          String op2 = request.getParameter("op2");

      %>
      <%= compute_operation(op1, op, op2, name) %>
      Ne facciamo un'altra?<br>
      <form action="<%= response.encodeURL("input.jsp") %>">
          <input type="submit" value="Sì">
      </form>
      <form action="<%= response.encodeURL("end_session.jsp") %>">
          <input type="submit" value="No">
      </form>
</body>
</html>

<%!
    protected String compute_operation(String op1, String op, String op2, String name) throws ParseException {
        Number n1 = null;
        Number n2 = null;
        try {
            n1 = NumberFormat.getInstance().parse(op1);
            n2 = NumberFormat.getInstance().parse(op2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String result = null;
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
                result =  "Ottimo, " + name  + "! <br><br> Ecco il risultato:<br>" +
                        op1 +  " " + op + " "  + op2 + "  = " + res + "<br><br>";
                break;
            case 1:
                result =  "<b>Attenzione, " + name + ": divisione per zero!</b><br><br>";
                break;
        }
        return result;
    }
%>
