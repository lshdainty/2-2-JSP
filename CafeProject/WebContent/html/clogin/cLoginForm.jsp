<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>고객 로그인 페이지입니다.</title>
		<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
		<script src="/CafeProject/js/clogin.js"></script>
		<script>
			var test = ${cMemberCheck};
			if(test==1||test==2){
				if(test==1){
					alert("동일한 휴대폰 번호가 있습니다.");
				}
				else if(test==2){
					alert("회원가입 완료");
				}
			}
		</script>
		<link rel="stylesheet" href="/CafeProject/css/cLogin.css">
	</head>
	<body style="background:#eeeeee;">
		<div id="cloginBox">
			<div id="clogImg">
				<img src="/CafeProject/images/2.jpg" />
			</div>
			<div id="status">
				<p><label for="name">이름 : </label>
					<input id="name" name="name" type="text" size="20" autofocus/><p/>
				<p><label for="tel">전화번호 : </label>
					<input id="tel" name="tel" type="text" placeholder="'-'를 빼고 입력해주세요" maxlength="11" size="20"/><p/>
				<div>
					<button id="login">로그인</button>
					<button id="member">회원가입</button>
				</div>
			</div>
		</div>
	</body>
</html>