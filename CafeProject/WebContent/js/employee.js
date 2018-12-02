$(document).ready(function(){
	//전체 선택
	$("#allChoose").click(function(){
		if($("#allChoose").is(":checked")){
			$(".choose").prop("checked",true);
		}
		else{
			$(".choose").prop("checked",false);
		}
	});
	
	//전체선택에서 하나라도 빠지면 전체선택 해제
	$(".choose").click(function(){
		if($("input[name='choose']:checked").length==$("input[name='choose']").length){
			$("#allChoose").prop("checked",true);
		}
		else{
			$("#allChoose").prop("checked",false);
		}
	});
	
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