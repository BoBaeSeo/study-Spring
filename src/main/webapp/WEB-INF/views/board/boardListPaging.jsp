<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">boardListPaging.jsp</h1>
	<p class="mb-4"></p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">boardList</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" width="100%" cellspacing="0">
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
								<td><a href="boardView?bno=${list.bno }">${list.btitle }</a>
									[${list.commentCnt }]</td>
								<td><div class="dropdown no-arrow mb-4">
                                        <a class="dropdown-toggle" href="#" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            ${list.bwriter }
                                        </a>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton" style="">
                                            <a class="dropdown-item" href="memberView?mid=${list.bwriter }">회원정보</a>
                                            <a class="dropdown-item" href="boardListMember?bwriter=${list.bwriter }">게시글 보기</a>
                                        </div>
                                    </div></td>
								<td>${list.bdate }</td>
								<td>${list.bhit }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="row">
				<div class="col-sm-12 col-md-5">
					<div class="dataTables_info" id="dataTable_info" role="status"
						aria-live="polite">
						<a href="boardWriteFileForm"
							class="btn btn-primary btn-icon-split"> <span
							class="icon text-white-50"> <i class="fas fa-flag"></i>
						</span> <span class="text">글쓰기</span>
						</a>
					</div>
				</div>

				<div class="col-sm-12 col-md-7">
					<div class="dataTables_paginate paging_simple_numbers"
						id="dataTable_paginate" style="float:right">
						<ul class="pagination">
						<c:choose>
							<c:when test="${pageDTO.page<=1 }">
								<li class="paginate_button page-item previous disabled" id="dataTable_previous">
									<a href="#" class="page-link">이전</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="paginate_button page-item previous" id="dataTable_previous">
									<a href="boardListPaging?page=${pageDTO.page-1 }" class="page-link">이전</a>
								</li>
							</c:otherwise>
						</c:choose>
						<c:forEach begin="${pageDTO.startpage }" end="${pageDTO.endpage }" step="1" var="pageNum">
							<c:choose>
								<c:when test="${pageNum == pageDTO.page }">
									<li class="paginate_button page-item active">
										<a href="#" class="page-link">${pageNum }</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="paginate_button page-item">
										<a href="boardListPaging?page=${pageNum }" class="page-link">${pageNum }</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
							<c:choose>
								<c:when test="${pageDTO.page < pageDTO.maxpage}">
									<li class="paginate_button page-item next" id="dataTable_next">
										<a href="boardListPaging?page=${pageDTO.page+1 }" class="page-link">다음</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="paginate_button page-item next disabled" id="dataTable_next">
										<a href="#" class="page-link">다음</a>
									</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</div>

									

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
	var modalBno = '${modalBno}';
	var deleteCheck = '${deleteCheck}';
	modalProcess(modalBno, deleteCheck);

</script>
<%@ include file="../includes/footer.jsp"%>
