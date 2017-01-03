<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Viewing All The Ads" />
        </jsp:include>
    </head>
    <body id="adsBody">
        <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container center-block" id="adsContainer">
        <div class="row">
            <div class="col-lg-12">
                <h1 id="title">Welcome to Adlister!!</h1>
            </div>
        </div>

        <div class="row center-block ads">
            <c:forEach var="ad" items="${ads}">
                <div id="ad" class="col-xs-3 col-center">
                    <div class="ad">
                    <h3>${ad.title}</h3>
                    <p>${ad.description}</p>
                    <a href="/ads/show?id=${ad.id}">See More</a>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>

        <jsp:include page="/WEB-INF/partials/footer.jsp" />
    </body>
</html>
