$(document).ready(function(){
	//그룹 보기
	$(".group").click(function(){
		$(".productButton").show();
		
		var group_code = $(this).attr("value");
		
		if(group_code != "all"){
			for(var i=0; i<$(".productButton").length; i++){
				var code = $(".productButton").eq(i).find("> .productClass:eq(3)").text();
				if(group_code!=code){
					$(".productButton").eq(i).hide();
				}
			}
		}
	});
	
	//제품 클릭시
	$(".productButton").click(function(){
		var btnObject = $(this);
		var image = btnObject.find("> .productClass:eq(0) > img").attr('src');
		var name = btnObject.find("> .productClass:eq(1)").text();
		var price = btnObject.find("> .productClass:eq(2)").text();
		var check = 0;
		var count = 0;
		
		for(var i=0; i<$(".trProduct").length; i++){
			var listname = $(".trProduct").eq(i).find("> .tdProduct:eq(2)").text();
			if(name == listname){
				check = 1;	//기존에 있는 행인지 체크
				count =  Number($(".trProduct").eq(i).find("> .tdProduct:eq(3) > input").val());
				count = count + 1;
				price = Number(price) * count;
				console.log(price);
				$(".trProduct").eq(i).find("> .tdProduct:eq(3) > input").val(count);
				$(".trProduct").eq(i).find("> .tdProduct:eq(5)").text(price);
			}
		}
		if(!check){
			$('#radioTbl > ').append("<tr class='trProduct'><td class='tdProduct'><input class='check' name='check' type='radio'/></td><td class='tdProduct'><img src='"+image+"' width='65px' height='65px'></td><td class='tdProduct'>"+name+"</td><td class='tdProduct'><input type='number' value='1' step='1' class='count'></td><td class='tdProduct'>"+price+"</td><td class='tdProduct'>"+price+"</td></tr>");
		}
		totalcount();
		totalprice();
	});
	
	//숫자를 클릭시
	//(동적으로 생성된 html에서는 일반적인 이벤트($().click)와 같은 것이 동작하지 않는다.
	//해결하는 방법이 on함수로 이벤트를 작성해야 정상 작동
	$(document).on("click",".count",function(){
		var num = $(this);
		if(num.val()<=0){
			num.val(0);
		}
		var grand = num.parent().parent();	//조상선택
		var originalPrice = Number(grand.find("> .tdProduct:eq(4)").text());	//제품가격을 선택
		var Price = originalPrice*num.val();	//제품 선택수만큼 가격을 곱함
		Number(grand.find("> .tdProduct:eq(5)").text(Price));	//총 가격에 가격셋팅
		totalcount();
		totalprice();
	});
	
	//radio버튼 누르고 삭제버튼 이벤트
	$("#btnOrderDl").click(function(){
		var grand = $("input[name=check]:checked").parent().parent();
		grand.remove();
		totalcount();
		totalprice();
	});
	
	//포인트 사용
	$("#btnPointUse").click(function(){
		var point = Number($("#point").val());	//사용자의 point
		var possible = Number($("#use").val());	//포인트 사용 가능한 최저금액 범위
		if((point-possible)>=0){
			var use = Number($("#upoint").val());
			if(point>=use){
				$("#sprice").val(use);
			}
			else{
				alert("본인이 소유한 포인트보다 더 많은 포인트를 입력하셨습니다.");
			}
		}else{
			alert("포인트는"+ possible +"원 이상 보유해야 사용 가능합니다.");
		}
		totalprice();
	});
	
	//포인트 사용 기준금액 변경
	$("#btnChangePoint").click(function(){
		var possible = prompt("변경할 포인트 사용 기준 금액을 입력해주세요.","");
		if(possible==null||possible==""){alert("숫자를 입력해주세요");}
		else if(isNaN(possible)){alert("숫자를 입력해주세요");}
		else{
			var query = {standard:possible};	//query
			$.ajax({
				type:"post",
				url:"/CafeProject/mg/orderStandard.do",
				data:query,
				success:function(data){
					window.location.href="/CafeProject/mg/orderMain.do"
				}	//success
			});	//ajax
		}
	});
	
	//포인트 적립 % 변경
	$("#btnChangeSave").click(function(){
		var possible_percent = prompt("변경할 포인트 적립 %를 입력해주세요.(%제외)","");
		if(possible_percent==null||possible_percent==""){alert("숫자를 입력해주세요");}
		else if(isNaN(possible_percent)){alert("숫자를 입력해주세요");}
		else{
			var query = {save:possible_percent};	//query
			$.ajax({
				type:"post",
				url:"/CafeProject/mg/orderSave.do",
				data:query,
				success:function(data){
					window.location.href="/CafeProject/mg/orderMain.do"
				}	//success
			});	//ajax
		}
	});
	
	//결제버튼 클릭
	$("#btnPayment").click(function(){
		var rprice = Number($("#rprice").val());	//총 금액
		var gprice = Number($("#gprice").val());	//받은 금액
		if(gprice<rprice){
			alert("돈을 더 내셔야합니다.");
		}
		else{
			var change = gprice - rprice;	//잔돈표시
			var query = {
					purchase_price:$("#rprice").val(),
					customer_tel:$("#tel").val(),
					point:$("#point").val(),
					sprice:$("#sprice").val(),
					save:$("#save").val()
			};	//query
			$.ajax({
				type:"post",
				url:"/CafeProject/mg/orderResult.do",
				data:query,
				success:function(data){
					alert("결제완료했습니다. 잔돈은 " + change + "원 입니다.");
					window.location.href="/CafeProject/mg/orderMain.do"
				}	//success
			});	//ajax
		}
	});
	
	//합계 수량 계산
	function totalcount(){
		var totalcount = 0;
		for(var i=0; i<$(".trProduct").length; i++){
			var count = Number($(".trProduct").eq(i).find("> .tdProduct:eq(3) > input").val());
			totalcount = totalcount + count;
		}
		$("#count").val(totalcount);
	}
	
	//합계 가격 계산
	function totalprice(){
		var totalprice = 0;
		var sale = Number($("#sprice").val());
		for(var i=0; i<$(".trProduct").length; i++){
			var money = Number($(".trProduct").eq(i).find("> .tdProduct:eq(5)").text());
			totalprice = totalprice +  money;
		}
		$("#tprice").val(totalprice);	//합계금액
		if(totalprice<sale){
			sale = totalprice;
			$("#sprice").val(sale);
			$("#upoint").val(sale)
		}
		$("#rprice").val(totalprice-sale);	//총금액
	}
});