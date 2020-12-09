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
								<button type="button" class="btn btn-success"
									onclick="location.href='boardModify?bno=${board.bno}'">글수정</button>
								<button type="button" class="btn btn-danger"
									onclick="location.href='boardDelete?bno=${board.bno}'">글삭제</button>	
								<button type="button" class="btn btn-info"
									onclick="location.href='boardList'">글목록</button>

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
							
							
							<div class="form-group">
								<div class="card shadow mb-4">
									<div class="card-header py-3">
										<input type="text" id="cwriter"
											class="form-control form-control-user" name="cwriter"
											placeholder="댓글작성자">
									</div>
									<textarea rows="2" class="card-body form-control" id="ccontent"
										name="ccontent"></textarea>
									<button type="button" class="btn btn-info"
										id="commentsWriteBtn">댓글달기</button>
								</div>
							</div>
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
	$(document).ready(function() {
		printCommentList();
		$("#commentsWriteBtn").click(function() {
			var cwriter = $("#cwriter").val();
			var ccontent = $("#ccontent").val();
			var cbno = '${board.bno}';
			if(cwriter === ""){
				alert("작성자를 입력해주세요")
				$("#cwriter").focus()
			} else if (ccontent === "") {
				alert("글 내용을 입력해주세요")
				$("#ccontent").focus()
			} else {
			console.log(cwriter + "::" + ccontent + "::" + cbno)
			$.ajax({
				type : "post",
				url : "commentWrite",
				data : {
					"cwriter" : cwriter,
					"ccontent" : ccontent,
					"cbno" : cbno
				},
				dataType : "json",
				success : function(result) {
					console.log(result);
					commentList(result);
					$("#cwriter").val("");
					$("#ccontent").val("");
				},
				error : function() {
					alert("실패");
				}
			})
			}
		})
	})
	
	function commentList(result){
		console.log("commentList");
		var output = '';

		for(var i in result){
			var cwriter = result[i].cwriter;
			var ccontent = result[i].ccontent;
			var cno = result[i].cno;
			output += "<div class='form-group'>";
			output += "<div class='card shadow mb-4'>";
			output += "<div class='card-header py-3'>";
			output += "<input type='text' class='form-control form-control-user col-sm-4 delComment' readonly='readonly' value='"+cwriter+"'> ";
			output += "<button class='btn btn-danger btn-sm' onclick='delComment("+cno+")'>삭제</button> ";
			output += '<button id="'+cno+'" class="btn btn-info btn-sm" onclick="commentModify('+cno+' , '+ "'"+ ccontent + "'"+ ')">수정</button>';
			output += "</div>";
			output += "<textarea rows='2' class='card-body form-control' readonly='readonly' name='"+ccontent+"'>"+ccontent+"</textarea>";
			output += "</div>";
			output += "</div>";
		}
		$("#commentArea").html(output);
	}

	function printCommentList(){
		console.log("printCommentList");
		$.ajax({
			type : "post",
			url : "commentList",
			data : {
					"cbno" : '${board.bno}'
			},
			dataType : "json",
			success : function(result){
				console.log(result);
				commentList(result);
			},
			error : function(){
					alert("연결실패");
			}
		});
	}

	function delComment(cno){
		console.log("delComment");
		console.log(cno);
		$.ajax({
			type : "post",
			url : "commentDelete",
			data : {
					"cbno" : '${board.bno}',
					"cno" : cno
			},
			dataType : "json",
			success : function(result){
				console.log(result);
				commentList(result);
			},
			error : function(){
				alert("삭제 연결실패");
		}
		})
	}

	function commentModify(cno, ccontent){
		console.log(cno);
		console.log(ccontent);
		if($("#"+cno).html() == '수정'){
			$("textarea[name='"+ccontent+"']").attr('readonly', false);
			$("#"+cno).html('수정하기')
		} else {
			var newccontent = $("textarea[name='"+ccontent+"']").val();
			console.log(newccontent);
			$.ajax({
				type : "post",
				url : "commentModify",
				data : {
						"cno" : cno,
						"ccontent" : newccontent,
						"cbno" : '${board.bno}'
				},
				dataType : "json",
				success : function(result){
					console.log(result);
					commentList(result);
				},
				error : function(){
					alert("수정 연결실패");
			}
			})
		}
	}
</script>





<%@ include file="../includes/footer.jsp"%>
