<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Show Ad" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Here's the ad!</h1>

    <div class="col-md-6">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
    </div>

</div>
</body>
</html>
