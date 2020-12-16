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
						<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>이메일</th>
							<th></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>전화번호</th>
							<th>이메일</th>
							<th></th>
						</tr>
					</tfoot>
					<tbody>
						<c:forEach var="list" items="${memberList }">
							<tr>
								<c:choose>
									<c:when test="${sessionScope.loginId == 'admin' }">
										<td><a href="memberView?mid=${list.mid }">${list.mid }</a></td>
										<td><a href="memberView?mid=${list.mid }">${list.mname }</a></td>
										<td>${list.mphone }</td>
										<td>${list.memail }</td>									
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${sessionScope.loginId == list.mid }">
												<td><a href="memberView?mid=${list.mid }">${list.mid }</a></td>
												<td><a href="memberView?mid=${list.mid }">${list.mname }</a></td>								
											</c:when>
											<c:otherwise>
												<td>${list.mid }</td>
												<td>${list.mname }</td>
											</c:otherwise>
										</c:choose>
										<td>${list.mphone }</td>
										<td>${list.memail }</td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${sessionScope.loginId == 'admin' }">
										<td><a class="btn btn-primary btn-sm" href="memberDelete?mid=${list.mid }">삭제</a></td>									
									</c:when>
									<c:otherwise>
											<c:choose>
												<c:when test="${sessionScope.loginId == list.mid }">
													<td><a class="btn btn-primary btn-sm" href="memberDelete?mid=${list.mid }">삭제</a></td>							
												</c:when>
												<c:otherwise>
													<td>삭제</td>
												</c:otherwise>
											</c:choose>
									</c:otherwise>
								</c:choose>
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


<%@ include file="../includes/footer.jsp"%>
