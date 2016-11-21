<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<%@ page contentType="text/html; charset=utf-8" %>
<head>
    <style type="text/css">
        a {
            text-decoration: none;
            list-style-type: none;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Авторизация</title>
    <link href="../../login/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
</head>
<body>

<%--     +++++++++++++++   navigation bar   +++++++++++++++++      --%>

<ul class="topnav" id="myTopnav">
    <li><a class="active" href="/controller?command=main">Главная</a></li>
    <li><a href="/controller?command=registration">Зарегестрироваться</a></li>
</ul>

<%--     +++++++++++++++   navigation bar   +++++++++++++++++      --%>


<div id="wrapper">
    <div class="user-icon"></div>
    <div class="pass-icon"></div>

    <form name="login-form" class="login-form" action="/controller?command=personal" method="post">

        <div class="header">
            <h1>Авторизация</h1>
            <span>Введите ваши регистрационные данные для входа в ваш личный кабинет. </span>
        </div>

        <div class="content">
            <p>Логин</p>
            <input name="login" type="text" class="input username" value="Логин" onfocus="this.value=''" />
            <p>Пароль</p>
            <input name="password" type="password" class="input password" value="Пароль" onfocus="this.value=''" />
        </div>

        <div class="footer">
            <input type="submit" name="submit" value="ВОЙТИ" class="button" />

            <a href = "/controller?command=registration"  class="register">
                Регистрация
            </a>
        </div>

    </form>

</div>
<div class="gradient"></div>

<script type="text/javascript">
    $(document).ready(function() {
        $(".username").focus(function() {
            $(".user-icon").css("left","-48px");
        });
        $(".username").blur(function() {
            $(".user-icon").css("left","0px");
        });

        $(".password").focus(function() {
            $(".pass-icon").css("left","-48px");
        });
        $(".password").blur(function() {
            $(".pass-icon").css("left","0px");
        });
    });
</script>
</body>
</html>