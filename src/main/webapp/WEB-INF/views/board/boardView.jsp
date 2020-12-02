<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardView.jsp</title>
<style>
	table, tr, td{
	border: 1px solid black;
	border-collapse: collapse;
	}
</style>
</head>
<body>
<h2>boardView</h2>
<table>
	<tr>
		<td>글 번호</td>
		<td>${board.bno }</td>
	</tr>
	<tr>
		<td>작성날짜</td>
		<td>${board.bdate }</td>
	</tr>
	<tr>
		<td>글 작성자</td>
		<td>${board.bwriter }</td>
	</tr>
	<tr>
		<td>글 제목</td>
		<td>${board.btitle }</td>
	</tr>
	<tr>
		<td>글 내용</td>
		<td>${board.bcontent }</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${board.bhit }</td>
	</tr>
</table>
<button onclick="location.href='boardList'">글 목록</button> <button type="button">글 수정</button> <button type="button">글 삭제</button>
</body>
</html>