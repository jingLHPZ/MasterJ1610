$(function($){
	
	//top导航栏720
	var navNode = $("#zb_nav .list_nav");
	$("#zb_nav .list-btn").bind("click",function(){
		if(navNode.hasClass("open_phone_nav")){
			navNode.removeClass("open_phone_nav");
		}else{
			navNode.addClass("open_phone_nav");
		}
	});
	
	if($(".left_menu #left_menu").length > 0){
		//console.log("加载个人中心手机端菜单逻辑");
		//弹出箭头
		var arrowNode = document.createElement("div");
		var maskNode = document.createElement("div");
		$("body").append($(arrowNode).addClass("arrow_right"));
		$("body").append($(maskNode).addClass("menu_mask"));
		$(".arrow_right").bind("click",function(){
			$(".menu_mask").show();
			$(".content_body .menu_bod").addClass("menu_active");
		});
		$(".menu_mask").bind("click",function(){
			$(this).hide();
			$(".content_body .menu_bod").removeClass("menu_active");
		});
		
		//阻止父级滚动
		
		if(BASE.supportCss3()){
			document.querySelector(".content_body .menu_bod").addEventListener("DOMMouseScroll",function(){
				e.stopPropagation();
				e.preventDefault();
			})
		};
	};
	
	
	
});