<%@ page import="by.nc.shpakovskaya.beans.Hospital" %>
<%@ page import="by.nc.shpakovskaya.beans.departments.Department" %>
<%@ page import="by.nc.shpakovskaya.dao.hospital.DepartmentDAO" %>
<%@ page import="by.nc.shpakovskaya.dao.hospital.HospitalDAO" %>
<%@ page import="java.util.List" %>
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

                <div align="center">
                    <br/>
                    <h3 style="color: #2c4557">Больницы</h3>
                    <br/>

                    <%
                        List<Hospital> hospitalList = new HospitalDAO().get();
                        request.getSession().setAttribute("hospitals", hospitalList);
                        List<Department> departmentList = new DepartmentDAO().get();
                        request.getSession().setAttribute("departments", departmentList);
                    %>
                    <c:forEach items="${hospitals}" var="hospital" varStatus="status">
                        <table border="5" width="100%" cellpadding="5" style="color: #2c4557">
                            <tr>
                                <th colspan="2" align="center"> ${hospital.getName()} </th>
                            </tr>
                            <c:forEach items="${departments}" var="department" varStatus="status">
                                <c:if test="${department.getHospital().getName()==hospital.getName()}">
                                    <tr align="left">
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
                </div>



        </div>
    </body>

</html>


