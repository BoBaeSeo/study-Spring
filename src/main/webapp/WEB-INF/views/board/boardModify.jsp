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
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">글 상세보기 페이지</h1>
							</div>
							<form class="user boardView" action="boaardModifyProcess" method="post">
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										 name="btitle" readonly="readonly" value="${board.btitle}">
								</div>
								<div class="form-group row">
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											 name="bno" readonly="readonly" value="${board.bno }">
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											 name="bwriter" readonly="readonly" value="작성자: ${board.bwriter }">
									</div>
								</div>
								<div class="form-group">
									<div class="card shadow mb-4">
										<div class="card-header py-3">
											<h6 class="m-0 font-weight-bold text-primary">글내용</h6>
										</div>
										<textarea rows="8" class="card-body form-control" name="bcontent">${board.bcontent }</textarea>
									</div>
								</div>
								<button  class="btn btn-success" >수정하기</button>
								<button type="button" class="btn btn-success" onclick="location.href='boardDelete?bno=${board.bno}'">글삭제</button>
								<button type="button" class="btn btn-info" onclick="location.href='boardList'">글목록</button>
								
							</form>
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
<%@ include file="../includes/footer.jsp"%>
