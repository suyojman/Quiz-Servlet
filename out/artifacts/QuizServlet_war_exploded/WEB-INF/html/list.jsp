<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10/31/2017
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Question</title>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
    <style>* {
        -moz-box-sizing: border-box;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
    }
    h1{
        color:aqua;
    }
    body {
        background:#353a40;
    }

    table {
        border-collapse: separate;
        background:#fff;
    @include border-radius(5px);
        margin:50px auto;
    @include box-shadow(0px 0px 5px rgba(0,0,0,0.3));
    }

    thead {
    @include border-radius(5px);
    }

    thead th {
        font-family: 'arial', cursive;
        font-size: 16px;
        font-weight: 400;
        color: #000000;
        background-color: aqua;
    @include text-shadow(1 px 1 px 0 px rgba(0, 0, 0, 0.5));
        text-align: left;
        padding: 20px;
    @include background-image(linear-gradient(#646f7f, #4a5564));
        border-top: 1px solid #858d99;
    }

    tbody tr td {
        font-family: 'Open Sans', sans-serif;
        font-weight:400;
        color:#5f6062;
        font-size:13px;
        padding:20px 20px 20px 20px;
        border-bottom:1px solid #e0e0e0;

    }

    tbody tr:nth-child(2n) {
        background:#f0f3f5;
    }

    tbody tr:last-child td {
        border-bottom: none;
    }


    tbody:hover > tr td {
    @include opacity(0.5);

        /* uncomment for blur effect */
        /* color:transparent;
        @include text-shadow(0px 0px 2px rgba(0,0,0,0.8));*/
    }

    tbody:hover > tr:hover td {
    @include text-shadow(none);
        color:#2d2d2d;
    @include opacity(1.0);
    }</style>
</head>
<body>
<h1 align="center">QUESTION:</h1>
<table >
    <thead>
    <tr>
        <th>ID</th>
        <th>Question</th>
        <th>Option 1</th>
        <th>Option 2</th>
        <th>Option 3</th>
        <th>Option 4</th>
        <th>Correct Answer</th>
        <th>Category</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${questions}" var="q">
        <tr>
            <td>${q.id}</td>
            <td>${q.question}</td>
            <td>${q.option1}</td>
            <td>${q.option2}</td>
            <td>${q.option3}</td>
            <td>${q.option4}</td>
            <td>${q.correctAnswer}</td>
            <td>${q.category}</td>
            <td><a href="/question?page=editQuestion&&id=${q.id}" >Edit</a></td>
            <td><a href="/question?page=deleteQuestion&&id=${q.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/question?page=createQuestion">Add question</a>
</body>
</html>
