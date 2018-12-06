$(document).ready(function(){
	$("#btnPayment").click(function(){
		alert("버튼클릭완료");
		alert($("#test").val());
		var query = {
				totalprice:$("#test").val()
		};	//query
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/orderAction.do",
			data:query,
			success:function(data){
				alert("조회하였습니다.");
				//var point = '${sessionScope.test}';
				$("#test").val('${sessionScope.test}');
//				alert(point);
//				console.log(point);
			}	//success
		});	//ajax
	});
});