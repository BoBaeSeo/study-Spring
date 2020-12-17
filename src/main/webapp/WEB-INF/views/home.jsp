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

<!-- Modal-->
<div class="modal fade" id="memDeleteModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"></h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button class="btn btn-primary" type="button" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(
			function() {
				var delMember = '${delMember}';
				CheckModal(delMember);

				function CheckModal(delMember) {
					if (delMember === '') {
						return;
					}
					$("#exampleModalLabel").text("회원 삭제 확인")
					$(".modal-body").text(delMember)
					$("#bwriteModal").modal("show");
				}
			});
</script>
<%@ include file="includes/footer.jsp"%>
