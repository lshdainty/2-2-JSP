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
			고객목록<br/>
			고객목록 테이블<br/>
			1 2 3 4 5<br/>
		</div>
		<div id="customer_right">
			이름 : <input type="text"/><br/>
			휴대폰 번호 : <input type="text"/><br/>
			
			<button id="btnCustomerCk">조회</button>
			<button id="btnCustomerIs">추가</button>
			<button id="btnCustomerUd">수정</button>
		</div>
	</body>
</html>