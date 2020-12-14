<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">home.jsp</h1>
	<p class="mb-4"></p>
	<c:if test="${sessionScope.loginId != null }">
	<h3>${sessionScope.loginId }님 환영합니다.</h3>
	</c:if>
	<a href="boardList">boardList</a><br>
	<a href="boardListPaging">boardListPaging</a>
</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->
<%@ include file="includes/footer.jsp"%>
