<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>고객 메인 페이지입니다.</title>
	<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
	<script src="/CafeProject/js/cmain.js"></script>
	<link rel="stylesheet" href="/CafeProject/css/cmain.css">
</head>
<body style="background:#eeeeee;">
	<div id="cindexId">
		${cname}님 반갑습니다.
		<button id="logout">로그아웃</button>
	</div>
	<div id="cmenu">
		<ul class="menu">
			<li class="click">결제 내역보기</li>
			<li class="click">포인트 적립/사용 내역보기</li>
			<li class="slider"></li>
		</ul>
	</div>
	<div id="pay" style="display:block">
		<div id="table">
		<table class="list">
			<thead>
				<tr>
					<th scope="col">결제 날짜</th>
					<th scope="col">구매 가격</th>
					<th scope="col">적립 포인트</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var ="pay" items = "${sessionScope.pay}">
				<tr>
					<th scope="row">${pay.purchase_date}</th>
					<td>${pay.purchase_price}</td>
					<td>${pay.add_point}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
	<div id="point" style="display:none">
		<div id="table">
		<table class="list">
			<thead>
				<tr>
					<th scope="col">적립/사용 날짜</th>
					<th scope="col">적립/사용 가격</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var ="point" items = "${sessionScope.point}">
				<tr>
					<th scope="row">${point.use_date}</th>
					<td>${point.use_point}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</body>
</html>