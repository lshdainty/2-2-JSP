$(document).ready(function(){
	$("#logout").click(function(){
		$.ajax({
			type:"post",
			url:"/CafeProject/cm/customerLogout.cu",
			success:function(data){
				window.location.href="/CafeProject/cm/customerLoginForm.cu";
			}
		});	//ajax
	});	//logout
	
	//menu
	$("ul li").click(function(e) {
		  if ($(this).hasClass('slider')) {
		    return;
		  }
		  var whatTab = $(this).index();
		  if(whatTab==0){
			  $("#pay").css("display","block");
			  $("#point").css("display","none");
		  }
		  else if(whatTab==1){
			  $("#pay").css("display","none");
			  $("#point").css("display","block");
		  }
		  var howFar = 370 * whatTab;
		  $(".slider").css({left: howFar + "px"});
		  $(".ripple").remove();
		  var posX = $(this).offset().left,
		      posY = $(this).offset().top,
		      buttonWidth = $(this).width(),
		      buttonHeight = $(this).height();
		  $(this).prepend("<span class='ripple'></span>");
		  if (buttonWidth >= buttonHeight) {
		    buttonHeight = buttonWidth;
		  } else {
		    buttonWidth = buttonHeight;
		  }
		  var x = e.pageX - posX - buttonWidth / 2;
		  var y = e.pageY - posY - buttonHeight / 2;
		  $(".ripple").css({
		    width: buttonWidth,
		    height: buttonHeight,
		    top: y + 'px',
		    left: x + 'px'
		  }).addClass("rippleEffect");
	});	//effect
});	//document