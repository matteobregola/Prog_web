<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>JSP PageTwo</title>
</head>
<body>
    <h1>Gettind the property...</h1>
    <jsp:useBean id="myBean1" class="com.example.beanproject.BeanOne" scope="session"/>
    <jsp:getProperty name="myBean1" property="surname" />
    <jsp:getProperty name="myBean" property="name" />
    <p><%= myBean1.toString()%></p>
    <hr>
    <a href="index.html"> Home </a>
</body>
</html>
