<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>로그인 페이지입니다.</title>
		<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
		<script src="/CafeProject/js/mlogin.js"></script>
	</head>
	<body>
		<div>
			<img src="/CafeProject/images/logo.jpg"/>
		</div>
		<div id="status">
			<ul>
				<li>
					<label for="id">아이디</label>
					<input id="id" name="id" type="text" size="20" autofocus>
					<label for="passwd">비밀번호</label>
					<input id="passwd" name="passwd" type="password" size="20">
					<button id="login">로그인</button>
				</li>
			</ul>
		</div>
	</body>
</html>