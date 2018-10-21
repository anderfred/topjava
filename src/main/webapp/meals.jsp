<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://example.com/functions" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
<table style="width: 50%">
    <tr>
        <th>Название</th>
        <th>Калории</th>
        <th>Дата</th>
    </tr>
    <c:forEach var="item" items="${meal}">
        <c:set var="date" value="${item.dateTime}"/>
        ${item.exceed==true?"<tr style='color:red'>":"<tr style='color:green'>"}
        <td>${item.description}</td>
        <td>${item.calories}</td>
        <td>${f:formatLocalDateTime(date, 'dd.MM.yyyy HH:mm')} </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
