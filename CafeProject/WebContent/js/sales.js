$(document).ready(function(){

	//selectSales()함수 선언
	function selectSales(){
			if ($("#year").val() == "" || $("#year").val() == null) {
				alert("연도를 입력하세요");
			} // 연도 조회 alert
			else {

				console.log($("#year").val());
				var query = {
					year : $("#year").val()

				}; // query
				$.ajax({
					type : "post",
					url : "/CafeProject/mg/salesSelect.do",
					data : query,
					success : function(data) {
						
						window.location.href = "/CafeProject/mg/salesMain.do"
					} // success
				}); // ajax
			} //else
	}
	
	// 조회 버튼 클릭하면 selectSales()함수 실행
	$("#btnSalesCk").click(function(){
		selectSales();
	});
	
	// 연도 입력에 커서를 두고 엔터키를 누르면 조회(selectSales()함수 실행) 함
	$("#year").keydown(function(key) {
		if (key.keyCode == 13) {
			selectSales();
		}
	});
	
});	//document