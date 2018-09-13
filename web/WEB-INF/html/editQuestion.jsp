<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/2/2017
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Question</title>
</head>
<body>
<div align="center">
    <form  method="post" action="/question">
        <input type="hidden" name="page" value="editQuestion">

        Do you want to Edit question? <br>
        <input type="hidden" name="ID" value="${q.id}">
        Question : <input type="text" name="question" value="${q.question}"> <br><br>
        Option1 : <input type="text" name="option1" value="${q.option1}" > <br><br>
        Option2 : <input type="text" name="option2" value="${q.option2}" > <br><br>
        Option3 : <input type="text" name="option3" value="${q.option3}"> <br><br>
        Option4 : <input type="text" name="option4" value="${q.option4}"> <br><br>
        Correct Answer : <input type="text" name="correct_answer" value="${q.correctAnswer}"> <br><br>
        Category : <input type="text" name="category" value="${q.category}"><br><br>
        <button>Save</button>
    </form>
</div>
</body>
</html>
