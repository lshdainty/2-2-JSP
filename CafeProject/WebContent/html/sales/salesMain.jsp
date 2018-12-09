<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>매출 페이지입니다.</title>

<!-- ▼ morris.js 차트를 사용하기 위한 CDN ▼-->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
<!-- ▲ morris.js 차트를 사용하기 위한 CDN ▲ 필요시 파일 import방식으로 바꿔도 될 듯-->
<link rel="stylesheet" href="/CafeProject/css/sales.css">
<script src="/CafeProject/js/sales.js"></script>

<script src="/CafeProject/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		var slist = '${slist}';
		var json = JSON.parse('${slist}');
		
		// line차트를 그리는 부분
		new Morris.Line({
			//↓---필수 값(무조건 있어야 함)----↓
			element : 'lineChart', //div id값이 lineChart인 곳에 차트를 그린다.
			data : json,
			xkey : 'month',
			ykeys : [ 'totalSales' ],
			labels : [ '총 매출' ],
			//↑---필수 값(무조건 있어야 함)----↑
			lineColors : [ 'black' ],
			pointSize : 10
		});
	});
</script>



</head>
<body>
	<div id="chartArea">
		<h1>매출 현황</h1>
		<div id="lineChart">
		</div>
	</div>
	
	<div id="yearSelect">
		<input type="text" id="year" class="btnSales" placeholder="2018" maxlength="4" autofocus/>
		<input type="button" id="btnSalesCk" class="btnSales" value="조회"/>
	</div>
</body>
</html>