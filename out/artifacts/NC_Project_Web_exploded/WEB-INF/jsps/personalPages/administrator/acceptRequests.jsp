<%@ page import="by.nc.shpakovskaya.beans.roles.users.client.Client" %>
<%@ page import="by.nc.shpakovskaya.dao.client.ClientDAO" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 18.11.2016
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="login/css/style.css" rel="stylesheet" type="text/css" />
    <meta charset="UTF-8"/>
    <title>Подтверждение заявок на регистрацию</title>
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

<%--     +++++++++++++++   navigation bar   +++++++++++++++++      --%>
<ul class="topnav" id="myTopnav">
    <li><a class="active" href="/controller?command=main">Главная</a></li>
    <li><a href="/controller?command=login">Выйти</a></li>
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

    <%
        List<Client> clientsList = new ClientDAO().get();
        request.setAttribute("clients", clientsList);
    %>
    <br/>
    Пользователи
    ...
    <c:forEach items="${clients}" var="client" varStatus="status">
        <p>
            <br/>
            ${client.getName()} ${" "} ${client.getSurname()}
        </p>
    </c:forEach>

</div>

<div class="gradient"></div>
</body>
</html>