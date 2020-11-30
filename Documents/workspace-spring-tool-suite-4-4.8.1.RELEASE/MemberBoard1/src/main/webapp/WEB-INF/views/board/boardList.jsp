<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
<style>
	table, tr, td{
	border: 1px solid black;
	border-collapse: collapse;
	}
</style>
</head>
<body>
<h2>boardList.jsp</h2>
<table>
	<tr>
		<td>글 번호</td>
		<td>작성자</td>
		<td>글 제목</td>
		<td>작성 날짜</td>
		<td>조회수</td>
	</tr>
	<c:forEach var="list" items="${boardList }">
		<tr>
			<td>${list.bno }</td>
			<td>${list.bwriter }</td>
			<td><a href="boardView?bno=${list.bno }">${list.btitle }</a></td>
			<td>${list.bdate }</td>
			<td>${list.bhit }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>