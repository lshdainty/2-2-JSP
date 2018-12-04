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
			<table id="list">
				<tr>
					<th></th>
					<th>직원 코드</th>
					<th>직원 이름</th>
					<th>직원 휴대폰</th>
				</tr>
				<c:forEach var ="e" items ="${sessionScope.elist}">
				<tr>
					<td><input class="check" type="radio" name="check" value="${e.manager_code},${e.manager_name},${e.manager_tel}"></td>
					<td>${e.manager_code}</td>
					<td>${e.manager_name}</td>
					<td>${e.manager_tel}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div id="employee_right">
			<div id="employee_right_top">
				<div id="employee_right_inner">
					<div id="divId"  style="display: none">
						<label for="id">직원코드</label>
						<input id="id" type="text" maxlength="5">
					</div>
					<div id="divName"  style="display: none">
						<label for="name">이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<input id="name" type="text">
					</div>
					<div id="divPasswd" style="display: none">
						<label for="passwd">비밀번호</label>
						<input id="passwd" type="password">
					</div>
					<div id="divTel" style="display: none">
						<label for="tel">전화번호</label>
						<input id="tel" type="text">
					</div>
				</div>
			</div>
			<div id="employee_right_bottom">
				<button id="btnEmployeeCk" class="btn">조회</button>
				<button id="btnEmployeeIs" class="btn">추가</button>
				<button id="btnEmployeeUd" class="btn">수정</button>
				<button id="btnEmployeeDl" class="btn">삭제</button>
			</div>
		</div>
	</body>
</html>