<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<div class="zhjy_pass" style="display: none;">
	<div class="zhjy_body">
		<h2>找回交易密码</h2>
		<ul>
			<li class="zhjy_phone">
				<label>手机号：</label>
				<h4 id="userPhone"></h4>
				<div class="yzm_hq" onclick="getCode();">获取验证码</div>
				<div class="yzm_djs">60S</div>
			</li>
			<li>
				<label>验证码：</label>
				<input type="text" id="phoneCode" placeholder="请输入手机验证码">
			</li>
			<li>
				<label>新密码：</label>
				<input type="password" id="newPwd" placeholder="密码只能是6位数字">
			</li>
			<li>
				<label>确认新密码：</label>
				<input type="password" id="confirmNewPwd" placeholder="同上一致">
			</li>
			<li>
				<label></label>
				<input type="button" value="确认" onclick="updateTradePwd();" class="zhjy_btn_1">
				<input type="button" value="取消" onclick="closeDiv();" class="zhjy_btn_2">
			</li>
		</ul>
	</div>
</div>

<script type="text/javascript">
	$.ajaxSettings.async = false;
	
	var set = 60;
	var t = null;
	function showTime() {
		$(".yzm_hq").hide();
		$(".yzm_djs").text(set+' s').show();
		set--;
		if (set == -1) {
			set = 60;
			$(".yzm_djs").hide().prev(".yzm_hq").show();
		} else {
			t = setTimeout(function(){
				showTime();
	        }, 1000);
		}
	}
	
	//	发送短信验证码
	function getCode() {
		var phone='${localUser.userPhone}';
		if (phone == '') {
			alert("手机号不能为空，请绑定手机号！"); return ;
		}
		showTime();
		$.post("message/checkYzm.htm", {"userPhone" : phone}, function (data) {
			if (data =="err") {
				alert("只能获取验证码5次！");
			}
		});
		
		$.post("/message/sendMessage.htm", {"user_phone" : phone, "messageType" : 3}, null);
	}
	
	function closeDiv() {
		$(".yzm_hq").show();
		$(".yzm_djs").text(60+' s').hide();
		
		if (t != null) {
			clearTimeout(t);
		}
		$(".zhjy_pass").hide();
	}
	
	function openDiv() {
		$(".zhjy_pass").show();
	}
	
	//	更新密码
	function updateTradePwd() {
		var phoneCode = $("#phoneCode").val();
		var newPwd = $("#newPwd").val();
		var confirmNewPwd = $("#confirmNewPwd").val();
		
		if (phoneCode == '') {
			alert("请输入手机验证码！"); return ;
		} else if (newPwd == '') {
			alert("请输入新密码！"); return ;
		} else if (confirmNewPwd == '') {
			alert("请输入确认密码！"); return ;
		} else if (newPwd != confirmNewPwd) {
			alert("两次输入的密码不一致！"); return ;
		} else {
			var flag = false;
			$.post("/message/equalToCode.htm", {"code":phoneCode, "messageType":3}, function(data) {
				if (data == 'err') {
					alert("手机验证码输入不正确！");
				} else {
					flag = true;
				}
			},"text");
			
			if (flag) {
				$.post("/person/submitPay.htm", {"payNewPass":newPwd}, function(data) {
					if (data == null) {
						alert("交易密码修改失败，请联系管理员！");
					} else {
						closeDiv();
						alert("交易密码修改成功！");
					}
				});
			}
		}
	}
	$(function(){
		var phone='${localUser.userPhone}';
		var str=phone.substring(0,3)+"*****"+phone.substring(8);
		$("#userPhone").html(str);
	})
</script>
