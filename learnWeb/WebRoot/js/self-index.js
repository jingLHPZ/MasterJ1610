function submit() {
	$("#login_btn").submit(function(e) {
	});
}
function validatePhone(obj){
	if(obj.value!=''){
		$.ajax({
			type : "post",
			url : "/learnWeb/register/checkMoblie.htm",
			data : {
				user_phone : obj.value
			},
			success : function(data) {
				if(data=="2"){
					$("#phoneErr").show();
				}else{
					$("#phoneErr").hide();
				}
			}
		});
	}else{
		$("#phoneErr").hide();
	}
	
}
function isStringBlank(str) {
	var arr = new Array();
	arr = str.split(" ");
	if (arr.length != 1) {
		$("#user_phone-show").show();
		return false;
	}
}

function checkMobile() {
	nextCheck();
	if ($("#user_phone").val().length == 0) {
		$("#user_phone-show").show();
		$("#user_phone").addClass("reg_inp_erro");
		$("#user_phone-show").show();
		// return false;
	}

	if ($("#user_phone").val().length != 0) {
		isStringBlank($("#user_phone").val());
	}

	if ($("#user_phone").val().length != 11) {
		$("#user_phone").addClass("reg_inp_erro");
		$("#user_phone-show").show();
		// return false;
	}

	var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	if (!myreg.test($("#user_phone").val())) {
		$("#user_phone").addClass("reg_inp_erro");
		$("#user_phone-show").show();
		// return false;
	} else {
		$("#user_phone").removeClass("reg_inp_erro");
		$("#user_phone-show").hide();
	}
	if ($("#user_phone").val().length != 0) {
		$.ajax({
			type : "post",
			url : "/learnWeb/register/checkMoblie.htm",
			data : {
				user_phone : $("#user_phone").val()
			},
			dataType : "text",
			success : function(data) {
				if (data == 1) {
					$("#user_phone").addClass("reg_inp_erro");
					$("#user_phone-login").show();
				}else{
					$("#user_phone-login").hide();
				}
			}
		});
		return false;
	}
}

function verifyPass(obj) {
	  nextCheck();
	  var pwd=obj.value;
	  if (pwd==""||!/^(?=.*?[a-zA-Z_])(?=.*?[0-9_])[a-zA-Z0-9_]{6,18}$/.test(pwd)) {
			$("#user_pass_show").show()
		}else{
				$("#user_pass_show").hide();
		}
}

function verifyPass2() {
	nextCheck();
	if ($("#user_pass2").val().length == 0) {
		$("#user_pass2").addClass("reg_inp_erro");
		$("#user_pass2_show").show();
		return false;
	}
	if ($("#user_pass").val() == $("#user_pass2").val()) {
		$("#user_pass2").removeClass("reg_inp_erro");
		$("#user_pass2_show").hide();
		return false;
	}
	if ($("#user_pass").val() != $("#user_pass2").val()) {
		$("#user_pass2").addClass("reg_inp_erro");
		$("#user_pass2_show").show();
	}

}
//获取验证码倒计时
var set = 60;
function show() {
	if ($("#user_phone").val().length != 0&&$("#user_phone-show").is(":hidden")&&$("#user_phone-login").is(":hidden")&&$("#kaptcha").val().length!=0&&$("#yzm").is(":hidden")) {
		$(".reg_djs").val(set + ' s');
		set--;
		if (set == -1) {
			set = 60;
			$(".reg_djs").hide().prev(".reg_btn_y").show();
		} else {
			setTimeout("show()", 1000);
		}
		
	}else{
		$(".reg_btn_y").show().next().hide();
	}
}
function validateShow(){
	$.ajax({
		type : "post",
		url : "/learnWeb/message/checkYzm.htm",
		data : {
			userPhone : $("#user_phone").val()
		},
		success : function(data) {
			if (data =="err") {
				$(".reg_djs").hide().prev(".reg_btn_y").show();
				$("#phoneYzmNum").show();
				$("#phoneYzm").hide();
			}else{
				show();
				getPhoneVerify();
			}
		}
	});
}
function getPhoneVerify() {
	if ($("#user_phone").val().length != 0&&$("#user_phone-show").is(":hidden")&&$("#user_phone-login").is(":hidden")&&$("#kaptcha").val().length&&$("#yzm").is(":hidden")) {
		$.ajax({
			type : "post",
			url : "/learnWeb/message/sendMessage.htm",
			data : {
				user_phone : $("#user_phone").val(),
				messageType:1
			},
			dataType : "json",
			success : function(data) {

			}
		});
	} 
}

function phoneVerNo(obj) {
	nextCheck();
}
function submitRegister(obj){
	$.ajax({
		type : "post",
		url : "/learnWeb/register/checkName.htm",
		data : {
			user_name : obj.value
		},
		success : function(data) {
			if (data =="err") {
				$("#errUserName").show();
				$("#errUserName").html("用户名已被占用");
			}else{
				$("#errUserName").hide();
			}
		}
	});
}
$(function() {//生成验证码
	flushYzm();
});
function flushYzm() {
	$("#kaptchaImage").hide().attr('src','/learnWeb/captcha-image.htm?'+ Math.floor(Math.random() * 100)).fadeIn();
}
function kaptchas() {
	nextCheck();
	$.ajax({
		type : "post",
		url : "/learnWeb/login/kaptchaVer.htm",
		data : {
			kaptcha : $("#kaptcha").val()
		},
		async:false,
		dataType : "text",
		success : function(data) {
			if (data == 0) {
				$("#yzm").show();
			}else{
				$("#yzm").hide();
			}
		}
	});
}
function nextCheck(){
	if($("#nextFlag").val()==1){
		if($("input[name='user_phone']").val().length==0||
				$("input[name='kaptcha']").val().length==0||
				$("input[name='phone_ver_no']").val().length==0||
				$("input[name='user_pass']").val().length==0)
		{
			$(".rb_no").show().next().hide();
		}else{
			$(".rb_no").hide().next().show();
		}
	}
}