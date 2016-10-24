$(document).ready(function(e){
	var browserWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
	if(browserWidth<=1200){
    $(".login_bod").children("img").attr("src","img/logo1.png");
    $("#zb_nav").children(".logo_img").attr("src","img/logo1.png");
	}
    $(".list_nav").addClass("list_more");
	$(".zh_more").click(function(){
		$(".list_more").slideToggle();
	})
});
