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
});	//document