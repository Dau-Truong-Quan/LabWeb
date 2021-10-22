<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="form.htm" method="post">
		<input name="from" placeholder="From">
		<input name="to" placeholder="To">
		<input name="subject" placeholder="Subject">
		<textarea name="body" placeholder="Body" rows="3"></textarea>
		<button>Gửi</button>
	</form>
	<div>
		<p>${message}</p>
	</div>
</body>
</html>