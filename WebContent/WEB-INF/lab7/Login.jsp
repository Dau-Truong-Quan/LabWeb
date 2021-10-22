<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.80.0">
<title>Top navbar example · Bootstrap v5.0</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/navbar-static/">



<!-- Bootstrap core CSS -->
<!-- <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value='/resources/assets/dist/css/login.css' />"
	rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
	.errors {
		color: red;
		font-style: italic;
	}
}
</style>


<!-- Custom styles for this template -->
<!--     <link href="navbar-top.css" rel="stylesheet"> -->

<link href="<c:url value="/resources/assets/dist/css/navbar-top.css"/>"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<script src="https://www.recaptcha.net/recaptcha/api.js" async defer></script>


</head>
<body>


	<main class="container">
		<form:form method="POST" action="validate2.htm" commandName="user">
			<div
				class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
				<div class="card card0 border-0">
					<div class="row d-flex">
						<div class="col-lg-6">
							<div class="card1 pb-5">
								<div class="row">
									<img src="https://i.imgur.com/CXQmsmF.png" class="logo">
								</div>
								<div
									class="row px-3 justify-content-center mt-4 mb-5 border-line">
									<img src="https://i.imgur.com/uNGdWHi.png" class="image">
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="card2 card border-0 px-4 py-5">
								<!-- 	<a href="?language=en">English</a>|<a href="?language=vi">Vietnamese</a> -->
								<div class="row mb-4 px-3">
									<h6 class="mb-0 mr-4 mt-2">
										<%-- <s:message code="login.title" /> --%>
									</h6>
									<div class="facebook text-center mr-3">
										<div class="fa fa-facebook"></div>
									</div>
									<div class="twitter text-center mr-3">
										<div class="fa fa-twitter"></div>
									</div>
									<div class="linkedin text-center mr-3">
										<div class="fa fa-linkedin"></div>
									</div>
								</div>
								<div class="row px-3 mb-4">
									<div class="line"></div>
									<small class="or text-center">Or</small>
									<div class="line"></div>
								</div>
								<div class="row px-3">
									<label class="mb-1">
										<h6 class="mb-0 text-sm">
											Tên đăng nhập:
											<%--  <s:message code="login.EmailAddress.title"/> --%>
										</h6>



									</label>
									<%--  <s:message code="login.EmailAddress.placeholder" var="placeholderEmail"/> --%>
									<form:input path="username" type="text"
										placeholder="Vui lòng nhập tên đăng nhập" />
									<label class="mb-1">
										<h6 class="mb-0 text-sm">
											<form:errors path="username" cssClass="errors" />
										</h6>
									</label>
								</div>
								<div class="row px-3">
									<label class="mb-1">
										<h6 class="mb-0 text-sm">
											Mật khẩu:
											<%-- <s:message code="login.Password.title" /> --%>
										</h6>

									</label>
									<%-- <s:message code="login.Password.placeholder" var="placeholderPassword"/> --%>
									<form:input path="password" type="password"
										placeholder="Vui lòng nhập mật khẩu" />
									<label class="mb-1">
										<h6 class="mb-0 text-sm">

											<form:errors path="password" cssClass="errors" />
										</h6>
									</label>
								</div>
								<div class="row px-3 mb-4">
									<div
										class="custom-control custom-checkbox custom-control-inline">
										<input id="chk1" type="checkbox" name="chk"
											class="custom-control-input"> <label for="chk1"
											class="custom-control-label text-sm">Remember me</label>
									</div>
									<a href="#" class="ml-auto mb-0 text-sm">Forgot Password?</a>
								</div>

								
								<div class="row mb-3 px-3">
									<button type="submit" class="btn btn-blue text-center">
										<%-- <s:message code="login.Button.title" /> --%>
										Đăng nhập
									</button>
								</div>
								<div class="row mb-4 px-3">
									<small class="font-weight-bold">Don't have an account?
										<a class="text-danger ">Register</a>
									</small>
								</div>
							</div>
						</div>
					</div>
					<div class="bg-blue py-4">
						<div class="row px-3">
							<small class="ml-4 ml-sm-5 mb-2">Copyright &copy; 2019.
								All rights reserved.</small>
							<div class="social-contact ml-4 ml-sm-auto">
								<span class="fa fa-facebook mr-4 text-sm"></span> <span
									class="fa fa-google-plus mr-4 text-sm"></span> <span
									class="fa fa-linkedin mr-4 text-sm"></span> <span
									class="fa fa-twitter mr-4 mr-sm-5 text-sm"></span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</main>



	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


</body>
</html>