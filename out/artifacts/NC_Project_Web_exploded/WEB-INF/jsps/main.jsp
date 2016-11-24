<%@ page import="by.nc.shpakovskaya.beans.Hospital" %>
<%@ page import="java.util.List" %>
<%@ page import="by.nc.shpakovskaya.dao.hospital.HospitalDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 14.11.2016
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="../../login/css/style.css" rel="stylesheet" type="text/css" />
        <style>

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

        </style>
    </head>

    <body style="background: url(../../login/images/hospital.png) no-repeat top center;">
        <div>

            <%--    Навигационное меню    --%>
            <ul class="topnav">
                <li><a class="active" href="/controller?command=main">Главная</a></li>

                <%--<c:choose>--%>
                    <%--<c:when test="${isLogged == 'true'}">--%>
                        <%--<li><a href="/controller?command=">Личный кабинет</a></li>--%>
                    <%--</c:when>--%>
                <%--</c:choose>--%>
                <li><a href="/controller?command=enter">Войти</a></li>
                <li><a href="/controller?command=choose_registration">Выбрать форму регистрации</a></li>
            </ul>
            <%--    Навигационное меню    --%>

            <%
                List<Hospital> hospitalList = new HospitalDAO().get();
                request.getSession().setAttribute("hospitals", hospitalList);
            %>

                <div align="center">
                    <br/>
                    <h3 style="color: #2c4557">Больницы</h3>
                    <br/>


                    <c:forEach items="${hospitals}" var="hospital" varStatus="status">
                        <table border="5" width="100%" cellpadding="5" style="color: #2c4557">
                            <tr>
                                <th> ${hospital.getName()} </th>
                            </tr>
                        </table>
                        <br>
                        <br>
                    </c:forEach>
                </div>



        </div>
    </body>

</html>


