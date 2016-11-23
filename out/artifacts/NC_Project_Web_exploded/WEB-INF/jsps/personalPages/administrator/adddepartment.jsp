<%@ page import="by.nc.shpakovskaya.beans.Hospital" %>
<%@ page import="by.nc.shpakovskaya.dao.hospital.HospitalDAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 21.11.2016
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <link href="login/css/style.css" rel="stylesheet" type="text/css" />
    <meta charset="UTF-8"/>
    <title>Регистрация департментов</title>
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
    </style>
    <%
        List<Hospital> hospitalsList = new HospitalDAO().get();
        request.setAttribute("hospitals", hospitalsList);
    %>

    <script>
        var arr = [];
        function myFunction(id) {
            window.x = document.getElementById(id.toString()).checked;
            if (x){
                arr.push(id);
                document.getElementById("answer").innerHTML += id;
            }
            else{
                for (var j=0; j<arr.length;j++) {
                    if (arr[j] == id) {
                        arr.splice(j, id.length);
                    }
                }
                document.getElementById("answer").innerHTML = "";
                for (var i=0; i<arr.length;i++) {
                    document.getElementById("answer").innerHTML += arr[i];
                }
            }

        }

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
                background-size:100%" >


            <div align="center">
                <br/>
                <h3>Выберите больницу для регистрации</h3>
                <br/>

                <br/>
                <table border="5" width="100%" cellpadding="5">
                    <tr>
                        <th> Чек </th>
                        <th> id </th>
                        <th> Название </th>
                    </tr>
                    <c:forEach items="${hospitals}" var="hospital" varStatus="status">
                        <tr>
                            <th>  <input type="checkbox" id="${hospital.getId()}" onclick="myFunction(id)"><Br></th>
                            <th> ${hospital.getId()}</th>
                            <th> ${hospital.getName()}</th>
                        </tr>
                    </c:forEach>
                </table>

            </div>

            <a href="/controller?command=add_department" id="answer"/>

            <%--<div id="wrapper">--%>
                <%--<form name="login-form" action="/controller?command=department_add"  class="login-form" method="post">--%>
                    <%--<div class="footer">--%>
                        <%--<input type="submit" id="answer"/>--%>
                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>

    </body>
</html>
