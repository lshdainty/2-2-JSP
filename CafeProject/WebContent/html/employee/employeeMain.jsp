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
		<div id="leftArea">
			<c:forEach var ="e" items = "${sessionScope.list}">
				<tr>
					<td>${e.managerId}</td>
					<td>${e.managerName}</td>
				</tr>
			</c:forEach>
		</div>
		<div id="rightUpArea">
			<label for="name">이름</label>
			<input id="name" type="text">
			<br/>
			<label for="passwd">비밀번호</label>
			<input id="passwd" type="password">
		</div>
		<div id="rightDownArea">
			<button id="select">조회</button>
			<button id="add">추가</button>
			<button id="delete">삭제</button>
		</div>
	</body>
</html>