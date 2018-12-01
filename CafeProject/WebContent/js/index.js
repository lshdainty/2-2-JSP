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
	
	$("#btnOrder").click(function(){	//주문 버튼을 눌렀을때
		window.location.href="/CafeProject/mg/orderMain.do";
	});	//order
	
	$("#btnCustomer").click(function(){	//고객 버튼을 눌렀을때
		window.location.href="/CafeProject/mg/customerMain.do";
	});	//customer
	
	$("#btnMenu").click(function(){	//메뉴 버튼을 눌렀을때
		window.location.href="/CafeProject/mg/menuMain.do";
	});	//menu
	
	$("#btnSales").click(function(){	//매출 버튼을 눌렀을때
		window.location.href="/CafeProject/mg/salesMain.do";
	});	//sales
	
	$("#btnEmployee").click(function(){	//직원 버튼을 눌렀을때
		window.location.href="/CafeProject/mg/employeeSelect.do";
	});	//employee
});	//document