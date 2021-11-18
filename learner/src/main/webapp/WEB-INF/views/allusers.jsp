<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Users</h2>  
    <table>
        <tr>
            <td>Name</td><td>Password</td><td>Email</td><td></td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td><a href="<c:url value='user/edit-${user.email}-user' />">${user.email}</a></td>
            <td><a href="<c:url value='user/delete-${user.email}-user' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='user/new' />">Add New User</a>
</body>
</html>

