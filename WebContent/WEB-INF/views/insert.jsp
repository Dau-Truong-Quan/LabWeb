<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red;">${message}</h1>
<form action="insert.htm" method="post" modelAttribute="user">
  <label for="username">Username</label>
  <input type="text" name="username"><br><br>
  <label for="password">Password</label>
  <input type="password"  name="password"><br><br>
  <label for="fullname">Fullname</label>
  <input type="text"  name="fullname"><br><br>
  <button>Lưu</button>
</form>

<a href="index.htm">Xem danh sách user</a>
</body>
</html>