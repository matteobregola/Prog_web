<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>JSP PageOne</title>
</head>
<body>
<h1>Setting the property...</h1>
<jsp:useBean id="myBean1" class="com.example.beanproject.BeanOne" scope="session"/>
<jsp:setProperty name="myBean1" property="surname" value="Damon"/>
<jsp:setProperty name="myBean" property="name" value="Matt"/>
<p><%= myBean1.toString()%></p>
<hr>
<a href="index.html"> Home </a>
</body>
</html>
