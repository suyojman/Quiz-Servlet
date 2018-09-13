<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10/31/2017
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
</head>
<body>
<h1 align="center">Please enter the question!!</h1>
<div align="center">
    <form  method="post" action="/question">
        <input type="hidden" name="page" value="question">
        Do you want to add question? <br>
        Question : <input type="text" name="question" placeholder="Enter your question"> <br><br>
        Option1 : <input type="text" name="option1" > <br><br>
        Option2 : <input type="text" name="option2" > <br><br>
        Option3 : <input type="text" name="option3" > <br><br>
        Option4 : <input type="text" name="option4" > <br><br>
        Correct Answer : <input type="text" name="correct_answer" > <br><br>
        Category : <input type="text" name="category" ><br><br>
        <button>Add</button>
    </form>
</div>
</body>
</html>
