<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
<script src="/CafeProject/index.js"></script>

<c:if test="${empty id}">
	<jsp:include page="mngr/logon/mLoginForm.jsp"/>
</c:if>
<c:if test="${not empty id}">
	<div>${id}님 반갑습니다.
		<button id="logout">로그아웃</button>
	</div>
	<div>주문</div>
	<div>직원</div>
	<div>매출</div>
	<div>메뉴</div>
	<div>뭐있냐</div>
	<jsp:include page="${cont}"/>
</c:if>
