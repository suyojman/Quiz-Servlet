<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10/30/2017
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>QUIZ ${r.role=='admin'}</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/simple-sidebar.css" rel="stylesheet">
</head>
<body>

<div id="wrapper">

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">

    <c:if test="${r.role=='admin'}">
                   <%-- <c:if test="${r.role=='admin'}">--%>
                <li class="sidebar-brand">
                    <a href="#">ADMIN PANEL</a>
                </li>
                <li>
                    <a href="/question?page=createQuestion">Add question</a>

                </li>
                <li>
                    <a href="/question?page=questionList">Show Question</a>
                </li>
                <li>
                    <a href="/user?page=createUser">Add User</a>
                </li>
                <li>
                    <a href="/user?page=userList">Show User</a>
                </li>
                    <%--</c:if>--%>

    </c:if>

            <li>
                <a href="#">About</a>
            </li>
            <li>
                <a href="/question?page=category">Play Quiz</a>
            </li>
            <li>
                <a href="#">Services</a>
            </li>
            <li>
                <a href="/user?page=logout">Log Out</a>
            </li>
        </ul>
    </div>

<%--    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            &lt;%&ndash;<c:if test="${r.role=='admin'}">&ndash;%&gt;
            <li class="sidebar-brand">
                <a href="#">ADMIN PANEL</a>
            </li>
            <li>
                <a href="/question?page=createQuestion">Add question</a>

            </li>
            <li>
                <a href="/question?page=questionList">Show Question</a>
            </li>
            <li>
                <a href="/user?page=createUser">Add User</a>
            </li>
            <li>
                <a href="/user?page=userList">Show User</a>
            </li>
            &lt;%&ndash;</c:if>&ndash;%&gt;
            <li>
                <a href="#">About</a>
            </li>
            <li>
                <a href="/question?page=playQuiz">Play Quiz</a>
            </li>
            <li>
                <a href="#">Services</a>
            </li>
            <li>
                <a href="#">Contact</a>
            </li>
        </ul>
    </div>--%>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <h1>Welcome ${u.name}</h1>
           <%-- <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller screens, and will appear non-collapsed on larger screens. When toggled using the button below, the menu will appear/disappear. On small screens, the page content will be pushed off canvas.</p>
            <p>Make sure to keep all page content within the <code>#page-content-wrapper</code>.</p>--%>
            <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>
</body>
</html>
