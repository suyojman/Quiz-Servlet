<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/10/2017
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
<h1 align="center">Please Choose your desired Category!!</h1>

<div>
    <form method="get" action="/question">
        <input type="hidden" name="page" value="playquiz">
        <input type="hidden" name="category" value="Web">
        <input type="submit" value="WEB">
    </form>
    <form method="get" action="/question">
        <input type="hidden" name="page" value="playquiz">
        <input type="hidden" name="category" value="Java">
        <input type="submit" value="JAVA">
    </form>
</div>
</body>
</html>
