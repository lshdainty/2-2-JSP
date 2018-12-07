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
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/orderPro.do",
			success:function(data){
				window.location.href="/CafeProject/mg/orderMain.do";
			}
		});	//ajax
	});	//order
	
	$("#btnCustomer").click(function(){	//고객 버튼을 눌렀을때
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/customerPro.do",
			success:function(data){
				window.location.href="/CafeProject/mg/customerMain.do";
			}
		});	//ajax
	});	//customer
	
	$("#btnMenu").click(function(){	//메뉴 버튼을 눌렀을때
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/menuPro.do",
			success:function(data){
				window.location.href="/CafeProject/mg/menuMain.do";
			}
		});	//ajax
	});	//menu
	
	$("#btnSales").click(function(){	//매출 버튼을 눌렀을때
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/salesPro.do",
			success:function(data){
				window.location.href="/CafeProject/mg/salesMain.do";
			}
		});	//ajax
	});	//sales
	
	$("#btnEmployee").click(function(){	//직원 버튼을 눌렀을때
		$.ajax({
			type:"post",
			url:"/CafeProject/mg/employeePro.do",
			success:function(data){
				window.location.href="/CafeProject/mg/employeeMain.do";
			}
		});	//ajax
	});	//employee
});	//document