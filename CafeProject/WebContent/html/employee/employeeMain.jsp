<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>직원 페이지입니다.</title>
		<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
		<script src="/CafeProject/js/employee.js"></script>
		<link rel="stylesheet" href="/CafeProject/css/employee.css">
	</head>
	<body>
		<div id="leftArea">직원 페이지입니다.
		</div>
		<div id="rightUpArea">
			<label for="name">이름</label>
			<input id="name" type="text">
			<br/>
			<label for="tel">휴대폰 번호</label>
			<input id="tel" type="text">
		</div>
		<div id="rightDownArea">
			<button id="select">조회</button>
			<button id="add">추가</button>
			<button id="modify">수정</button>
		</div>
	</body>
</html>