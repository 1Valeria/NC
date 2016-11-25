<%@ page import="by.nc.shpakovskaya.beans.Hospital" %>
<%@ page import="by.nc.shpakovskaya.beans.departments.Department" %>
<%@ page import="by.nc.shpakovskaya.dao.hospital.DepartmentDAO" %>
<%@ page import="by.nc.shpakovskaya.dao.hospital.HospitalDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 24.11.2016
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    Integer numbers = 5;
%>

<c:set var="listNumbers" value="<%=numbers %>"/>

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
        table{
            width: auto;
            height: auto;
            border: 1px solid #000372;
        }
        td {
            padding: 5px 10px 5px 5px;
            border: 1px solid #000372;
        }

        th {
            padding: 10px;
            border: 1px solid #000372;
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
    </style>

    <script type="text/javascript">
        function validate()
        {
            var department = document.getElementById("departmentIdRequest");
            var valid = false;
            if(department.value.length==0)
            {
                alert("Заполните поле");
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
    <li><a class="active" href="/controller?command=main">Главная</a></li>
    <li><a href="/controller?command=logout">Выйти</a></li>
    <li><a><%=login%></a></li>
</ul>
<%--     +++++++++++++++   navigation bar   +++++++++++++++++      --%>

</body>

<body style="
            background: url(../../../../login/images/folders.png) ;
            background-size: cover; height: 100% ">

<div align="center" id="wrapper">

    <h2>Личный кабинет</h2>
    <br/>

    <hr/>

    <br/>
    <p align="center">Вы вошли в систему как доктор</p>
    <br/>

    <div align="center">
        <br/>
        <h3 style="color: #2c4557">Доступные больницы для регистрации</h3>
        <br/>

        <%
            List<Hospital> hospitalList = new HospitalDAO().get();
            request.getSession().setAttribute("hospitalsDoctor", hospitalList);
            List<Department> departmentList = new DepartmentDAO().get();
            request.getSession().setAttribute("departmentsDoctor", departmentList);
        %>
        <c:forEach items="${hospitalsDoctor}" var="hospital" varStatus="status">
            <table border="5" width="100%" cellpadding="5" style="color: #2c4557">
                <tr>
                    <th> ${hospital.getId()} </th>
                    <th colspan="2" align="center"> ${hospital.getName()} </th>
                </tr>
                <c:forEach items="${departmentsDoctor}" var="department" varStatus="status">
                    <c:if test="${department.getHospital().getName()==hospital.getName()}">
                        <tr align="left">
                            <th> id ${" "} ${department.getId()} </th>
                            <th>${department.getName()}</th>
                            <th>Глава отделения: ${department.getHeadDoctor()}
                                <br/>
                                Диагнозы: ${department.getDiagnoses()}
                            </th>
                        </tr>
                    </c:if>
                </c:forEach>

            </table>
            <br>
            <br>
        </c:forEach>

        <br/>

        <form name="login-form" action="/controller?command=submit_request_added" onsubmit="return validate();" class="login-form" method="post">

            <div class="content">
                <br/>
                <p align="center">Id департамента для заявки: </p>
                <br/>
                <input name="departmentIdRequest" id="departmentIdRequest" align="center" type="text" class="input username" value="Введите id" onfocus="this.value=''" />

            </div>

            <div class="footer">
                <input type="submit" name="RegisterHospital" value="Отправить" class="button" />

                <a href = "/controller?command=personal"  class="register">
                    Назад
                </a>
            </div>

        </form>

    </div>


</div>

<div class="gradient"></div>
</body>
</html>
