<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<%@include file="/WEB-INF/views/include/menu.jsp"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<main class="container  ">

	<%@include file="/WEB-INF/views/include/menudemolesson6.jsp"%>

	<div class="bg-light p-5 rounded">
		${message}
		<form:form class="row g-3" modelAttribute="user"
			action="lab6/user.htm">
			<div class="col-md-4">
				<label for="exampleFormControlInput1" class="form-label">Username</label>
				<form:input path="username" type="text" class="form-control"
					id="exampleFormControlInput1" placeholder="Vui lòng nhập username" />
			</div>
			<div class="col-md-4">
				<label for="exampleFormControlInput1" class="form-label">Password</label>
				<form:input path="password" type="text" class="form-control"
					id="exampleFormControlInput1" placeholder="Vui lòng nhập passsword" />
			</div>
			<div class="col-md-4">
				<label for="exampleFormControlInput1" class="form-label">Fullname</label>
				<form:input path="fullname" type="text" class="form-control"
					id="exampleFormControlInput1" placeholder="Vui lòng nhập fullname" />
			</div>
			<div class="col-12">
				<button name="${btnStatus}" class="btn btn-primary">Save</button>
			</div>
		</form:form>
	</div>

	<div class="bg-light p-5 rounded">

		<!-- Khai báo pagedListHolder với param p -->
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="lab6/user" var="pagedLink">
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
					<th scope="col">Username</th>
					<th scope="col">Password</th>
					<th scope="col">Fullname</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${pagedListHolder.pageList}">
					<%-- <c:forEach var="s" items="${staffs}"> --%>

					<tr>
						<td>${u.username}</td>
						<td>${u.password}</td>
						<td>${u.fullname}</td>
						<%-- <td><a href="lab6/user/${u.username}.htm"><button
									type="button" name="linkEdit" class="btn btn-warning">Chỉnh
									sửa</button> </a></td> --%>
						<td><a href="lab6/user/${u.username}.htm?linkEdit"><img
								width="30" height="30"
								src="<c:url value="/resources/images/edit.jpg"/>"></a></td>
						<%-- <td><a href="lab6/user/${u.username}.htm">
								<button type="button" name="linkDelete" class="btn btn-danger">Xóa</button>
						</a></td> --%>
						<td><a href="lab6/user/${u.username}.htm?linkDelete"><img
								width="30" height="30"
								src="<c:url value="/resources/images/delete.jpg"/>"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />

	</div>

</main>

<%@include file="/WEB-INF/views/include/footer.jsp"%>