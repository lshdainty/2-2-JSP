$(document).ready(function(){
	//radio 선택하면 input에 데이터 입력
	$(".check").click(function(){
		$("input[name=check]:checked").change(function(){
			var test = $(this);
			var parent = test.parent();
			var grand = parent.parent();
			var image = grand.find('> .plist:eq(1) > img');
			var code = grand.find('> .plist:eq(2)');
			var name = grand.find('> .plist:eq(3)');
			var price = grand.find('> .plist:eq(4)');
			var group = grand.find('> .plist:eq(5)');
			$("#div_inner_img").prop("src",image.attr('src'));
			$("#code").val(code.text());
			$("#name").val(name.text());
			$("#price").val(price.text());
			$(".selectGroup").val(group.text());
		});
	});
	
	//그룹 선택
	$(".group").click(function(){
		$(".trlist").show();
		
		var group_code = $(this).attr("value");
		
		if(group_code != "all"){
			for(var i=0; i<$(".trlist").length; i++){
				var code = $(".trlist").eq(i).find("> .plist:eq(5)").text();
				if(group_code!=code){
					$(".trlist").eq(i).hide();
				}
			}
		}
	});
	
	//이미지를 업로드할때 이미지preview보기
	function readURL(input){
		if(input.files&&input.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				$('#div_inner_img').prop('src',e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	//파일을 업로드하면 함수실행
	$("#fileImage").change(function(){
		readURL(this);
	});
	
	//메뉴 조회
	$("#btnMenuCk").click(function(){
		if($("#name").val() == "" || $("#name").val() == null){
			alert("이름을 입력해주세요");
		}	//이름 추가 alert
		else{
			var query = {
					product_name:$("#name").val()
			};	//query
			$.ajax({
				type:"post",
				url:"/CafeProject/mg/menuSelect.do",
				data:query,
				success:function(data){
					alert("조회하였습니다.");
					window.location.href="/CafeProject/mg/menuMain.do"
				}	//success
			});	//ajax
		}	//else
	});	//select
	
	//메뉴 추가
	$("#btnMenuIs").click(function(){
		if($("#name").val() == "" || $("#name").val() == null){
			alert("이름을 입력해주세요");
		}	//이름 추가 alert
		else if($("#price").val() == "" || $("#price").val() == null){
			alert("가격을 입력해주세요");
		}	//가격 추가 alert
		else if($(".selectGroup option:selected").val() == "" || $(".selectGroup option:selected").val() == null){
			alert("분류를 선택해주세요");
		}	//분류 추가 alert
		else{
			var formData = new FormData();
			formData.append("product_image",$("#fileImage")[0].files[0]);
			formData.append("product_name",$("#name").val());
			formData.append("product_price",$("#price").val());
			formData.append("pgroup_code",$(".selectGroup option:selected").val());
			$.ajax({
				type:'post',
				url:'/CafeProject/mg/menuAdd.do',
				data:formData,
				enctype:'multipart/form-data',
				processData: false,
				contentType: false,
				dataType:'text',
				success: function(data){
					alert("추가하였습니다.");
					window.location.href="/CafeProject/mg/menuMain.do"
				}	//success
			});	//ajax
		}	//else
	});	//추가 버튼
	
	//메뉴 수정
	$("#btnMenuUd").click(function(){
		if($("#name").val() == "" || $("#name").val() == null){
			alert("이름을 입력해주세요");
		}	//이름 추가 alert
		else if($("#price").val() == "" || $("#price").val() == null){
			alert("가격을 입력해주세요");
		}	//가격 추가 alert
		else if($(".selectGroup option:selected").val() == "" || $(".selectGroup option:selected").val() == null){
			alert("분류를 선택해주세요");
		}	//분류 추가 alert
		else{
			var formData = new FormData();
			formData.append("product_image",$("#fileImage")[0].files[0]);
			formData.append("product_number",$("#code").val());
			formData.append("product_name",$("#name").val());
			formData.append("product_price",$("#price").val());
			formData.append("pgroup_code",$(".selectGroup option:selected").val());
			formData.append("backup_image_name",$('#div_inner_img').attr("src"));
			$.ajax({
				type:'post',
				url:'/CafeProject/mg/menuUpdate.do',
				data:formData,
				enctype:'multipart/form-data',
				processData: false,
				contentType: false,
				dataType:'text',
				success: function(data){
					alert("수정하였습니다.");
					window.location.href="/CafeProject/mg/menuMain.do"
				}	//success
			});	//ajax
		}	//else
	});	//추가 버튼
	
	//메뉴 삭제
	$("#btnMenuDl").click(function(){
		if((confirm("삭제하시겠습니까?") == true)){
			var query = {
					product_number:$("#code").val(),
			};	//query
			$.ajax({
				type:"post",
				url:"/CafeProject/mg/menuDelete.do",
				data:query,
				success:function(data){
					alert("삭제하였습니다.");
					window.location.href="/CafeProject/mg/menuMain.do"
				}	//success
			});	//ajax
		}	//if
	});	//delete
});	//document