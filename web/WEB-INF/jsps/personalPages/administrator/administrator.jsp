<%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 18.11.2016
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="login/css/style.css" rel="stylesheet" type="text/css" />
    <meta charset="UTF-8"/>
    <title>Личный кабинет</title>
    <style>
        hr {
            border: none; /* Убираем границу */
            background-color: #EEEEEE; /* Цвет линии */
            color: #EEEEEE; /* Цвет линии для IE6-7 */
            height: 2px; /* Толщина линии */
        }
        .gradient{
            width: 0px;
            height: 0px;
        }
    </style>
</head>

<body>
<% String login = request.getParameter("login"); %>
<%--     +++++++++++++++   navigation bar   +++++++++++++++++      --%>
<ul class="topnav" id="myTopnav">
    <li><a class="active" href="/controller?command=main">Главная</a></li>
    <li><a href="/controller?command=login">Выйти</a></li>
    <li><a><%=login%></a></li>
</ul>
<%--     +++++++++++++++   navigation bar   +++++++++++++++++      --%>

</body>

<body style="
            background: url(../../../../login/images/folders.png) no-repeat top center;
            background-size:100%">

<div align="center">

    <br/>
    <h3>Личный кабинет</h3>
    <br/>

    <hr/>

    <br/>
    <p align="center">Вы вошли в систему как администратор</p>
    <br/>

    <a href="/controller?command=accept_requests">
        Подтвердить регистрационные запросы
    </a>
    <br/>
    <br/>
    <a href="/controller?command=add_hospital">
        Зарегестрировать новую больницу
    </a>
    <br/>
    <br/>
    <a href="/controller?command=add_department">
        Зарегестрировать на больницу отделение
    </a>

</div>

<div class="gradient"></div>
</body>
</html>
