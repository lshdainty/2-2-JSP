$(document).ready(function(){
	$("#select").click(function(){	//조회 버튼을 눌렀을때
		var query = {
				name:$("#name").val()
		};	//query
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/employeeSelect.do",
			data:query,
			success:function(data){
				alert("조회하였습니다.");
				window.location.href="/CafeProject/mg/employeeMain.do"
			}
		});	//ajax
	});	//select
	
	$("#add").click(function(){	//추가 버튼을 눌렀을때
		var query = {
				name:$("#name").val(),
				passwd:$("#passwd").val()
		};	//query
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/employeeAdd.do",
			data:query,
			success:function(data){
				alert("추가하였습니다.");
				window.location.href="/CafeProject/mg/employeeMain.do"
			}
		});	//ajax
	});	//add
	
	$("#delete").click(function(){	//삭제 버튼을 눌렀을때
		var query = {
				id:$("#id").val(),
		};	//query
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/employeeDelete.do",
			data:query,
			success:function(data){
				alert("삭제하였습니다.");
				window.location.href="/CafeProject/mg/employeeMain.do"
			}
		});	//ajax
	});	//delete
});	//document