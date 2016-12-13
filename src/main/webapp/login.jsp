<%--
  Created by IntelliJ IDEA.
  User: oscarsoto
  Date: 12/13/16
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test='${param.username.equals("admin") && param.password.equals("password")}'>
    <c:redirect url="profile.jsp"/>
</c:if>

<html>
<head>
    <%@include file="partials/head.jsp"%>
    <title>Login</title>

</head>
<body>
    <%@ include file="partials/navbar.jsp" %>

    <div class="container">
        <div class="col-xs-6" id="loginForm">
            <form method="post">
                <div class="form-group">
                    <label for="username">Username: </label>
                    <input type="text" class="form-control" name="username" id="username" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password: </label>
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                </div>

                <button type="submit" class="btn btn-default">Submit</button>
            </form>

        </div>

    </div>




    <%@ include file="partials/footer.jsp" %>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</body>
</html>
