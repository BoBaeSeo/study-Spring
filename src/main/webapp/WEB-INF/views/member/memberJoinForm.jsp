<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">MemberJoinForm.jsp</h1>
	<p class="mb-4"></p>

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-7" style="margin:0 auto">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">회원가입 페이지</h1>
							</div>
							<form action="memberJoin" method="post">
								<!-- Form Row -->
								<div class="form-group">
									<label class="small mb-1" for="inputMid">아이디</label><span id="checkId"></span><input id="inputMid" name="mid"
										type="text" class="form-control " placeholder="아이디 입력">
								</div>
								<!-- Form Row -->
								<div class="form-row">
									<!-- Form Group (비밀번호) -->
									<div class="form-group col-md-6">
										<label class="small mb-1" for="inputMpassword">비밀번호</label> <input id="inputMpassword" name="mpassword"
											type="password" class="form-control " placeholder="비밀번호 입력">
									</div>
									<div class="form-group col-md-6">
										<label class="small mb-1" for="checkPw">비밀번호 확인</label> <span id="checkPwResult"></span><input id="checkPw"
											type="password" class="form-control " placeholder="비밀번호 확인">
									</div>
								</div>
								<hr>
								<!-- Form Row -->
								<div class="form-row">
									<!-- Form Group (이름) -->
									<div class="form-group col-md-6">
										<label class="small mb-1" for="inputMname">이름</label> <input id="inputMname" name="mname"
											type="text" class="form-control" placeholder="이름 입력">
									</div>
									<!-- Form Group (전화번호) -->
									<div class="form-group col-md-6">
										<label class="small mb-1" for="inputMphone">전화번호</label> <input id="inputMphone" name="mphone"
											type="text" class="form-control" placeholder="전화번호">
									</div>
								</div>
								<!-- Form Row -->
								<div class="form-row">
									<!-- Form Group (이메일 아이디) -->
									<div class="form-group col-md-4">
										<label class="small mb-1" for="inputMemailId">이메일</label> <input id="inputMemailId" name="emailid"
											type="text" class="form-control" placeholder="이메일 입력">
									</div>
									<div class="form-group col-md-1">
										<label class="small mb-1" for="inputMemailId"></label> 
										<span class="form-control" style="border: none;">@</span>
									</div>
									<!-- Form Group (이메일 도메인) -->
									<div class="form-group col-md-4">
										<label class="small mb-1" for="inputMemailDomain">도메인</label> <input id="inputMemailDomain" name="memaildomain"
											class="form-control" placeholder="도메인 입력">
									</div>
									<div class="form-group col-3">
									<label class="small mb-1" for="inputMemailDomain"></label> 
										<select class="form-control" id="domainSel">
											<option value="">직접입력</option>
											<option value="naver.com">naver.com</option>
											<option value="google.com">google.com</option>
											<option value="daum.net">daum.net</option>
										</select>
									</div>
								</div>
								<div class="form-row">
									<!-- Form Group (생년월일) -->
									<div class="form-group col-md-6">
										<label class="small mb-1" for="inputMid">생년월일</label> <input type="date" name="mbirth"
											class="form-control" placeholder="이름 입력">
									</div>
								</div>
								<hr>
								<div class="form-row">
									<!-- Form Group (우편번호) -->
									<div class="form-group col-md-6">
										<label class="small mb-1" for="sample6_postcode">우편번호</label> <input type="text" name="mpostcode"
											id="sample6_postcode" class="form-control" placeholder="우편번호">
									</div>
									<!-- Form Group (우편번호 찾기) -->
									<div class="form-group col-md-6">
										<label class="small mb-1" for="inputMid">우편번호찾기</label> <input type="button"
											class="form-control btn btn-warning" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
									</div>
								</div>
								<!-- Form Row -->
								<div class="form-row">
									<!-- Form Group (주소) -->
									<div class="form-group col-md-6">
										<label class="small mb-1" for="sample6_address">주소</label> <input type="text" name="maddr"
											id="sample6_address" class="form-control" placeholder="주소">
									</div>
									<!-- Form Group (참고항목) -->
									<div class="form-group col-md-6">
										<label class="small mb-1" for="sample6_extraAddress">참고항목</label> <input id="sample6_extraAddress" name="maddrefer"
											type="text" class="form-control" placeholder="참고항목">
									</div>
								</div>
								<!-- Form Row -->
								<!-- Form Group (상세주소) -->
									<div class="form-group">
									<label class="small mb-1" for="sample6_detailAddress">상세주소</label>
										 <input type="text" class="form-control" name="mdetailAddress" id="sample6_detailAddress" placeholder="상세주소" >
										 
									</div>

							<input type="submit" class="btn btn-primary" value="회원가입">
							</form>
						</div>
						<hr>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- /.container-fluid -->
	<!-- End of Main Content -->
	
<script type="text/javascript">

	$(document).ready(function() {

		$("#domainSel").change(function() {
			var domain = $("#domainSel").val();
			$("#inputMemailDomain").val(domain);
		});

		$("#checkPw").keyup(function() {
			var mpassword = $("#inputMpassword").val();
			var checkPw = $("#checkPw").val();
			if (mpassword == "") {
				alert("비밀번호를 입력해주세요");
				$("#inputMpassword").focus();
			} else {
				if (mpassword == checkPw) {
					$("#checkPwResult").text("비밀번호 일치").css("color", "green");
				} else {
					$("#checkPwResult").text("비밀번호 불일치").css("color", "red");
				}
			}
		})

		$("#inputMid").keyup(function() {
			var checkId = $("#inputMid").val();
			$.ajax({
				type : "post",
				url : "checkMid",
				data : {
					"checkId" : checkId
				},
				dataType : "text",
				success : function(result) {
					console.log(result);
					if (result == "OK") {
						$("#checkId").text("아이디 사용 가능").css("color", "green");
					} else {
						$("#checkId").text("아이디 사용 불가").css("color", "red");
					}
				},
				error : function() {
					console.log("체크 연결 실패")
				}

			});
		});
	});
</script>

	<%@ include file="../includes/footer.jsp"%>