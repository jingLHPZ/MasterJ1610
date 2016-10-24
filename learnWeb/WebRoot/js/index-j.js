/**
 * index页面js
 */
var flag;
$(document).ready(function() {
	flag=0;
	document.onkeydown=function(event){
        var e = event || window.event || arguments.callee.caller.arguments[0];         
         if(e && e.keyCode==13){ 
        	 loginSub();
         }
    }; 

});

function loginSub() {
	if($("#user_phone").val()==""){
		$("#abc").show();
		$("#abc").text("请输入您的用户名");
		return false;
	}
	if($("#user_pass").val()==""){
		$("#abc").show();
		$("#abc").text("请输入您的密码");
		return false;
	}
	if($(".yzm").css("display")=="block"){
		kaptcha();
	}
	if(flag==1){
		return false;
	}
	$.ajax({
		type : "post",
		url : "/login/loginSub.htm",
		data : {
			user_phone : $("#user_phone").val(),
			user_pass : $("#user_pass").val()
		},
		dataType : "json",
		success : function(data) {
			if (data.tag == 1) {
				$("#abc").show();
				$("#abc").text("用户名或密码错误");
				if(data.loginErrCount>3){
					$(".yzm").css("display", "block");
				}
				flushYzms();
			} else if (data.tag == 2) {
				$("#abc").hide();
				location.href="/system/fquerysumway.htm";
			}else if (data.tag == 3) {
				$("#abc").show();
				$("#abc").html("您的学呗账号已冻结<br/>请致电客服：4001-199-399");
			}
		}
	});
}

function kaptcha() {
	$.ajax({
		type : "post",
		url : "/login/kaptchaVer.htm",
		data : {
			kaptcha : $("#kaptcha").val()
		},
		async:false,
		dataType : "text",
		success : function(data) {
			if (data == 0) {
				flag=1;
				$("#abc").show();
				$("#abc").text("验证码错误");
			}else{
				flag=0;
				$("#abc").hide();
			}
		}
	});
}
function flushYzms() {
	$("#kaptchaImage").hide().attr('src','/captcha-image.htm?'+ Math.floor(Math.random() * 100)).fadeIn();
}

function isMobile(mobile){
    var reg = /^((14[5,7])|(17[0,1,6-8])|(13[0-9])|(15[0-3,5-9])|(18[0-3,5-9]))\d{8}$/;
    return reg.test(mobile);
}
