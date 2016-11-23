<%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 23.11.2016
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<%@ page contentType="text/html; charset=utf-8" %>
<head>
    <link href="../../login/css/style.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        a {
            text-decoration: none;
            list-style-type: none;
        }
        #wrapper {
            width: 500px;
            left: 33%;
        }
        .login-form {
            width: 500px;
            left: 33%;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Выбрать форму</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
</head>
<body>

<%--     +++++++++++++++   navigation bar   +++++++++++++++++      --%>
<ul class="topnav" id="myTopnav">
    <li><a class="active" href="/controller?command=main">Главная</a></li>
    <li><a href="/controller?command=enter">Войти</a></li>
</ul>
<%--     +++++++++++++++   navigation bar   +++++++++++++++++      --%>

<div id="wrapper">

    <form name="login-form" class="login-form" action="/controller?command=registration" method="post" >

        <div class="header">
            <h1>Регистрационные формы</h1>
            <span>Выберите подходящую регистрационную форму</span>
        </div>


        <div class="footer">

            <a href = "/controller?command=registration"  class="register" >
                Пользователь
            </a>

            <a href = "/controller?command=registration_doctor"  class="register" >
                Доктор
            </a>

            <a href = "/controller?command=enter"  class="register" >
                Назад
            </a>

        </div>

    </form>

</div>
<div class="gradient"></div>

</body>
</html>