<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">	<%-- check값이 1이면 로그인 성공 --%>
	<c:set var="id" value="${id}" scope="session"/>	<%-- 로그인 성공일때 session에 id값 저장 --%>
	<c:set var="authority" value="${authority }" scope="session"/>	<%-- 로그인 성공일때 session에 authority값 저장 (관리자인지 직원인지 구분)--%>
	<c:set var="clist" value="${clist}" scope="session"/>
	<c:set var="mlist" value="${mlist}" scope="session"/>
	<c:set var="standard" value="${standard}" scope="session"/>
	<c:set var="save" value="${save}" scope="session"/>
</c:if>