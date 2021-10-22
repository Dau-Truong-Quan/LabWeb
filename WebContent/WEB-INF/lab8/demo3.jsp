<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="/WEB-INF/views/include/header.jsp"%>

<style>
.main_div {
	width: 900px;
	text-align: center;
	margin: 0;
	padding: 5px;
	border: 1px dotted orangered;
	border-radius: 5px;
	display: inline-block;
}

img {
	width: 220px;
	height: 200px;
}

.iframe-nav {
	F height: 100%;
	width: 200px;
	position: fixed;
	top: 0;
	left: 0;
	z-index: 1;
}

@
keyframes leftTo { 0%{
	opacity: 0;
	transform: translate(400%, 0);
}

100


















%
{
opacity


















:


















1
















;
transform


















:


















translate
















(


















0
,
0


















)
















;
}
}
.div-animation {
	animation-name: leftTo;
	animation-duration: 1s;
	animation-fill-mode: both;
}

.firstDiv {
	animation-delay: 0.5s;
	display: inline-block;
	margin: 0 10px 0 0;
}

.secondDiv {
	animation-delay: 1s;
	display: inline-block;
	margin: 0 10px 0 0;
}

.thirdDiv {
	animation-delay: 1.5s;
	display: inline-block;
	margin: 0 10px 0 0;
}
</style>

<%@include file="/WEB-INF/views/include/menu.jsp"%>

<main class="container  ">
	<div class="row justify-content-md-center">

		<%-- 	<%@include file="/WEB-INF/views/include/menudemo.jsp"%> --%>

		<!-- <div class="d-flex justify-content-center mt-4">
		
		
	</div> -->

		<div class="card text-center ">
			<form:form action="lab8/sendmail.htm" modelAttribute="mailObject"
				method="POST" enctype="multipart/form-data">
				<c:if test=" ${not empty masseage}">
					<div class="row mb-3" style="border: 1px">${masseage}</div>
				</c:if>
				<div class="row mb-3" style="border: 1px">${masseage}</div>
				<div class="row mb-3">
					<div class="col-sm-2" align="right">
						<label for="exampleInputEmail1" class="col-form-label">Name:
						</label>
					</div>

					<div class="col-sm-10">
						<form:input id="exampleInputEmail1" type="text" path="sender"
							cssClass="form-control" placeholder="Nhập tên người gửi"
							aria-describedby="emailHelp" />
					</div>

				</div>
				<div class="row mb-3">
					<div class="col-sm-2" align="right">
						<label for="exampleInputEmail2" class="col-form-label">Recepient
							Mail:</label>
					</div>

					<div class="col-sm-10">
						<form:input type="email" path="mailRecepient"
							id="exampleInputEmail2" placeholder="Nhập email người nhận"
							cssClass="form-control" aria-describedby="emailHelp" />
					</div>


				</div>
				<div class="row mb-3">
					<div class="col-sm-2" align="right">
						<label for="exampleInputEmail3" class="col-form-label">
							Subject: </label>
					</div>

					<div class="col-sm-10">
						<form:input path="subject" id="exampleInputEmail3" type="text"
							cssClass="form-control" placeholder="Nhập chủ đề của mail"
							aria-describedby="emailHelp" />
					</div>

				</div>
				<div class="row mb-3">
					<div class="col-sm-2" align="right">
						<label for="exampleInputEmail1" class="col-form-label">
							Message: </label>
					</div>

					<div class="col-sm-10">
						<form:textarea path="messagebody" cssClass="form-control"
							placeholder="Nhập nội dung mail"></form:textarea>
					</div>


				</div>
				<div class="row mb-3" input-group>
					<div class="col-sm-2" align="right">
						<label class="col-form-label" for="inputGroupFile02">Upload</label>
					</div>

					<div class="col-sm-10">
						<input type="file" name="attachFile"
							placeholder="Upload attach file" class="form-control"
							accept=".jpg,.gif,.png,.pdf" />
					</div>


				</div>
				<div class="row md-3">
					<div class="col-sm-2"></div>
					<div class="col-sm-10" align="left">
						<button type="submit" class="btn btn-primary">Send</button>
					</div>
				</div>

			</form:form>





		</div>


	</div>




</main>
<%@include file="/WEB-INF/views/include/footer.jsp"%>



