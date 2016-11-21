<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.nc.shpakovskaya.beans.Hospital" %>
<%@ page import="by.nc.shpakovskaya.dao.hospital.HospitalDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Valeria
  Date: 21.11.2016
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация департамента</title>
</head>
<body>
<%
    List<Hospital> hospitalsList = new HospitalDAO().get();
    request.setAttribute("hospitals", hospitalsList);
%>
<h3>Выберите больницу для регистрации</h3>
<hr>
<table border="5" width="100%" cellpadding="5">
    <tr>
        <th> Чек </th>
        <th> id </th>
        <th> Название </th>
    </tr>
    <c:forEach items="${hospitals}" var="hospital" varStatus="status">
        <tr>
            <th>  <input type="checkbox" name="option" value="a"><Br></th>
            <th> ${hospital.getId()}</th>
            <th> ${hospital.getName()}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
