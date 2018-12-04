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
});