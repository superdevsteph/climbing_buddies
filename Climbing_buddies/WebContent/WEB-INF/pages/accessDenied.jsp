<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Access Denied page</title>
</head>
<body>
<h2>Sorry, you do not have permission to view this page.</h2>
 
    Dear <strong>${user}</strong>, You are not authorized to access this page
    <a href="<c:url value="/logout" />">Logout</a>

Click <a href="<c:url value="/home" /> ">here</a>
to go back to the Homepage.
</body>
</html>