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

    <b>Alla prossima, <%= name %>!!!</b>

    <%
        String ds = request.getParameter("ds");
        if (ds.equals("true")) {
            session.invalidate();
        }
        else {
            session.setAttribute("first_iteration", true);
        }
    %>
</body>
</html>
