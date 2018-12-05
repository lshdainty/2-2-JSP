<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>메뉴 페이지입니다.</title>
		<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
		<script src="/CafeProject/js/jquery.form.js"></script>
		<script src="/CafeProject/js/menu.js"></script>
		<link rel="stylesheet" href="/CafeProject/css/menu.css">
	</head>
	<body>
		<div id="menu_left">
			<select class="mainGroup">
				<option value="">선택</option>
				<option value="co">커피</option>
				<option value="ca">케이크</option>
			</select>
			<table id="list">
				<tr>
					<th></th>
					<th>이미지</th>
					<th>상품 코드</th>
					<th>상품 이름</th>
					<th>상품 가격</th>
					<th>상품 분류</th>
				</tr>
				<c:forEach var ="m" items = "${sessionScope.mlist}">
				<tr>
					<td class="plist"><input class="check" type="radio" name="check" value="${m.product_number}"></td>
					<td class="plist" style="margin:0px; padding:0px;"><img src="${m.product_picture}" width="65px" height="65px"></td>
					<td class="plist">${m.product_number}</td>
					<td class="plist">${m.product_name}</td>
					<td class="plist">${m.product_price}</td>
					<td class="plist">${m.pgroup_code}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div id="menu_right">
			<div id="menu_right_top">
				<div id="divImage">
					<img id="div_inner_img" src="" alt="이미지를 넣어주세요" width="250px" height="250px">
				</div>
				<div id="menu_right_inner">
					<form id="upload" method="post" enctype="multipart/form-data">
						<div id="divInput">
							<input id="fileImage" type="file" name="selectfile">
						</div>
						<div id="divCode" style="display:none;">
							<label for="code">제품 코드</label>
							<input id="code" type="text">
						</div>
						<div id="divName">
							<label for="name">이름</label>
							<input id="name" type="text">
						</div>
						<div id="divPrice">
							<label for="price">가격</label>
							<input id="price" type="text">
						</div>
						<select class="selectGroup">
							<option value="">선택</option>
							<option value="co">커피</option>
							<option value="ca">케이크</option>
						</select>
						<input type="button" id="btnMenuCk" value="조회"/>
						<input type="button" id="btnMenuIs" value="추가"/>
						<input type="button" id="btnMenuUd" value="수정"/>
						<input type="button" id="btnMenuDl" value="삭제"/>
					</form>
				</div>
			</div>
			<div id="menu_right_bottom">
			</div>
		</div>
	</body>
</html>