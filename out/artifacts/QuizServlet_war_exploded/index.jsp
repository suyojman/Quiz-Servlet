<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10/30/2017
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>QUIZ</title>
      <link rel="stylesheet" href="css/style.css">
      <script src="js/index.js">

      </script>
  </head>
  <body>
  <div class="login-page">
      <div class="form">
          <form name="register" class="register-form" method="post" action="/user" >
              <input type="hidden" name="page" value="register">

              <input type="text" name="name" placeholder="name"/>
              <input type="email" name="email" placeholder="email"/>
              <input type="password" name="password" placeholder="password"/>
             <input type="submit" value="Register">
              <p class="message">Already registered? <a href="#">Sign In</a></p>
          </form>
          <form name="login" onsubmit="return validate()" class="login-form" method="post" action="/user">
              <input type="hidden" name="page" value="login">

              <input type="email" name="email" placeholder="email"/>
              <input type="password" name="password" placeholder="password"/>
              <input type="submit" value="Login">
              <p class="message">Not registered? <a href="#">Create an account</a></p>
          </form>
      </div>
  </div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  <script  src="js/index.js"> </script>


  <%--<form method="post" action="/user">
      E-mail : <input type="email" name="email" placeholder="Enter email">
      Password : <input type="password" name="password" placeholder="Enter Password">

      <input type="submit" value="Login">
  </form>--%>

  </body>
</html>
