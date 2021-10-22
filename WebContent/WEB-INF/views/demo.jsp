<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <a style="text-decoration: none;color: blue" href="insert.htm">thêm</a>
				
	<table>
		<tr>
			<th >Username</th>
			<th >Password</th>
			<th >Fullname</th>
		</tr>
		<c:forEach var="u" items="${users}">
			<tr>
				<td>${u.username}
				</td>
				<td>${u.password}
				</td>
				<td>${u.fullname}
				</td>
				
				<td > <a style="text-decoration: none;color: red" href="delete/${u.username}.htm">Xóa </a> 
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>