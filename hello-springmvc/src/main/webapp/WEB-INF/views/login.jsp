<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.page.title" /> </title>

<style>
	span {
		color: red;
		font-size: 8px;
		font-family: verdana;
	}

</style>

</head>
<body>
<form:form method="post" action="userlogin" modelAttribute="loginForm">
<table>
	<tr>
		<td> <spring:message code="login.username.label" /> </td>
		<td> <form:input path="username" /></td>
		<td> <span><form:errors path="username"/> </span> </td>
	</tr>
	
	<tr>
		<td> <spring:message code="login.password.label" /> </td>
		<td> <form:password path="password" /></td>
		<td> <span><form:errors path="password"/> </span> </td>
	</tr>
	
	<tr>
		<td> <input type="submit" value="<spring:message code='login.submit.label' />" />
	</tr>

</table>

</form:form>
</body>
</html>