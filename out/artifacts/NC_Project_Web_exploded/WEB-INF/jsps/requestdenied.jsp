<%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 25.11.2016
  Time: 4:32
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<%@ page contentType="text/html; charset=utf-8" %>
<head>
    <link href="../../login/css/style.css" rel="stylesheet" type="text/css" />
    <style >
        a {
            text-decoration: none;
            list-style-type: none;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Упс!</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
</head>
<body>

<%--     +++++++++++++++   navigation bar   +++++++++++++++++      --%>
<ul class="topnav" id="myTopnav">
    <li><a class="active" href="/controller?command=main">Главная</a></li>
    <li><a href="/controller?command=enter">Войти</a></li>
    <li><a href="/controller?command=choose_registration">Регистрация</a></li>
</ul>
<%--     +++++++++++++++   navigation bar   +++++++++++++++++      --%>

<div id="wrapper">

    <p align="center"> К сожалению доступ к этой странице Вам закрыт. Подождите пока администратор одобрит вашу заявку.
    </p>

</div>
<div class="gradient"></div>

</body>
</html>