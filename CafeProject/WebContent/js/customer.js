$(document).ready(function(){
	$("#btnCustomerCk").click(function(){	//조회 버튼을 눌렀을때
		var query = {
				name:$("#name").val()
		};	//query
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/customerSelect.do",
			data:query,
			success:function(data){
				alert("조회하였습니다.");
				window.location.href="/CafeProject/mg/customerMain.do"
			}
		});	//ajax
	});	//select
	
	$("#btnCustomerIs").click(function(){	//추가 버튼을 눌렀을때
		var query = {
				name:$("#name").val(),
				tel:$("#tel").val()
		};	//query
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/customerAdd.do",
			data:query,
			success:function(data){
				alert("추가하였습니다.");
				window.location.href="/CafeProject/mg/customerMain.do"
			}
		});	//ajax
	});	//add
	
	$("#btnCustomerUd").click(function(){	//수정 버튼을 눌렀을때
		var query = {
				name:$("#name").val(),
				tel:$("#tel").val(),
				newTel:$("#newTel").val()
		};	//query
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/customerUpdate.do",
			data:query,
			success:function(data){
				alert("수정하였습니다.");
				window.location.href="/CafeProject/mg/customerMain.do"
			}
		});	//ajax
	});	//delete
	
	$("#btnCustomerDl").click(function(){	//삭제 버튼을 눌렀을때
		var query = {
				tel:$("#tel").val(),
		};	//query
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/customerDelete.do",
			data:query,
			success:function(data){
				alert("삭제하였습니다.");
				window.location.href="/CafeProject/mg/customerMain.do"
			}
		});	//ajax
	});	//delete
});	//document