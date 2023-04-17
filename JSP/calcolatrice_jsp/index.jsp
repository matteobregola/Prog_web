<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<html>
<head>
    <title>Piccola calcolatrice jsp</title>
</head>
<body>
    <% String name = (String) session.getAttribute("name");
       String encoded_url="";

        if (name != null) {
            encoded_url= response.encodeURL("./input");
            request.getRequestDispatcher(encoded_url).forward(request, response);
        }
        else {
    %>
            Ciao! <br><br>
            <form action = "<%= response.encodeURL("input.jsp") %>" method = post>
                <label for = "name" >Come ti chiami?</label><br>
                <input type = "text" id = "name" name = "name" required><br><br>
                <input type = submit value = "Invia">
            </form>
    <%
        }
    %>
</body>
</html>