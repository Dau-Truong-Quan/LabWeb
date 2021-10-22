<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<%@include file="/WEB-INF/views/include/menu.jsp"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<main class="container  ">

	<%@include file="/WEB-INF/views/include/menudemolesson6.jsp"%>
	<div>
		<a href="lab6/staff.htm">
			<button type="button" name="report" class="btn btn-warning">Xem
				nhân viên</button>
		</a>
	</div>
	<div class="bg-light p-5 rounded">

		<!-- Khai báo pagedListHolder với param p -->
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="lab6/staff" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>
		<div class="d-flex flex-row justify-content-between">
			<!-- Chức năng phân trang -->
			<div>
				<tg:paging pagedListHolder="${pagedListHolder}"
					pagedLink="${pagedLink}" />
			</div>
		</div>

		<!-- Bảng hiển thị dữ liệu -->
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Mã nhân viên</th>
					<th scope="col">Tổng thành tích</th>
					<th scope="col">Tổng kỷ luật</th>
					<th scope="col">Tổng kết</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${pagedListHolder.pageList}">
					<%-- <c:forEach var="s" items="${staffs}"> --%>

					<tr>
						<td>${s[0]}</td>
						<td>${s[1]}</td>
						<td>${s[2]}</td>
						<td>${s[1] * s[2]}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />

	</div>

</main>

<%@include file="/WEB-INF/views/include/footer.jsp"%>