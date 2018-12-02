<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>카페입니다.</title>
		<link rel="stylesheet" href="/CafeProject/css/index.css">
		<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
		<script src="/CafeProject/js/index.js"></script>
	</head>
	<body>
		<%-- session에 id값이 없을때 --%>
		<c:if test="${empty id}">
			<jsp:include page="html/mlogin/mLoginForm.jsp"/>	<%-- 로그인 페이지 include --%>
		</c:if>
		
		<%-- session에 id값이 없을때 --%>
		<c:if test="${not empty id}">
			<%-- session에 authority값이 1이면 관리자이다. --%>
			<c:if test="${authority == 1}">
				<div id="indexId">
					사장님 반갑습니다.
					<button id="logout">로그아웃</button>
				</div>
				<div id="left_side">
					<div id="order">
						<button id="btnOrder">주문</button>
					</div>
					<div id="customer">
					<button id="btnCustomer">고객</button>
					</div>
					<div id="menu">
						<button id="btnMenu">메뉴</button>
					</div>
					<div id="sales">
					<button id="btnSales">매출</button>
					</div>
					<div id="employee">
						<button id="btnEmployee">직원</button>
					</div>
				</div>
				<div id="main">
					<jsp:include page="${cont}"/>
				</div>
			</c:if>
			<%-- session에 authority값이 2이면 직원이다. --%>
			<c:if test="${authority == 2}">
				<div>
					${id}님 반갑습니다.
					<button id="logout">로그아웃</button>
				</div>
				<div id="left_side">
					<div id="order">
						<button id="btnOrder">주문</button>
					</div>
					<div id="customer">
					<button id="btnCustomer">고객</button>
					</div>
				</div>
				<div id="main">
					<jsp:include page="${cont}"/>
				</div>
			</c:if>
		</c:if>
	</body>
</html>