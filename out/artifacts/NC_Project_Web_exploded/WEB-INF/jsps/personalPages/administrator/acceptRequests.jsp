<%@ page import="by.nc.shpakovskaya.beans.roles.users.Doctor" %>
<%@ page import="by.nc.shpakovskaya.beans.roles.users.client.Client" %>
<%@ page import="by.nc.shpakovskaya.dao.client.ClientDAO" %>
<%@ page import="by.nc.shpakovskaya.dao.stuff.DoctorDAO" %>
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
            border: 1px solid #2c4557;
        }
        td {
            padding: 5px 10px 5px 5px;
            border: 1px solid #2c4557;
        }

        th {
            padding: 10px;
            border: 1px solid #2c4557;
        }
        #wrapper {
            margin-bottom: 100px;
            margin-top: -250px;
            width: 900px;
            left: 30%;
        }
        .login-form {
            margin-bottom: 100px;

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
    </style>

    <script type="text/javascript">
        function validateUser()
        {
            var clientId = document.getElementById("userId");
            var valid = false;
            if(clientId.value.length==0)
            {
                alert("Заполните все поля");
                valid = false;
            }else{
                valid=true;
            }
            return valid;
        };

        function validateDoctor()
        {
            var doctorId = document.getElementById("doctorId");
            var valid = false;
            if(doctorId.value.length==0)
            {
                alert("Заполните все поля");
                valid = false;
            }else{
                valid=true;
            }
            return valid;
        };

    </script>

    <script>
        var arr = [];
        function myFunctionUser(id) {
            window.x = document.getElementById(id.toString()).checked;
            if (x){
                arr.push(id);
                document.getElementById("answer").innerHTML += id;
            }
            else{
                for (var j=0; j<arr.length; j++) {
                    if (arr[j] == id) {
                        arr.splice(j, id.length);
                    }
                }
                document.getElementById("answer").innerHTML = "";
                for (var i=0; i<arr.length; i++) {
                    document.getElementById("answer").innerHTML += arr[i];
                }
            }
        }

        var arr2 = [];
        function myFunctionDoctor(id) {
            window.y = document.getElementById(id.toString()).checked;
            if (y){
                arr2.push(id);
                document.getElementById("answer2").innerHTML += id;
            }
            else{
                for (var k=0; k<arr2.length; k++) {
                    if (arr2[k] == id) {
                        arr2.splice(k, id.length);
                    }
                }
                document.getElementById("answer2").innerHTML = "";
                for (var z=0; z<arr2.length; z++) {
                    document.getElementById("answer2").innerHTML += arr2[z];
                }
            }
        }

    </script>

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
            background: url(../../../../login/images/folders.png) ;
            background-size: cover; height: 100% ">

<div align="center" id="wrapper">

    <br/>
    <h2>Личный кабинет</h2>
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
            <th> Доступ </th>
        </tr>
        <%
            List<Client> clientsList = new ClientDAO().get();
            request.setAttribute("clients", clientsList);
        %>
        <c:forEach items="${clients}" var="client" varStatus="status">
            <tr>
                <th>  <input type="checkbox" id="${client.getId()}" onclick="myFunctionUser(id)" value="a"><Br></th>
                <th> ${client.getId()}</th>
                <th> ${client.getName()}</th>
                <th> ${client.getSurname()}</th>
                <th> ${client.getEmail()}</th>
                <th> ${client.getLogin()}</th>
                <th> ${client.getPassword()}</th>
                <th> ${client.getAdmit()}</th>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="/controller?command=x" id="answer" name="clientIdText"></a>
    <br/>

    <form name="login-form" action="/controller?command=request_modified" onsubmit="return validateUser();" class="login-form" method="post">

        <div class="content">
            <br/>
            <p align="center">Id для подтверждения заявки пользователя: </p>
            <br/>
            <input name="userId" id="userId" align="center" type="text" class="input username" value="Введите Id" onfocus="this.value=''" />
            <br/>

        </div>

        <div class="footer">
            <input type="submit" name="RegisterHospital" value="Подтвердить" class="button" />

            <a href = "/controller?command=personal"  class="register">
                Назад
            </a>
        </div>

    </form>

    <h3>Доктора</h3>
    <br/>
    <table border="5" width="100%" cellpadding="5">
        <tr>
            <th> Чек </th>
            <th> Id </th>
            <th> Имя </th>
            <th> Фамилия </th>
            <th> Страховка </th>
            <th> Образование </th>
            <th> Почта </th>
            <th> Логин </th>
            <th> Пароль </th>
            <th> Доступ </th>
        </tr>
        <%
            List<Doctor> doctorsList = new DoctorDAO().get();
            request.setAttribute("doctors", doctorsList);
        %>
        <br/>
        <c:forEach items="${doctors}" var="doctor" varStatus="status">
            <tr>
                <th>  <input type="checkbox" id="${doctor.getId()}" onclick="myFunctionDoctor(id)" value="a"><Br></th>
                <th> ${doctor.getId()}</th>
                <th> ${doctor.getName()}</th>
                <th> ${doctor.getSurname()}</th>
                <th> ${doctor.getIssue()}</th>
                <th> ${doctor.getEducation()}</th>
                <th> ${doctor.getEmail()}</th>
                <th> ${doctor.getLogin()}</th>
                <th> ${doctor.getPassword()}</th>
                <th> ${doctor.getAdmit()}</th>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="/controller?command=x" id="answer2" name="doctorIdText"></a>
    <br/>

    <form name="login-form" action="/controller?command=request_modified" onsubmit="return validateDoctor();" class="login-form" method="post">

        <div class="content">
            <br/>
            <p align="center">Id для подтверждения заявки доктора: </p>
            <br/>
            <input name="doctorId" id="doctorId" align="center" type="text" class="input username" value="Введите Id" onfocus="this.value=''" />
            <br/>

        </div>

        <div class="footer">
            <input type="submit" name="RegisterHospital" value="Подтвердить" class="button" />

            <a href = "/controller?command=personal"  class="register">
                Назад
            </a>
        </div>

    </form>

</div>
</body>
</html>