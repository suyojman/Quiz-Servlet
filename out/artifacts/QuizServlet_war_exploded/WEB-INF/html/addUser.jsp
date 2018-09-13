<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/2/2017
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add User</title>
    <meta charset="utf-8">
    <link href="css/style1.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--webfonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
    <!--//webfonts-->
</head>
<body>
<!-----start-main---->
<div class="main">
    <div class="login-form">
        <h1>New User Login</h1>
        <div class="head">
            <img src="images/user.png" alt=""/>
        </div>
        <form method="post" action="/user">
            <input type="hidden" name="page" value="addUser">
            <input type="text" name="name" class="text" placeholder="NAME"> <%--onfocus="this.value = '';"> &lt;%&ndash;onblur="if (this.value == '') {this.value = 'USERNAME';&ndash;%&gt;}">--%>
            <input type="text" name="email" class="text" placeholder="EMAIL"> <%--onfocus="this.value = '';" &lt;%&ndash;onblur="if (this.value == '') {this.value = 'USERNAME';}" >&ndash;%&gt;--%>
            <input type="password" name="password" placeholder="PASSWORD"> <%--onfocus="this.value = '';" &lt;%&ndash;onblur="if (this.value == '') {this.value = 'Password';}">&ndash;%&gt;--%>
            <div class="submit">
                <input type="submit" <%--onclick="myFunction()"--%> value="ADD" >
            </div>
            <p><a href="#">Forgot Password ?</a></p>
        </form>
    </div>
    <!--//End-login-form-->
    <!-----start-copyright---->
    <div class="copy-right">
        <p> &copy; Suyoj Man Tamrakar</p>
    </div>
    <!-----//end-copyright---->
</div>
<!-----//end-main---->

</body>
</html>