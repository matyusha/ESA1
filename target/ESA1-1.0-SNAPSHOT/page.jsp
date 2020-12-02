<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>Title</td>
        <td>Price</td>
        <td>Year</td>
        <td>Author</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.title}</td>
            <td>${book.price}</td>
            <td>${book.year}</td>
            <c:forEach items="${book.authors}" var="auth">
                <td>${auth.name} ${auth.surname}</td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>