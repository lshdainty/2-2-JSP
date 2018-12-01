<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>메뉴 페이지입니다.</title>
		<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
		<script src="/CafeProject/js/menu.js"></script>
		<link rel="stylesheet" href="/CafeProject/css/menu.css">
	</head>
	<body>
		<div id="menu_left">
			상품목록<br/>
			상품목록 테이블<br/>
			1 2 3 4 5<br/>
		</div>
		<div id="menu_right">
		
			상품등록<br/>
			상품번호 : <input type="text"/><br/>
			이름 : <input type="text"/><br/>
			가격 : <input type="text"/><br/>
			
			<button id="btnProductIs">추가</button>
			<button id="btnProductUd">수정</button>
			<button id="btnProductDl">삭제</button>
		</div>
	</body>
</html>