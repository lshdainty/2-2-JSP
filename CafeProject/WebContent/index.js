$(document).ready(function(){
	$("#logout").click(function(){
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/managerLogout.do",
			success:function(data){
				window.location.href="/CafeProject/mg/managerLoginForm.do";
			}
		});	//ajax
	});	//logout
	
	$("#order").click(function(){	//주문 버튼을 눌렀을때
		window.location.href="/CafeProject/mg/orderMain.do";
	});	//order
	
	$("#customer").click(function(){	//고객 버튼을 눌렀을때
		window.location.href="/CafeProject/mg/customerMain.do";
	});	//customer
	
	$("#menu").click(function(){	//메뉴 버튼을 눌렀을때
		window.location.href="/CafeProject/mg/menuMain.do";
	});	//menu
	
	$("#sales").click(function(){	//매출 버튼을 눌렀을때
		window.location.href="/CafeProject/mg/salesMain.do";
	});	//sales
	
	$("#employee").click(function(){	//직원 버튼을 눌렀을때
		window.location.href="/CafeProject/mg/employeeMain.do";
	});	//employee
});	//document