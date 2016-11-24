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
        table{
            width: auto;
            height: auto;
            border: 1px solid black;
        }
        td {
            padding: 5px 10px 5px 5px;
            border: 1px solid black;
        }

        th {
            padding: 10px;
            border: 1px solid black;
        }

        caption {
            margin-bottom: 10px;
            font-size: 18px;
        }
        hr {
            border: none; /* Убираем границу */
            background-color: #EEEEEE; /* Цвет линии */
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
    <% String login = request.getSession().getAttribute("login").toString(); %>
    <li><a class="active" href="/controller?command=personal"><%=login%></a></li>
    <li><a class="active" href="/controller?command=main">Главная</a></li>
    <li><a href="/controller?command=logout">Выйти</a></li>
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
    <h3>Пользователи</h3>
    <br/>
    <table border="5" width="100%" cellpadding="5">
        <tr>
            <th> Чек </th>
            <th> Id </th>
            <th> Имя </th>
            <th> Фамилия </th>
            <th> Почта </th>
            <th> Логин </th>
            <th> Пароль </th>
        </tr>
        <%
            List<Client> clientsList = new ClientDAO().get();
            request.setAttribute("clients", clientsList);
        %>
        <c:forEach items="${clients}" var="client" varStatus="status">
            <tr>
                <th>  <input type="checkbox" name="option" value="a"><Br></th>
                <th> ${client.getId()}</th>
                <th> ${client.getName()}</th>
                <th> ${client.getSurname()}</th>
                <th> ${client.getEmail()}</th>
                <th> ${client.getLogin()}</th>
                <th> ${client.getPassword()}</th>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="gradient"></div>
</body>
</html>