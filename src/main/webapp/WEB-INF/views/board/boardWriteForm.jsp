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
								<h1 class="h4 text-gray-900 mb-4">새 글 등록 페이지</h1>
							</div>
							<form class="user" action="boardWrite" method="post">
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										id="exampleInputEmail" name="btitle" placeholder="글 제목">
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="exampleFirstName" name="bwriter" placeholder="작성자">
									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											id="exampleLastName" name="bpassword" placeholder="비밀번호">
									</div>
								</div>
								<div class="form-group">
									<div class="card shadow mb-4">
										<div class="card-header py-3">
											<h6 class="m-0 font-weight-bold text-primary">글내용</h6>
										</div>
										<textarea rows="8" class="card-body form-control" name="bcontent"></textarea>
									</div>
								</div>
								<input type="submit" class="btn btn-primary btn-user btn-block" value="글등록">
								<hr>
								
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
