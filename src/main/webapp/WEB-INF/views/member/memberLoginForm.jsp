<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">memberLoginForm.jsp</h1>
	<p class="mb-4"></p>

	<div class="container">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6" style="margin:0 auto">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                    </div>
                                    <form class="user" action="memberLogin" method="post">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user" name="mid" placeholder="아이디를 입력하세요">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" name="mpassword" placeholder="비밀번호를 입력하세요">
                                        </div>
                                        <button class="btn btn-primary btn-user btn-block" type="submit">
                                            Login
                                        </button>
                                        <hr>
                                    </form>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">Forgot Password?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="memberJoinForm">Create an Account!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
		</div>
	</div>

	<!-- /.container-fluid -->
	<!-- End of Main Content -->
	
	<!-- Modal -->
	<div class="modal fade" id="memberJoinModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModallabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModallabel">회원가입메세지</h5>
					<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				</div>
				<div class="modal-body" id="joinMsg"></div>
			<div class="modal-footer">
				<button class="btn btn-primary" type="button" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		var msg = '${msg}';
		checkModal(msg);

		function checkModal(msg){
			if(msg === '')
				return;
			$("#joinMsg").text(msg);
			$("#memberJoinModal").modal("show");
		}
	});

</script>

	<%@ include file="../includes/footer.jsp"%>