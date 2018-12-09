<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>주문 페이지입니다.</title>
		<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
		<script src="/CafeProject/js/order.js"></script>
		<script>
			$(document).ready(function(){
				$("#btnPointCk").click(function(){
					var list = ${sessionScope.clist};	//session에 고객리스트 가져오기
					var tel = $("#tel").val();
					//session에 있는 고객리스트에서 번호가 같은 사람 찾기
					for(var i=0; i<list.length; i++){	 
						if(tel==list[i].customer_tel){
							alert("회원입니다.");
							$("#point").val(list[i].point);
						}
					}
				});
			});
		</script>
		<link rel="stylesheet" href="/CafeProject/css/order.css">
	</head>
	<body>
		<div id="order_Top">
			<div id="divGroup">
				<button class="group" value="all">전체보기</button>
				<button class="group" value="co">커피</button>
				<button class="group" value="ca">케이크</button>
			</div>
		</div>
		<div id="order_Bottom">
			<div id="order_Bottom_left">
				<div id="order_Bottom_left_top">
					<div id="orderTable_list">
						<table id="radioTbl">
							<tr>
								<th></th>
								<th>이미지</th>
								<th>상품 이름</th>
								<th>수량</th>
								<th>가격</th>
								<th>총 금액</th>
							</tr>
						</table>
					</div>
					<div id="deleteDiv">
						<button id="btnOrderDl">삭제</button>
					</div>
				</div>
				<div id="order_Bottom_left_Dleft">
					<div id="divTotalCount">
						<label for="count">합계 수량 : </label>
						<input id="count" type="text" value="0" readonly>
					</div>
					<div id="divTotalPrice">
						<label for="tprice">합계 금액 : </label>
						<input id="tprice" type="text" value="0" readonly>
					</div>
					<div id="divSalePrice">
						<label for="sprice">할인 금액 : </label>
						<input id="sprice" type="text" value="0" readonly>
					</div>
					<div id="divResultPrice">
						<label for="rprice">총 금액 : </label>
						<input id="rprice" type="text" value="0" readonly>
					</div>
					<div id="divGetPrice">
						<label for="gprice">받은 금액 : </label>
						<input id="gprice" type="text">
					</div>
					<div id="paymentContainer">
						<button id="btnPayment">결제</button> 
					</div>
				</div>
				<div id="order_Bottom_left_Dright">
					<div>고객 정보 확인</div>
					<br/>
					<div id="divUse">
						<label for="use">포인트 사용 가능 금액 : </label>
						<input id="use" type="text" value="5000" readonly>
					</div>
					<div id="divTel">
						<label for="tel">휴대폰 번호 : </label>
						<input id="tel" type="text" value="" maxlength="11">
					</div>
					<div id="divPoint">
						<label for="point">포인트 : </label>
						<input id="point" type="text" value="0" readonly>
					</div>
					<div id="divUPoint">
						<label for="upoint">사용 할 금액 : </label>
						<input id="upoint" type="text" placeholder="0" maxlength="6">
					</div>
					<button id="btnPointCk">조회</button>
					<button id="btnPointUse">사용</button>
					<button id="btnChangePoint">포인트 사용 가능금액 변경</button>
				</div>
			</div>
			<div id="order_Bottom_right">
				<c:forEach var ="m" items = "${sessionScope.mlist}">
				<button class="productButton">
					<div class="productClass"><img src="${m.product_picture}" width="115px" height="115px"></div>
					<div class="productClass">${m.product_name}</div>
					<div class="productClass">${m.product_price}</div>
					<div class="productClass" style="display:none;">${m.pgroup_code}</div>
				</button>
				</c:forEach>
			</div>
		</div>
	</body>
</html>