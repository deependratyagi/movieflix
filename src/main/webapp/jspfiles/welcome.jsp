<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

<table>
<tr>
<td><input type="button" onclick="location.href='logout'" value="Log out"></input></td>
</tr>
<c:forEach var="movie" items="${movies}">
<tr>
<td width="100%">${movie.list_title}</td>
</tr>
</c:forEach>

</table>

</body>
</html>