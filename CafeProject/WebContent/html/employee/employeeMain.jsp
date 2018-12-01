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
		<div id="employee_left">
			<c:forEach var ="e" items = "${sessionScope.list}">
					직원 코드 : ${e.managerId} , 직원 이름 : ${e.managerName}
					<br/>
			</c:forEach>
		</div>
		<div id="employee_right">
			<label for="id">직원코드</label>
			<input id="id" type="text">
			<br/>
			<label for="name">이름</label>
			<input id="name" type="text">
			<br/>
			<label for="passwd">비밀번호</label>
			<input id="passwd" type="password">
			<br/>
			
			<button id="select">조회</button>
			<button id="add">추가</button>
			<button id="delete">삭제</button>
		</div>
	</body>
</html>