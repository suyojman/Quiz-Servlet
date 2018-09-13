<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/8/2017
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" href="/vendor/bootstrap/css/bootstrap.min.css">
</head>
<body>
<h1 align="center">Your Result</h1>
<table align="center" border="2px solid">
    <tr>
        <th>ID</th>
        <th>User-ID</th>
        <th>Question_ID</th>
        <th>MARKS</th>
        <th>Photo</th>
        <th>Time Taken</th>


    </tr>
    <c:set var="total" value="${0}"/>
    <c:forEach items="${result}" var="q">
        <tr>
            <td>${q.id}</td>
            <td>${q.userId}</td>
            <td>${q.questionId}</td>
            <td>${q.marks}</td>
            <c:set var="total" value="${total+q.marks}"/>
            <td>
                <c:choose>
                    <c:when test="${q.marks==5}">
                        <img src="/images/correct.png" alt="correct" width="25" height="25">
                    </c:when>
                    <c:when test="${q.marks==0}">
                        <img src="/images/wrong.png" alt="wrong" width="25" height="25">
                    </c:when>
                </c:choose>
            </td>
            <td>${q.timeTaken}</td>





        </tr>

    </c:forEach>
    <tr>
        <td colspan="3">Total</td>
        <td colspan="2"><c:out value="${total}"/></td>
    </tr>
    </table>

<br>
<br>

<button><a href="/question?page=category">Play Again</a></button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button><a href="/user?page=home">Dashboard</a></button>
</body>
</html>
