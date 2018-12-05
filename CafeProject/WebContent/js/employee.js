$(document).ready(function(){
	//체크한 행의 데이터를 가져온다.
	$(".check").click(function() {
		$("input[name=check]:checked").change(function() {
			var test = $(this);
			var parent = test.parent();
			var grand = parent.parent();
			var id = grand.find('> .elist:eq(1)');
			var name = grand.find('> .elist:eq(2)');
			var tel = grand.find('> .elist:eq(3)');
			$("#id").val(id.text());
			$("#name").val(name.text());
			$("#tel").val(tel.text());
		});
	});
	
	//조회 버튼을 눌렀을때
	$("#btnEmployeeCk").click(function(){
		if($("#btnEmployeeCk").html()=="조회"){
			$("#btnEmployeeCk").html("조회하기");
			$("#btnEmployeeIs").html("추가");
			$("#btnEmployeeUd").html("수정");
			$("#btnEmployeeDl").html("삭제");
			$("#divId").css("display", "none");
			$("#divName").css("display", "block");
			$("#divPasswd").css("display", "none");
			$("#divTel").css("display","none");
		}	//if
		else if($("#btnEmployeeCk").html() == "조회하기"){
			if($("#name").val() == "" || $("#name").val() == null){
				alert("이름을 입력해주세요");
			}	//이름 추가 alert
			else{
				var query = {
						manager_name:$("#name").val()
				};	//query
				$.ajax({
					type:"post",
					url:"/CafeProject/mg/employeeSelect.do",
					data:query,
					success:function(data){
						alert("조회하였습니다.");
						window.location.href="/CafeProject/mg/employeeMain.do"
					}	//success
				});	//ajax
			}	//else
		}	//else if
	});	//select
	
	//추가 버튼을 눌렀을때
	$("#btnEmployeeIs").click(function(){
		if($("#btnEmployeeIs").html()=="추가"){
			$("#btnEmployeeCk").html("조회");
			$("#btnEmployeeIs").html("추가하기");
			$("#btnEmployeeUd").html("수정");
			$("#btnEmployeeDl").html("삭제");
			$("#divId").css("display", "none");
			$("#divName").css("display", "block");
			$("#divPasswd").css("display", "block");
			$("#divTel").css("display","block");
		}	//if
		else if($("#btnEmployeeIs").html()=="추가하기"){
			if($("#name").val() == "" || $("#name").val() == null){
				alert("이름을 입력해주세요");
			}	//이름 추가 alert
			else if($("#passwd").val() == "" || $("#passwd").val() == null){
				alert("비밀번호를 입력해주세요");
			}	//비밀번호 추가 alert
			else if($("#tel").val() == "" || $("#tel").val() == null){
				alert("전화번호를 입력해주세요");
			}	//전화번호 추가 alert
			else{
				if((confirm("추가하시겠습니까?") == true)){
					var query = {
							manager_name:$("#name").val(),
							manager_passwd:$("#passwd").val(),
							manager_tel:$("#tel").val()
					};	//query
					$.ajax({
						type:"post",
						url:"/CafeProject/mg/employeeAdd.do",
						data:query,
						success:function(data){
							alert("추가하였습니다.");
							window.location.href="/CafeProject/mg/employeeMain.do"
						}	//success
					});	//ajax
				}	//if
			}	//else
		}	//else if
	});	//add
	
	//수정 버튼을 눌렀을때
	$("#btnEmployeeUd").click(function(){
		if($("#btnEmployeeUd").html()=="수정"){
			$("#btnEmployeeCk").html("조회");
			$("#btnEmployeeIs").html("추가");
			$("#btnEmployeeUd").html("수정하기");
			$("#btnEmployeeDl").html("삭제");
			$("#divId").css("display", "none");
			$("#divName").css("display", "block");
			$("#divPasswd").css("display", "block");
			$("#divTel").css("display","block");
		}	//if
		else if($("#btnEmployeeUd").html() == "수정하기"){
			if($("#name").val() == "" || $("#name").val() == null){
				alert("이름을 입력해주세요");
			}	//이름 추가 alert
			else if($("#passwd").val() == "" || $("#passwd").val() == null){
				alert("비밀번호를 입력해주세요");
			}	//비밀번호 추가 alert
			else if($("#tel").val() == "" || $("#tel").val() == null){
				alert("전화번호를 입력해주세요");
			}	//전화번호 추가 alert
			else{
				if((confirm("수정하시겠습니까?") == true)){
					var query = {
							manager_code:$("#id").val(),
							manager_name:$("#name").val(),
							manager_passwd:$("#passwd").val(),
							manager_tel:$("#tel").val()
					};	//query
					$.ajax({
						type:"post",
						url:"/CafeProject/mg/employeeUpdate.do",
						data:query,
						success:function(data){
							alert("수정하였습니다.");
							window.location.href="/CafeProject/mg/employeeMain.do"
						}	//success
					});	//ajax
				}	//if
			}	//else
		}	//else if
	});	//update
	
	//삭제 버튼을 눌렀을때
	$("#btnEmployeeDl").click(function(){
		if($("#btnEmployeeDl").html()=="삭제"){
			$("#btnEmployeeCk").html("조회");
			$("#btnEmployeeIs").html("추가");
			$("#btnEmployeeUd").html("수정");
			$("#btnEmployeeDl").html("삭제하기");
			$("#divId").css("display", "block");
			$("#divName").css("display", "none");
			$("#divPasswd").css("display", "none");
			$("#divTel").css("display","none");
		}	//if
		else if($("#btnEmployeeDl").html() == "삭제하기"){
			if($("#id").val() == "" || $("#id").val() == null){
				alert("직원 번호를 입력해주세요");
			}	//직원 번호 추가 alert
			else{
				if((confirm("삭제하시겠습니까?") == true)){
					var query = {
							manager_code:$("#id").val(),
					};	//query
					$.ajax({
						type:"post",
						url:"/CafeProject/mg/employeeDelete.do",
						data:query,
						success:function(data){
							alert("삭제하였습니다.");
							window.location.href="/CafeProject/mg/employeeMain.do"
						}	//success
					});	//ajax
				}	//if
			}	//else
		}	//else if
	});	//delete
});	//document