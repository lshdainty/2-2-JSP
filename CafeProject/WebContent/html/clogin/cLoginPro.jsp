
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">	<%-- check값이 1이면 로그인 성공 --%>
	<c:set var="tel" value="${tel}" scope="session"/>	<%-- 로그인 성공일때 session에 tel값 저장 --%>
	<c:set var="cname" value="${cname }" scope="session"/>
	<c:set var="pay" value="${pay }" scope="session"/>
	<c:set var="point" value="${point }" scope="session"/>
</c:if>