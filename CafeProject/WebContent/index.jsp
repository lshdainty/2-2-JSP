<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
<script src="/CafeProject/index.js"></script>

<c:if test="${empty id}">
	<jsp:include page="html/mlogin/mLoginForm.jsp"/>
</c:if>
<c:if test="${not empty id}">
	<div>${id}님 반갑습니다.
		<button id="logout">로그아웃</button>
	</div>
	<div>
		<button id="order">주문</button>
	</div>
	<div>
		<button id="customer">고객</button>
	</div>
	<div>
		<button id="menu">메뉴</button>
	</div>
	<div>
		<button id="sales">매출</button>
	</div>
	<div>
		<button id="employee">직원</button>
	</div>
	<jsp:include page="${cont}"/>
</c:if>
