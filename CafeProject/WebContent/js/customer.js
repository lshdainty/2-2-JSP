$(document).ready(function(){
	//체크한 행의 데이터를 가져온다.
	$(".check").click(function() {
		$("input[name=check]:checked").change(function() {
			var test = $(this);
			var parent = test.parent();
			var grand = parent.parent();
			var name = grand.find('> .clist:eq(1)');
			var tel = grand.find('> .clist:eq(2)');
			$("#name").val(name.text());
			$("#tel").val(tel.text());
		});
	});
	
	//조회 버튼을 눌렀을때
	$("#btnCustomerCk").click(function(){
		if($("#btnCustomerCk").html()=="조회"){
			$("#btnCustomerCk").html("조회하기");
			$("#btnCustomerIs").html("추가");
			$("#btnCustomerUd").html("수정");
			$("#btnCustomerDl").html("삭제");
			$("#divName").css("display", "none");
			$("#divTel").css("display", "block");
			$("#divNewTel").css("display", "none");
		}	//if
		else if($("#btnCustomerCk").html() == "조회하기"){
			if($("#tel").val() == "" || $("#tel").val() == null){
				alert("휴대폰 번호를 입력해주세요");
			}	//휴대폰 번호 추가 alert
			else{
				var query = {
						customer_tel:$("#tel").val()
				};	//query
				$.ajax({
					type:"post",
					url:"/CafeProject/mg/customerSelect.do",
					data:query,
					success:function(data){
						alert("조회하였습니다.");
						window.location.href="/CafeProject/mg/customerMain.do"
					}	//success
				});	//ajax
			}	//else
		}	//else if
	});	//select
	
	//추가 버튼을 눌렀을때
	$("#btnCustomerIs").click(function(){
		if($("#btnCustomerIs").html()=="추가"){
			$("#btnCustomerCk").html("조회");
			$("#btnCustomerIs").html("추가하기");
			$("#btnCustomerUd").html("수정");
			$("#btnCustomerDl").html("삭제");
			$("#divName").css("display", "block");
			$("#divTel").css("display", "block");
			$("#divNewTel").css("display", "none");
		}	//if
		else if($("#btnCustomerIs").html() == "추가하기"){
			if($("#tel").val() == "" || $("#tel").val() == null){
				alert("휴대폰 번호를 입력해주세요");
			}	//휴대폰 번호 추가 alert
			else if($("#name").val() == "" || $("#name").val() == null){
				alert("이름을 입력해주세요");
			}	//이름 추가 alert
			else{
				if((confirm("추가하시겠습니까?") == true)){
					var query = {
							customer_name:$("#name").val(),
							customer_tel:$("#tel").val()
					};	//query
					$.ajax({
						type:"post",
						url:"/CafeProject/mg/customerAdd.do",
						data:query,
						success:function(data){
							alert("추가하였습니다.");
							window.location.href="/CafeProject/mg/customerMain.do"
						}	//success
					});	//ajax
				}	//if
			}	//else
		}	//else if
	});	//add
	
	//수정 버튼을 눌렀을때
	$("#btnCustomerUd").click(function(){
		if($("#btnCustomerUd").html()=="수정"){
			$("#btnCustomerCk").html("조회");
			$("#btnCustomerIs").html("추가");
			$("#btnCustomerUd").html("수정하기");
			$("#btnCustomerDl").html("삭제");
			$("#divName").css("display", "block");
			$("#divTel").css("display", "block");
			$("#divNewTel").css("display", "block");
		}	//if
		else if($("#btnCustomerUd").html() == "수정하기"){
			if($("#tel").val() == "" || $("#tel").val() == null){
				alert("휴대폰 번호를 입력해주세요");
			}	//휴대폰 번호 추가 alert
			else if($("#name").val() == "" || $("#name").val() == null){
				alert("이름을 입력해주세요");
			}	//이름 추가 alert
			else if($("#newTel").val() == "" || $("#newTel").val() == null){
				alert("변경할 휴대폰 번호를 입력해주세요");
			}	//변경할 휴대폰 번호 입력
			else{
				if((confirm("수정하시겠습니까?") == true)){
					var query = {
							customer_name:$("#name").val(),
							customer_tel:$("#tel").val(),
							customer_newTel:$("#newTel").val()
					};	//query
					$.ajax({
						type:"post",
						url:"/CafeProject/mg/customerUpdate.do",
						data:query,
						success:function(data){
							alert("수정하였습니다.");
							window.location.href="/CafeProject/mg/customerMain.do"
						}	//success
					});	//ajax
				}	//if
			}	//else
		}	//else if
	});	//update
	
	//삭제 버튼을 눌렀을때
	$("#btnCustomerDl").click(function(){
		if($("#btnCustomerDl").html()=="삭제"){
			$("#btnCustomerCk").html("조회");
			$("#btnCustomerIs").html("추가");
			$("#btnCustomerUd").html("수정");
			$("#btnCustomerDl").html("삭제하기");
			$("#divName").css("display", "none");
			$("#divTel").css("display", "block");
			$("#divNewTel").css("display", "none");
		}	//if
		else if($("#btnCustomerDl").html() == "삭제하기"){
			if($("#tel").val() == "" || $("#tel").val() == null){
				alert("휴대폰 번호를 입력해주세요");
			}	//휴대폰 번호 추가 alert
			else{
				if((confirm("삭제하시겠습니까?") == true)){
					var query = {
							customer_tel:$("#tel").val(),
					};	//query
					$.ajax({
						type:"post",
						url:"/CafeProject/mg/customerDelete.do",
						data:query,
						success:function(data){
							alert("삭제하였습니다.");
							window.location.href="/CafeProject/mg/customerMain.do"
						}	//success
					});	//ajax
				}	//if
			}	//else
		}	//else if
	});	//delete
});	//document