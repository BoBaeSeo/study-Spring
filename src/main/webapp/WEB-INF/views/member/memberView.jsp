<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">
	<!-- Page Heading -->
	<p class="mb-4"></p>

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-7" style="margin: 0 auto">
						<div class="p-5">
						<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">memberView.jsp</h1>
							</div>
							<div class="card mb-4">
									<div class="card-header">
										${sessionScope.loginId }님의 회원정보
									</div>
									<!-- Form Row -->
									<div class="card-body">
									<div class="form-row">
										<!-- Form Group (아이디) -->
										<div class="form-group col-md-6">
											<label class="small mb-1" for="inputMid">아이디</label><span
												id="checkId"></span> <input id="inputMid" name="mid"
												type="text" class="form-control " value="${memberDTO.mid }"
												readonly="readonly">
										</div>
										<!-- Form Group (비밀번호) -->
										<div class="form-group col-md-6">
											<label class="small mb-1" for="inputMpassword">비밀번호</label> <input
												id="inputMpassword" name="mpassword" readonly="readonly"
												type="password" class="form-control "
												value="${memberDTO.mpassword }">
										</div>
									</div>
									<hr>
									<!-- Form Row -->
									<div class="form-row">
										<!-- Form Group (이름) -->
										<div class="form-group col-md-6">
											<label class="small mb-1" for="inputMname">이름</label> 
											<input id="inputMname" name="mname" readonly="readonly" type="text"
												class="form-control" value="${memberDTO.mname }">
										</div>
										<!-- Form Group (전화번호) -->
										<div class="form-group col-md-6">
											<label class="small mb-1" for="inputMphone">전화번호</label> <button id="mphoneModifyBtn" class="btn btn-primary btn-sm" 
											onclick="modifyMphone()" >수정</button>
											 <input id="inputMphone" name="mphone" readonly="readonly"
												type="text" class="form-control" value="${memberDTO.mphone }">
											<button class="btn btn-primary btn-sm" id="modifyMphoneOkBtn" style="display: none;" onclick="modifyMphone()">확인</button>
										</div>
									</div>
									<!-- Form Row -->
									<div class="form-row">
										<!-- Form Group (이메일) -->
										<div class="form-group col-md-6">
											<label class="small mb-1" for="inputMemailId">이메일</label> <button class="btn btn-primary btn-sm" id="memailModifyBtn" onclick="modifyMemail()">수정</button>
											<input id="inputMemail" name="email" readonly="readonly"
												type="text" class="form-control" value="${memberDTO.memail }">
											<button class="btn btn-primary btn-sm" id="modifyMemailOkBtn" style="display: none;" onclick="modifyMemail()">확인</button>
										</div>
										<!-- Form Group (생년월일) -->
										<div class="form-group col-md-6">
											<label class="small mb-1" for="inputMid">생년월일</label> 
											<input type="date" name="mbirth" readonly="readonly"
												class="form-control" value="${memberDTO.mbirth }">
										</div>
									</div>
									<!-- Form Row -->
									<!-- Form Group (주소) -->
									<div class="form-group">
										<label class="small mb-1" for="sample6_detailAddress">주소</label>
										<input type="text" class="form-control" name="maddress"
											id="maddress" value="${memberDTO.maddress }" readonly="readonly">
									</div>
									<input type="submit" class="btn btn-primary" value="회원가입">
								</div>
							</div>
						</div>
					</div>
					</div>
		</div>
	</div>

	<!-- /.container-fluid -->
	<!-- End of Main Content -->

	<script type="text/javascript">
		function modifyMphone(){
			if($("#inputMphone").attr('readonly')){
				$("#inputMphone").attr('readonly', false);
				$("#modifyMphoneOkBtn").show();
				$("#mphoneModifyBtn").hide();
			} else {
				var newMphone = $("#inputMphone").val();
				console.log(newMphone);
				$.ajax({
					type : "post",
					url : "modifyMphoneProcess",
					data : {
							"newMphone" : newMphone
					},
					dataType : "text",
					success : function(result){
						$("#inputMphone").val(result);
						$("#inputMphone").attr('readonly', true);
						$("#modifyMphoneOkBtn").hide();
						$("#mphoneModifyBtn").show();
						},
					error : function(){
						console.log("전화번호 수정 연결 실패")
					}
				});
			}
		}
		
		function modifyMemail(){
			if($("#inputMemail").attr('readonly')){
				$("#inputMemail").attr('readonly', false);
				$("#modifyMemailOkBtn").show();
				$("#memailModifyBtn").hide();
			} else {
				var newMemail = $("#inputMemail").val();
				console.log(newMemail);
				$.ajax({
					type : "post",
					url : "modifyMemailProcess",
					data : {
							"newMemail" : newMemail
					},
					dataType : "text",
					success : function(result){
						$("#inputMemail").val(result);
						$("#inputMemail").attr('readonly', true);
						$("#modifyMemailOkBtn").hide();
						$("#memailModifyBtn").show();
						},
					error : function(){
						console.log("이메일 수정 연결 실패")
					}
				});
			}
		}
	</script>

	<%@ include file="../includes/footer.jsp"%>