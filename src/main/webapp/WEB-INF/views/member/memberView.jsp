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
						<div class="p-5" style="margin: 0 auto">
						<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">memberView.jsp</h1>
							</div>
							<div class="card mb-4">
									<div class="card-header">
										${memberDTO.mid }님의 회원정보
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
											<label class="small mb-1" for="inputMphone">전화번호</label> 
											<c:if test="${sessionScope.loginId == memberDTO.mid }">
											<button id="mphoneModifyBtn" class="btn btn-primary btn-sm" onclick="modifyMphone()" >수정</button>
											</c:if>
											 <input id="inputMphone" name="mphone" readonly="readonly"
												type="text" class="form-control" value="${memberDTO.mphone }">
											<c:if test="${sessionScope.loginId == memberDTO.mid }">
											<button class="btn btn-primary btn-sm" id="mphoneOkBtn" style="display: none;" onclick="modifyMphone(true)">확인</button>  
											<button class="btn btn-primary btn-sm" id="mphoneCancelBtn" style="display: none;" onclick="modifyMphone(false)">취소</button>
											</c:if>
										</div>
									</div>
									<!-- Form Row -->
									<div class="form-row">
										<!-- Form Group (이메일) -->
										<div class="form-group col-md-6">
											<label class="small mb-1" for="inputMemailId">이메일</label> 
											<c:if test="${sessionScope.loginId == memberDTO.mid }">
											<button class="btn btn-primary btn-sm" id="memailModifyBtn" onclick="modifyMemail()">수정</button>
											</c:if>
											<input id="inputMemail" name="email" readonly="readonly"
												type="email" class="form-control" value="${memberDTO.memail }">
											<c:if test="${sessionScope.loginId == memberDTO.mid }">
											<button class="btn btn-primary btn-sm" id="memailOkBtn" style="display: none;" onclick="modifyMemail(true)">확인</button>
											<button class="btn btn-primary btn-sm" id="memailCancelBtn" style="display: none;" onclick="modifyMemail(false)">취소</button>
											</c:if>
										</div>
										<!-- Form Group (생년월일) -->
										<div class="form-group col-md-6">
											<label class="small mb-1" for="inputMid">생년월일</label> 
											<input type="date" name="mbirth" readonly="readonly"
												class="form-control" value="${memberDTO.mbirth }">
										</div>
									</div>
									<!-- Form Group (주소) -->
									<div class="form-group">
										<label class="small mb-1" for="sample6_detailAddress">주소</label>
										<input type="text" class="form-control" name="maddress"
											id="maddress" value="${memberDTO.maddress }" readonly="readonly">
									</div>
									<input type="button" class="btn btn-primary" onclick="toggleProfile()" value="프로필">
									<form action="updateBprofile" method="post" style="display:none" enctype="multipart/form-data" id="profile">
										<img class="img-profile rounded-circle" src="resources/img/${memberDTO.mprofilename }" width="200px"
										onerror="this.src = 'resources/img/undraw_profile.svg'">
										<input type="hidden" name="mid" value="${memberDTO.mid }">
										<c:if test="${sessionScope.loginId == memberDTO.mid }">
										<input type="file" name="mprofile"><br><br>
										<input type="submit" class="btn btn-primary" value="저장">
										</c:if>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

	<!-- /.container-fluid -->
	<!-- End of Main Content -->

	<script type="text/javascript">

		function modifyMphone(check) {
			if ($("#inputMphone").attr('readonly')) {
				$("#inputMphone").attr('readonly', false);
				$("#mphoneOkBtn").show();
				$("#mphoneCancelBtn").show();
				$("#mphoneModifyBtn").hide();
			} else {
				if (check) {
					var newMphone = $("#inputMphone").val();
					console.log(newMphone);
					$.ajax({
						type : "post",
						url : "modifyMphoneProcess",
						data : {
							"mid" : "${memberDTO.mid}",
							"mphone" : newMphone
						},
						dataType : "text",
						success : function(result) {
							if(result == "OK"){
								alert("전화번호 변경 성공")
							} else {
								alert("전화번호 변경 실패")
								$("#inputMphone").val("${memberDTO.mphone}");
							}
						},
						error : function() {
							console.log("전화번호 수정 연결 실패")
						}
					});
				} else {
					$("#inputMphone").val("${memberDTO.mphone}");
				}
				$("#inputMphone").attr('readonly', true);
				$("#mphoneOkBtn").hide();
				$("#mphoneCancelBtn").hide();
				$("#mphoneModifyBtn").show();
			}
		}

		function modifyMemail(check) {
			if ($("#inputMemail").attr('readonly')) {
				$("#inputMemail").attr('readonly', false);
				$("#memailOkBtn").show();
				$("#memailCancelBtn").show();
				$("#memailModifyBtn").hide();
			} else {
				if (check) {
					var newMemail = $("#inputMemail").val();
					console.log(newMemail);
					$.ajax({
						type : "post",
						url : "modifyMemailProcess",
						data : {
							"mid" : "${memberDTO.mid}",
							"memail" : newMemail
						},
						dataType : "text",
						success : function(result) {
							if(result == "OK"){
								alert("이메일 변경 성공")
							} else {
								alert("이메일 변경 실패")
								$("#inputMemail").val("${memberDTO.memail}");
							}
						},
						error : function() {
							console.log("이메일 수정 연결 실패")
						}
					});
				} else {
					$("#inputMemail").val("${memberDTO.memail}");
				}
				$("#inputMemail").attr('readonly', true);
				$("#memailOkBtn").hide();
				$("#memailCancelBtn").hide();
				$("#memailModifyBtn").show();
			}
		}

		function toggleProfile(){
			$("#profile").toggle();
		}
	</script>

	<%@ include file="../includes/footer.jsp"%>