<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>What time is it?</title>
</head>
<body>
<%
    DateTimeFormatter day = DateTimeFormatter.ofPattern("dd/MM/yyy");
    DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
%>
<p>Hello, I am a jsp script</p>
<p> Today is
    <%= day.format(now) %>
</p>
<p> and time is
    <%= time.format(now) %>
</p>
</body>
</html>
