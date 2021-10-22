<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<%@include file="/WEB-INF/views/include/menu.jsp"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<main class="container  ">

	<%@include file="/WEB-INF/views/include/menudemolesson6.jsp"%>
	<div>
		<a href="lab6/staff/report.htm">
			<button type="button" name="report" class="btn btn-warning">Xem report</button>
		</a>
	</div>

	<div class="bg-light p-5 rounded">

		<!-- Khai báo pagedListHolder với param p -->
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="lab6/staff.htm" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>
		<div class="d-flex flex-row justify-content-between">
			<!-- Chức năng search -->
			<div>
				<span id="result1"></span>

				<form class="d-inline-flex">
					<input name="searchInput" id="searchInput"
						class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<!-- 			<input name="searchInput" id="searchInput" class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search" onkeyup="searchValue()"> -->

					<button name="btnSearch" id="searchProduct"
						class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
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
					<th scope="col">Họ và tên</th>
					<th scope="col">Giới tính</th>
					<th scope="col">Phòng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${pagedListHolder.pageList}">
					<%-- <c:forEach var="s" items="${staffs}"> --%>

					<tr>
						<td>${s.id}</td>
						<td>${s.name}</td>
						<td>${s.gender ? 'Nam' : 'Nữ'}</td>
						<td>${s.depart.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />

	</div>

</main>

<%@include file="/WEB-INF/views/include/footer.jsp"%>