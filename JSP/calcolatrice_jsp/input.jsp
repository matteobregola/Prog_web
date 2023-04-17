<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true" %>
<html>
<head>
    <title>Piccola calcolatrice jsp</title>
</head>
<body>
    <%
        String name = (String) session.getAttribute("name");
        Boolean first_iteration = (Boolean) session.getAttribute("first_iteration");
        String msg = "";
        if (name == null) {
            name = request.getParameter("name");
            first_iteration = true;
            if (name != null) {
                session.setAttribute("name", name);
                session.setAttribute("first_iteration", false);
                msg = "<b>Piacere di conoscerti, " + name + "!</b><br><br> Facciamo una operazione: <br><br>";
            } else
                request.getRequestDispatcher("error.html").forward(request, response);
        }
        else if (first_iteration)
            msg = "<b>Bentornato, " + name + "!</b><br><br> Facciamo una operazione: <br><br>";
        else
            msg = "Andiamo avanti, " + name + "!<br><br> Inserisci i nuovi dati: <br><br>";
    %>

    <%= msg %>

    <form action="<%= response.encodeURL("output.jsp") %>" method = post>
        <label for="op1">Operando 1:</label><br>
        <input type="text" id="op1" name="op1" required><br><br>
        <input type="radio" id="add" name="op" value="+" required>
        <label for="add">+</label><br>
        <input type="radio" id="dif" name="op" value="-">
        <label for="dif">-</label><br>
        <input type="radio" id="mul" name="op" value="*">
        <label for="mul">*</label><br>
        <input type="radio" id="div" name="op" value="/">
        <label for="div">/</label><br><br>
        <label for="op2">Operando 2:</label><br>
        <input type="text" id="op2" name="op2" required><br><br>
        <input type="submit" value="Invia">
    </form>
</body>
</html>
