<%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 21.11.2016
  Time: 17:11
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
        .login-form .content .input {
            width: 240px;
            padding: 15px 15px;
        }
        .login-form .footer .button {
            float: right;
            padding: 5px 15px;
        }
    </style>

    <script type="text/javascript">
        function validate()
        {
            var hospitalName = document.getElementById("newHospitalName");
            var valid = false;
            if(hospitalName.value.length==0)
            {
                alert("Заполните все поля");
                valid = false;
            }else{
                valid=true;
            }
            return valid;
        };

    </script>

</head>

    <body>
    <% String login = request.getSession().getAttribute("login").toString(); %>
        <%--     +++++++++++++++   navigation bar   +++++++++++++++++      --%>
        <ul class="topnav" id="myTopnav">
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
            <h3>Регистрация новой больницы</h3>
            <br/>

            <hr/>

            <br/>
            <br/>
        </div>

        <br/>

        <div id="wrapper">
            <form name="login-form" action="/controller?command=hospital_added" onsubmit="return validate();" class="login-form" method="post">

                <div class="content">
                    <br/>
                    <p align="center">Название новой больницы: </p>
                    <br/>
                    <input name="newHospitalName" id="newHospitalName" align="center" type="text" class="input username" value="Введите название" onfocus="this.value=''" />
                </div>

                <div class="footer">
                    <input type="submit" name="RegisterHospital" value="Зарегестрировать" class="button" />

                    <a href = "/controller?command=personal"  class="register">
                        Назад
                    </a>
                </div>

            </form>
        </div>

    </body>
</html>
