<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Photo list</title>
</head>
<body>
<a href="/">Назад</a>
<form action="delete" method="post">
    <input type="submit" value="Delete marked">
    <table border="1">
        <tr>
            <th>Photo</th><th>Photo ID</th><th></th>
        </tr>
        <c:forEach items="${photos}" var="p">
            <tr>
                <td>
                    <img src="photo/${p}" width="100" height="100">
                </td>
                <td>${p}</td>
                <td>
                    <input type="checkbox" name="photos" value="${p}">
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
