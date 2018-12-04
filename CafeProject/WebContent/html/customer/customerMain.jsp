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
					<th></th>
					<th>고객 이름</th>
					<th>휴대폰 번호</th>
					<th>포인트</th>
				</tr>
				<c:forEach var ="c" items = "${sessionScope.clist}">
				<tr>
					<td><input class="check" type="radio" name="check" value="${c.customer_name},${c.customer_tel}"></td>
					<td>${c.customer_name}</td>
					<td>${c.customer_tel}</td>
					<td>${c.point}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div id="customer_right">
			<div id="customer_right_top">
				<div id="customer_right_inner">
					<div id="divTel" style="display: none;">
						<label for="tel">휴대폰 번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<input id="tel" type="text" maxlength="11">
					</div>
					<div id="divName" style="display:none;">
						<label for="name">이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
						<input id="name" type="text">
					</div>
					<div id="divNewTel" style="display: none;">
						<label for="newTel">변경할 휴대폰 번호</label>
						<input id="newTel" type="text" maxlength="11">
					</div>
				</div>
			</div>
			<div id="customer_right_bottom">
				<button id="btnCustomerCk" class="btn">조회</button>
				<button id="btnCustomerIs" class="btn">추가</button>
				<button id="btnCustomerUd" class="btn">수정</button>
				<button id="btnCustomerDl" class="btn">삭제</button>
			</div>
		</div>
	</body>
</html>