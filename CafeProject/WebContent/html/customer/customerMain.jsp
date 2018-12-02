<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>고객 페이지입니다.</title>
		<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
		<script src="/CafeProject/js/customer.js"></script>
		<link rel="stylesheet" href="/CafeProject/css/customer.css">
	</head>
	<body>
		<div id="customer_left">
			<table id="list">
				<tr>
					<th>고객 이름</th>
					<th>휴대폰 번호</th>
					<th>포인트</th>
				</tr>
				<c:forEach var ="c" items = "${sessionScope.clist}">
				<tr>
					<td>${c.customerName}</td>
					<td>${c.tel}</td>
					<td>${c.point}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div id="customer_right">
			<label for="name">이름</label>
			<input id="name" type="text">
			<br/>
			<label for="tel">휴대폰 번호</label>
			<input id="tel" type="text" maxlength="11">
			<br/>
			<label for="newTel">변경할 휴대폰 번호</label>
			<input id="newTel" type="text" maxlength="11">
			<br/>
			
			<button id="btnCustomerCk">조회</button>
			<button id="btnCustomerIs">추가</button>
			<button id="btnCustomerUd">수정</button>
			<button id="btnCustomerDl">삭제</button>
		</div>
	</body>
</html>