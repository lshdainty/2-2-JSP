<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>주문 페이지입니다.</title>
		<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>
		<script src="/CafeProject/js/order.js"></script>
		<link rel="stylesheet" href="/CafeProject/css/order.css">
	</head>
	<body>
		<div id="order_Top">
			<div id="coffee">
				<button id="btnCoffee">커피</button>
			</div>
			<div id="dessert">
				<button id="btnDessert">디저트</button>
			</div>
			<div id="ade">
				<button id="btnAde">에이드</button>
			</div>
		</div>
		<div id="order_Bottom">
			<div id="order_Bottom_left">
				<div id="order_Bottom_left_top">
				<div id="orderTable_list">
					<table id="checkboxTestTbl">
						<colgroup>
							<col width="40px;" />
							<col width="200px;" />
							<col width="100px;" />
						</colgroup>
						<tr>
							<th><input id="allChoose" type="checkbox"/></th>
							<th>품목</th>
							<th>수량</th>
							<th>판매 금액</th>
						</tr>
						<tr>
							<td><input class="choose" name="choose" type="checkbox"/></td>
							<td>아메리카노</td>
							<td>2</td>
							<td>3000</td>
						</tr>
						<tr>
							<td><input class="choose" name="choose" type="checkbox"/></td>
							<td>아메리카노</td>
							<td>2</td>
							<td>3000</td>
						</tr>
					</table>
				</div>
					<div id="deleteDiv">
						<button id="btnOrderDl">삭제</button>
					</div>
				</div>
				<div id="order_Bottom_left_Dleft">
					합계 수량 : <input type="text"/><br/>
					합계 금액 : <input type="text"/><br/>
					할인 금액 : <input type="text"/><br/>
					총 금액 : <input type="text"/><br/>
					받은 금액 : <input type="text"/><br/>
					거스름돈 : <input type="text"/><br/>
					<div id="paymentContainer">
						<button id="btnPayment">결제</button> 
					</div>
				</div>
				<div id="order_Bottom_left_Dright">
					고객 포인트 확인<br/>
					휴대폰 번호 : <input type="text"/><br/>
					사용 가능 금액 : <input type="text"/><br/>
					사용 할 금액 : <input type="text"/><br/>
					<button id="btnPointCk">조회</button>
					<button id="btnPointUse">사용</button>
				</div>
			</div>
			<div id="order_Bottom_right">상품 목록 이미지 및 버튼?</div>
		</div>
	</body>
</html>