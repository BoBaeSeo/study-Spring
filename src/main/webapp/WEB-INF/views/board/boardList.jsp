<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">boardList.jsp</h1>
	<p class="mb-4"></p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>글번호</th>
							<th>글제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>글번호</th>
							<th>글제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="list" items="${boardList }">
							<tr>
								<td>${list.bno }</td>
								<td><a href="boardView?bno=${list.bno }">${list.btitle }</a> [${list.commentCnt }]</td>
								<td>${list.bwriter }</td>
								<td>${list.bdate }</td>
								<td>${list.bhit }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<a href="boardWriteFileForm" class="btn btn-primary btn-icon-split"> <span
				class="icon text-white-50"> <i class="fas fa-flag"></i>
			</span> <span class="text">글쓰기</span>
			</a> 
		</div>
	</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<!-- Modal-->
<div class="modal fade" id="bwriteModal" tabindex="-1" role="dialog"
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
	$(document).ready(function() {
		var modalBno = '${modalBno}';
		var deleteCheck = '${deleteCheck}';
		checkModal(modalBno);
		
		function checkModal(modalBno) {
			if (modalBno === '') {
				return;
			}
			if (parseInt(modalBno) > 0) {
				if(deleteCheck == 'del'){
					$("#exampleModalLabel").text("글 삭제 확인")
					$(".modal-body").text("게시글 " + parseInt(modalBno) + " 번이 삭제되었습니다.")
				}else{
					$("#exampleModalLabel").text("글 등록 확인")
					$(".modal-body").text("게시글 " + parseInt(modalBno) + " 번이 등록되었습니다.")
				}
			} 
			
			$("#bwriteModal").modal("show");
		}
	});
</script>
<%@ include file="../includes/footer.jsp"%>
