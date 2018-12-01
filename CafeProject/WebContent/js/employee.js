$(document).ready(function(){
	$("#select").click(function(){	//조회 버튼을 눌렀을때
		window.location.href="/CafeProject/mg/employeeSelect.do"
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
				window.location.href="/CafeProject/mg/employeeSelect.do"
			}
		});	//ajax
	});	//add
	
	$("#delete").click(function(){	//삭제 버튼을 눌렀을때
	});	//delete
});	//document