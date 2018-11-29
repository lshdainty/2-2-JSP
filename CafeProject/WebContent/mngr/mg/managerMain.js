var status=true;

$(document).ready(function(){
	$("#registProduct").click(function(){	//상품등록 버튼클릭할때
		window.location.href="/shoppingmall/mg/bookRegisterForm.do";
	});	//registProduct
	
	$("#updateProduct").click(function(){	//상품수정 삭제 버튼 클릭할때
		window.location.href="/shoppingmall/mg/bookList.do?book_kind=all";
	});	//updateProduct
	
	$("#orderedProduct").click(function(){	//전체 구매목록 확인버튼 클릭할때
		window.location.href="/shoppingmall/mg/orderList.do";
	});	//orderedProduct
	
	$("#qna").click(function(){	//상품 qna답변 버튼 클릭할때
		window.location.href="/shoppingmall/mg/qnaList.do";
	});	//qna
});	//document