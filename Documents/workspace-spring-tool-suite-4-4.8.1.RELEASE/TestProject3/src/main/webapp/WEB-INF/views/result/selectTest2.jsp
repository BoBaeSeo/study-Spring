<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>selectTest2.jsp</title>
</head>
<body>
<h2>${age }���� ���̰� ������ ���</h2>
<c:forEach var="list" items="${dto}">
�̸�: ${list.name }<br>
����: ${list.age }<br>
�ּ�: ${list.addr }<br><hr>
</c:forEach>
</body>
</html>