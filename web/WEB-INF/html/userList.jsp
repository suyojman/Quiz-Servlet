<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/3/2017
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" href="/vendor/bootstrap/css/bootstrap.min.css">
</head>
<body>
<h1 align="center">THIS IS USER LIST!!</h1>
<%--<table align="center" border="2px solid">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
         <th>Edit</th>
        <th>Delete</th>

    </tr>
<c:forEach items="${user}" var="q">
    <tr>
        <td>${q.id}</td>
        <td>${q.name}</td>
        <td>${q.email}</td>
        <td>${q.password}</td>
        <td><a href="/user?page=editUser&&id=${q.id}" >Edit</a></td>
        <td><a href="/user?page=deleteUser&&id=${q.id}">Delete</a></td>



    </tr>
</c:forEach>
    </table>--%>
<table class="table">
    <thead class="thead-default">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${user}" var="q">
    <tr>
        <th scope="row">${q.id}</th>
        <td>${q.name}</td>
        <td>${q.email}</td>
        <td>${q.password}</td>
        <td><a href="/user?page=editUser&&id=${q.id}" >Edit</a></td>
        <td><a href="/user?page=deleteUser&&id=${q.id}">Delete</a></td>
    </tr>
</c:forEach>
    </tbody>
</table>

</body>
</html>
