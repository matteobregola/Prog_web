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
    %>

    Termino la sessione, <%= name %>? <br>

    <form action="<%= response.encodeURL("end.jsp") %>" method="post">
        <label> Sì
            <input type="radio" name="ds" value="true">
        </label>
        <label> No
            <input type="radio" name="ds" value="false">
        </label><br><br>
        <input type="submit" value="Invia">
    </form>
</body>
</html>