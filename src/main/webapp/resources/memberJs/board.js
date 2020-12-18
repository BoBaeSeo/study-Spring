/**
 * 
 */

/*header.jsp*/
// 비로그인 글쓰기 
function writeLoginCheck(path, loginId) {
	$(document).ready(function() {
		$("#boardWriteForm").click(function() {
			if (loginId == '') {
				alert('로그인 후 이용해주세요')
				location.href = path + '/memberLoginForm'
			} else {
				location.href = "boardWriteForm";
			}
		})
		$("#boardWriteFileForm").click(function() {
			if (loginId == '') {
				alert('로그인 후 이용해주세요')
				location.href = path + '/memberLoginForm'
			} else {
				location.href = "boardWriteFileForm";
			}
		})
	})
}
// profile 이미지 가져오기
function getMemberProfileImg(loginId) {
	if (loginId == '') {
		console.log("비로그인 상태");
		return;
	}
	$.ajax({
		type: "post",
		url: "getProfile",
		data: {
			"mid": loginId
		},
		dataType: "text",
		success: function(profileImg) {
			console.log("profileImg:" + profileImg)
			/* 에이젝스가 실행 된 뒤 profile src 속성 바꾸기 */
			$("#profileImg").attr("src", "resources/img/" + profileImg)
		},
		error: function() {
			alert("연결실패");
		}
	})
}

/*board.jsp, boardListPage.jsp*/
// 글 삭제, 등록 모달
function modalProcess(modalBno, deleteCheck) {
	$(document).ready(function() {
		checkModal(modalBno);
		function checkModal(modalBno) {
			if (modalBno === '') {
				return;
			}
			if (parseInt(modalBno) > 0) {
				if (deleteCheck == 'del') {
					$("#exampleModalLabel").text("글 삭제 확인")
					$(".modal-body").text("게시글 " + parseInt(modalBno) + " 번이 삭제되었습니다.")
				} else {
					$("#exampleModalLabel").text("글 등록 확인")
					$(".modal-body").text("게시글 " + parseInt(modalBno) + " 번이 등록되었습니다.")
				}
			}
			$("#bwriteModal").modal("show");
		}
	});
}

/*boardView.jsp*/
// 글작성 ajax
function writeBoard(cbno, loginId) {
	$(document).ready(function() {
		printCommentList(cbno, loginId);
		$("#commentsWriteBtn").click(function() {
			var cwriter = $("#cwriter").val();
			var ccontent = $("#ccontent").val();
			if (cwriter === "") {
				alert("작성자를 입력해주세요")
				$("#cwriter").focus()
			} else if (ccontent === "") {
				alert("글 내용을 입력해주세요")
				$("#ccontent").focus()
			} else {
				console.log(cwriter + "::" + ccontent + "::" + cbno)
				$.ajax({
					type: "post",
					url: "commentWrite",
					data: {
						"cwriter": cwriter,
						"ccontent": ccontent,
						"cbno": cbno
					},
					dataType: "json",
					success: function(result) {
						console.log(result);
						commentList(result, loginId);
						$("#cwriter").val("");
						$("#ccontent").val("");
					},
					error: function() {
						alert("실패");
					}
				})
			}
		})
	})
}
// 댓글 리스트 출력
function commentList(result, loginId) {
	console.log("commentList");
	var output = '';
	console.log(loginId);
	for (var i in result) {
		var cwriter = result[i].cwriter;
		var ccontent = result[i].ccontent;
		var cno = result[i].cno;
		var cbno = result[i].cbno;
		output += "<div class='form-group'>";
		output += "<div class='card shadow mb-4'>";
		output += "<div class='card-header py-3'>";
		output += "<img class='btn-circle' id='profileImg' src='resources/img/" + cwriter + ".jpg' onerror='this.src = " + '"resources/img/undraw_profile.svg"' + "'> "
		output += "<input type='text' class='form-control form-control-user col-sm-4 delComment' readonly='readonly' value='" + cwriter + "'> ";
		if (cwriter == loginId) {
			output += "<button class='btn btn-danger btn-sm' onclick='delComment(" +cno+ ","+cbno+","+"'"+loginId+"'"+ ")'>삭제</button> ";
			output += '<button id="' + cno + '" class="btn btn-info btn-sm" onclick="commentModify(' + cno + ' , ' + "'" + ccontent + "'" +','+cbno+','+"'"+loginId+"'"+ ')">수정</button>';
		}
		output += "</div>";
		output += "<textarea rows='2' class='card-body form-control' readonly='readonly' name='" + ccontent + "'>" + ccontent + "</textarea>";
		output += "</div>";
		output += "</div>";
	}
	$("#commentArea").html(output);
}
// 출력할 댓글 리스트 가져오기
function printCommentList(cbno, loginId) {
	console.log("printCommentList");
	console.log(cbno);
	$.ajax({
		type: "post",
		url: "commentList",
		data: {
			"cbno": cbno
		},
		dataType: "json",
		/* async : false, */
		success: function(result) {
			console.log(result);
			commentList(result, loginId);
		},
		error: function() {
			alert("연결실패");
		}
	});
}
// 댓글 삭제
function delComment(cno, cbno, loginId) {
	console.log("delComment");
	console.log(cno);
	$.ajax({
		type: "post",
		url: "commentDelete",
		data: {
			"cbno": cbno,
			"cno": cno
		},
		dataType: "json",
		success: function(result) {
			console.log(result);
			commentList(result, loginId);
		},
		error: function() {
			alert("삭제 연결실패");
		}
	})
}
// 댓글 수정
function commentModify(cno, ccontent, cbno, loginId) {
	console.log(cno);
	console.log(ccontent);
	if ($("#" + cno).html() == '수정') {
		$("textarea[name='" + ccontent + "']").attr('readonly', false);
		$("#" + cno).html('수정하기')
	} else {
		var newccontent = $("textarea[name='" + ccontent + "']").val();
		console.log(newccontent);
		$.ajax({
			type: "post",
			url: "commentModify",
			data: {
				"cno": cno,
				"ccontent": newccontent,
				"cbno": cbno
			},
			dataType: "json",
			success: function(result) {
				console.log(result);
				commentList(result, loginId);
			},
			error: function() {
				alert("수정 연결실패");
			}
		})
	}
}






