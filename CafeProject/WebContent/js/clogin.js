$(document).ready(function(){
	//login()함수 선언
	function login(){
		var query = {
			customer_name:$("#name").val(),
			customer_tel:$("#tel").val()
		};   //query
		$.ajax({
			type:"post",
			url:"/CafeProject/cm/customerLoginPro.cu",
			data:query,
			success:function(){
				window.location.href="/CafeProject/cm/customerMain.cu"
			}
		});
	}
	
	//로그인 버튼을 클릭하면 자동 실행
	$("#login").click(function(){
		login();
	});	//login
	
	//패스워드에 커서를 두고 엔터키를 누르면 로그인 함
	$("#name").keydown(function(key) {
		if (key.keyCode == 13) {
			login();
		}
	});
	
	//아이디에 커서를 두고 엔터키를 누르면 로그인 함
	$("#tel").keydown(function(key) {
		if (key.keyCode == 13) {
			login();
		}
	});
	
	$("#member").click(function(){
		if($("#name").val()==null||$("#name").val()==""){
			alert("이름을 입력해주세요");
		}
		else if($("#tel").val()==null||$("#tel").val()==""){
			alert("전화번호를 입력해주세요");
		}
		else{
			var query = {
					customer_name:$("#name").val(),
					customer_tel:$("#tel").val()
			};   //query
			$.ajax({
				type:"post",
				url:"/CafeProject/cm/customerAdd.cu",
				data:query,
				success:function(){
					window.location.href="/CafeProject/cm/customerLoginMain.cu"
				}
			});
		}
	});	//member
});	//document