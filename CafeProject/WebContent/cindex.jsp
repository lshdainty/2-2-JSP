<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>포인트 조회 페이지</title>
		<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
		<!-- <script src="/CafeProject/js/cindex.js"></script>
		<link rel="stylesheet" href="/CafeProject/css/cindex.css"> -->
	</head>
	<body>
		<%-- session에 tel값이 없을때 --%>
		<c:if test="${empty tel}">
			<jsp:include page="html/clogin/cLoginForm.jsp"/>	<%-- 로그인 페이지 include --%>
		</c:if>
		
		<%-- session에 tel값이 없을때 --%>
		<c:if test="${not empty tel}">
			<jsp:include page="${customer }"/>
		</c:if>
	</body>
</html>