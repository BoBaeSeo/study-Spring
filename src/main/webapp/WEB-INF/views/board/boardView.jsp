<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">boardWriteForm.jsp</h1>
	<p class="mb-4"></p>

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<!-- <div class="col-lg-5 d-none d-lg-block bg-register-image"></div> -->
					<div class="col-lg-7" style="margin:auto">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">글 상세보기 페이지</h1>
							</div>
							<form class="user boardView">
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="btitle" readonly="readonly" value="제목: ${board.btitle}">
								</div>
								<div class="form-group row">
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											name="bno" readonly="readonly" value="${board.bno }번 글">
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											name="bwriter" readonly="readonly"
											value="작성자: ${board.bwriter }">
									</div>
								</div>
								<div class="form-group">
									<div class="card shadow mb-4">
										<div class="card-header py-3">
											<h6 class="m-0 font-weight-bold text-primary">글내용</h6>
										</div>
										<c:if test="${board.bfilename != null }">
										<img src="/resources/fileUpload/${board.bfilename }" style="max-width: 100%">
										</c:if>
										<textarea rows="8" class="card-body form-control"
											name="bcontent" readonly="readonly">${board.bcontent }</textarea>
									</div>
								</div>
								<c:if test="${sessionScope.loginId == board.bwriter }">
								<button type="button" class="btn btn-success"
									onclick="location.href='boardModify?bno=${board.bno}'">글수정</button>
								<button type="button" class="btn btn-danger"
									onclick="location.href='boardDelete?bno=${board.bno}'">글삭제</button>
								</c:if>	
								<button type="button" class="btn btn-info"
									onclick="location.href='boardListPaging'">글목록</button>

							</form>
							<br>
							<!-- 글 목록  -->
							<div id="commentArea">
								<%-- <c:forEach var="list" items="${commentList }">
								<div class="form-group">
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<input type="text" class="form-control form-control-user" readonly="readonly" value="${list.cwriter }">
									</div>
									<textarea rows="2" class="card-body form-control" readonly="readonly">${list.ccontent }</textarea>
								</div>
							</div>
								</c:forEach> --%>
							</div>
							<c:choose>
								<c:when test="${sessionScope.loginId != null }">
									<div class="form-group">
										<div class="card shadow mb-4">
											<div class="card-header py-3">
											<div class="form-group row">
												<img class='btn-circle' style="margin:0 10px;" src='resources/img/${sessionScope.loginId }.jpg' onerror='this.src="resources/img/undraw_profile.svg"'> <input 
												type="text" id="cwriter" class="form-control form-control-user col-sm-6" name="cwriter" readonly="readonly" value="${sessionScope.loginId }">
												</div>
											</div>
											<textarea rows="2" class="card-body form-control"
												id="ccontent" name="ccontent"></textarea>
											<button type="button" class="btn btn-info" id="commentsWriteBtn">댓글달기</button>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<a href="memberLoginForm" class="btn btn-primary" >로그인</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->
<script type="text/javascript">
	var cbno = '${board.bno}';
	var loginId = '${sessionScope.loginId}'
	console.log(cbno);
	writeBoard(cbno, loginId);
</script>





<%@ include file="../includes/footer.jsp"%>
