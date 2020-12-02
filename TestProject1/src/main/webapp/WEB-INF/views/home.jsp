<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="test01">test01로 이동</a>
<hr>
<a href="test02?name=서보배&age=24">test02로 이동</a>
<hr>
<form action="test03" method="post">
이름 : <input type="text" name="name"><br>
나이 : <input type="text" name="age"><br>
<input type="submit" value="test03전송">
</form>
<hr>
<form action="test04" method="get">
이름 : <input type="text" name="name"><br>
나이 : <input type="text" name="age"><br>
<input type="submit" value="test04전송">
</form>
<hr>
<form action="test05" method="get">
이름 : <input type="text" name="name"><br>
나이 : <input type="text" name="age"><br>
주소 : <input type="text" name="addr"><br>
<input type="submit" value="test05전송">
</form>
</body>
</html>
