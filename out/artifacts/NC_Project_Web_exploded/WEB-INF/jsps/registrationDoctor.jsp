<%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 24.11.2016
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns:jsp="http://java.sun.com/JSP/Page">
<head>
    <link href="../../assets/css/style.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        a {
            text-decoration: none;
            list-style-type: none;
        }
        #wrapper {
            width: 500px;
            left: 33%;
            margin-bottom: 100px;
        }
        .login-form {
            width: 500px;
            left: 33%;
            margin-bottom: 100px;

        }
        .login-form .content .input {
            width: 400px;
        }
    </style>
    <script type="text/javascript">
        function validate()
        {
            var name = document.getElementById("name");
            var surname = document.getElementById("surname");
            var issue = document.getElementById("issue");
            var education = document.getElementById("education");
            var email = document.getElementById("email");
            var login = document.getElementById("login");
            var password1 = document.getElementById("password1");
            var password2 = document.getElementById("password2");
            var valid = false;
            if(name.value.length==0  ||
                    surname.value.length==0 ||
                    issue.value.length==0 ||
                    education.value.length==0 ||
                    email.value.length==0 ||
                    login.value.length==0 ||
                    password1.value.length==0 ||
                    password2.value.length==0 )
            {
                alert("Заполните все поля");
                valid = false;
            }else{
                if(password1.value!=password2.value) {
                    alert("Пароли должны совпадать");
                    valid = false;
                }
                else valid=true;
            }
            return valid;
        };

    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Регистрация</title>
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

    <form name="login-form" class="login-form" action="/controller?command=submit_doctor" method="post" onsubmit="return validate();">

        <div class="header">
            <h1>Регистрация</h1>
            <span>Введите ваши регистрационные данные</span>
        </div>

        <div class="content" align="center">
            <p align="left">Имя</p>
            <input name="name" type="text" class="input username" value="Имя" id="name" onfocus="this.value=''"/>
            <%--<p><style font size="5" color="red" face="Arial"/>Фамилия</p>--%>
            <p align="left">Фамилия</p>
            <input name="surname" type="text" class="input username" value="Фамилия" id="surname" onfocus="this.value=''"/>
            <p align="left">Страховка</p>
            <input name="issue" type="text" class="input username" value="Страховка" id="issue" onfocus="this.value=''"/>
            <p align="left">Образование</p>
            <input name="education" type="text" class="input username" value="Образование" id="education" onfocus="this.value=''"/>
            <p align="left">Логин</p>
            <input name="login" type="text" class="input username" value="Логин" id="login" onfocus="this.value=''"/>
            <p align="left">Почта</p>
            <input name="email" type="text" class="input username" value="Email" id="email" onfocus="this.value=''"/>
            <p align="left">Пароль</p>
            <input name="password1" type="password" class="input password" value="Пароль" id="password1" onfocus="this.value=''"/>
            <p align="left">Повторите пароль</p>
            <input name="password2" type="password" class="input password" value="Пароль" id="password2" onfocus="this.value=''"/>

        </div>

        <div class="footer">
            <input type="submit" name="submit" value="ЗАРЕГЕСТРИРОВАТЬСЯ" class="button" />

            <a href = "/controller?command=choose_registration"  class="register" >
                Назад
            </a>

        </div>

    </form>

</div>
<div class="gradient"></div>

</body>
</html>