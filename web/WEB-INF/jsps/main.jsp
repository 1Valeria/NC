<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 14.11.2016
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="../../login/css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body style="background: url(../../login/images/hospital.png) no-repeat top center;">
        <div>
            <ul class="topnav">
                <li><a class="active" href="/controller?command=main">Главная</a></li>

                <%--<c:choose>--%>
                    <%--<c:when test="${isLogged == 'true'}">--%>
                        <%--<li><a href="/controller?command=">Личный кабинет</a></li>--%>
                    <%--</c:when>--%>
                    <li><a href="/controller?command=enter">Войти</a></li>
                    <li><a href="/controller?command=registration">Зарегестрироваться</a></li>
                <%--</c:choose>--%>

            </ul>

        </div>
    </body>


</html>


