<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/static/commonTags.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE11" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/> 
		<title>找回密码_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/public.css" />
		<link rel="stylesheet" href="${ctx}/css/login_register.css" />
		<link rel="stylesheet" href="${ctx}/css1000/zhPassword1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/zhPassword750.css" />
		<link rel="stylesheet" type="text/css" media="only screen and (max-width:769px),only screen and (max-device-width:769px)" href="${ctx}/css/800.css"/>
		<script type="text/javascript" src="${ctx}/js/jquery-1.7.2.js" ></script>
		<script type="text/javascript" src="${ctx}/js/jquery.js" ></script>
	</head>
	<body onload="redirector();">
		<!--头部-->
		<div class="login_top">
			<div class="login_bod">
				<img src="img/icon/logo.png" onclick="window.location.href='${ctx}/system/fquerysumway.htm'" />
				<p>已有账号<a href="${ctx}/register.jsp" class="log_reg">注册</a></p>
				<a href="${ctx}/system/fquerysumway.htm" class="log_ind">首页</a>
			</div>
		</div>
		<!-- 找回密码 -->
		<div class="zhp_bod">
		<form id="formPassword" method="post">
			<div class="zhp_pw">
				<h3>找回密码</h3>
				<div class="zhp_b1">
                	<div class="zhp_step">
                    	<dl>
                        	<dt class="hover"><span>1</span></dt>
                        	<dt><span>2</span></dt>
                        </dl>
                    </div>
					<ul>
						<li>
							<p><span>*</span>手机号码</p>
							<input type="text" name="zhPhone" placeholder="请输入您的手机号码" onblur="validatePhone(this)"/>
							<label id="zhPhoneErr" style="display: none;">您输入的手机号码有误！</label>
						</li>
						<li>
							<p><span>*</span>手机验证码</p>
							<input type="text" name="zhYzm" placeholder="请输入手机验证码" class="zhp_yzm" onblur="validateYzm(this)"/>
							<a href="javascript:void(0)" class="zhp_hqm reg_btn_y">获取验证码</a>
							<input type="button" name="" value="60" class="zhp_djs reg_djs" />
							<label id="zhYzmErr" style="display: none;">手机验证码不正确。</label>
							<label id="phoneYzmErr" style="display: none;">获取验证码不能超过10次!</label>
						</li>
						<li>
							<p><span>*</span>新密码</p>
							<input type="password" name="zhNewPassword" placeholder="密码是字母数字或下划线中的两种" onkeyup="verifyPass(this)"/>
							<label id="zhNewPasswordErr" style="display: none;">密码格式不正确</label>
							<!--
                            	作者：xgh_web@126.com
                            	时间：2015-09-09
                            	描述：
                            		以下是默认状态；
                            	     	弱：给".rpb_2"添加".pw_bg"
                            	     	中：给".rpb_2,.rpb_3"添加".pw_bg"
                            	     	强：给".rpb_2,.rpb_3,.rpb_4"添加".pw_bg"
                            -->
							<ul class="zhp_qd">
								<li class="rpb_1">密码强度</li>
									<li class="rpb_2" id="zhNewPasswordLi2"></li>
									<li class="rpb_2" id="zhNewPasswordLi3"></li>
									<li class="rpb_2" id="zhNewPasswordLi4"></li>
									<li class="rpb_3" id="zhNewPasswordLi5"></li>
							</ul>
						</li>
						<li>
							<p><span>*</span>确认密码</p>
							<input type="password" name="zhOkNewPassword" placeholder="同上一致" onblur="equaleToPassword(this)"/>
							<label id="zhOkNewPasswordErr" style="display: none;">新密码与确定密码不一致！</label>
						</li>
						<li>
							<a href="javascript:void(0)" class="zhp_next" >下一步</a>
						</li>
                        <div class="clear"></div>
					</ul>
				</div>
				<div class="zhp_b2">
                	<div class="zhp_step">
                    	<dl>
                        	<dt><span>1</span></dt>
                        	<dt class="hover"><span>2</span></dt>
                        </dl>
                    </div>
					<h1><span><img src="img/pw_d.png"></span>成功找回密码！</h1>
					<p><label>3</label>S后自动跳转到登录页...</p>
					<a href="${ctx}/login/login.htm">登录</a>
				</div>
			</div>
			</form>
		</div>
		<!--三大优势-->
		<div class="log_ys">
			<ul>
				<li class="ys_li1">
					<h3>强大背景</h3>
					<p>实力股东背景雄厚，上市公司倾力打造</p>
				</li>
				<li class="ys_li2">
					<h3>安全保障</h3>
					<p>严格的风控模式，保障客户资金安全</p>
				</li>
				<li class="ys_li3">
					<h3>稳健收益</h3>
					<p>预期年化收益最高可达10%</p>
				</li>
			</ul>
		</div>
		<!--版权所有-->
		<div class="lg_copy">Copyright &copy; 2015   上海学呗互联网金融信息服务有限公司  沪ICP备 15038104号</div>
		<script type="text/javascript">
		//获取验证码
		$(".reg_btn_y").click(function(){
			if($("input[name='zhPhone']").val()!=''&&$("#zhPhoneErr").is(":hidden")){
				/*  */
				$.ajax({
					type : "post",
					url : "message/checkYzm.htm",
					data : {
						userPhone : $("input[name='zhPhone']").val(),
						userPhoneNums:10
					},
					success : function(data) {
						if (data =="err") {
							$("#phoneYzmErr").show();
						}else{
							$("#phoneYzmErr").hide();
							$(".reg_btn_y").hide().next(".reg_djs").show();
							show();
							getPhoneVerify();
						}
					}
				});
			}
			
		});
		//下一步
		$(".zhp_next").click(function(){
			if($("input[name='zhPhone']").val()==''){
				$("#zhPhoneErr").show();
			}else if($("input[name='zhYzm']").val()==''){
				$("#zhYzmErr").show();			
			}else if($("input[name='zhNewPassword']").val()==''){
				$("#zhNewPasswordErr").show();
			}else if($("input[name='zhOkNewPassword']").val()==''){
				$("#zhOkNewPasswordErr").show();
			}
			if($("#zhPhoneErr").is(":hidden")&&$("#zhYzmErr").is(":hidden")&&$("#zhNewPasswordErr").is(":hidden")&&$("#zhOkNewPasswordErr").is(":hidden")){
				$.ajax({
					type : "post",
					url : "login/zhPassword.htm",
					data : $("#formPassword").serialize(),
					dataType : "text",
					success : function(data) {
						if(data=="success"){
							$(".zhp_b1").hide().next().show();
							setTimeout("loadLogin()",3000);
						}
					}
				});
				
			}
			
		})
		function loadLogin(){
			location.href="${ctx}/login/login.htm";
		}
		//获取验证码倒计时
		var set = 60;
		function show() {
			$(".reg_djs").val(set+' s');
			set--;
			if (set == -1) {
				set=60;
				$(".reg_djs").hide().prev(".reg_btn_y").show();
			}else{
				setTimeout("show()",1000);
			}
		}
		function getPhoneVerify() {
			$.ajax({
				type : "post",
				url : "message/sendMessage.htm",
				data : {
					user_phone : $("input[name='zhPhone']").val(),
					messageType:2
				},
				dataType : "json",
				success : function(data) {
				}
			});
		}
		function validatePhone(obj){
			$.ajax({
				type : "post",
				url : "register/checkMoblie.htm",
				data : {
					user_phone : obj.value
				},
				dataType : "text",
				success : function(data) {
					if (data == 2) {	
						$("#zhPhoneErr").show();
					}else{
						$("#zhPhoneErr").hide();
					}
				}
			});
		}
		function validateYzm(obj){
			$.ajax({
				type : "post",
				url : "message/equalToCode.htm",
				data : {
					code : obj.value,
					messageType:2
				},
				dataType : "text",
				success : function(data) {
					if(data=="success"){
						$("#zhYzmErr").hide();
					}else{
						$("#zhYzmErr").show();
					}
				}
			});	
		}
		function verifyPass(obj) {
			var numReg = new RegExp("^[0-9]*$");
			var numEnReg = /^[A-Za-z0-9]+$/;
			if($("input[name='"+obj.name+"']").val()==""){
				$("#"+obj.name+"Li4").removeClass("pw_bg");
				$("#"+obj.name+"Li3").removeClass("pw_bg");
				$("#"+obj.name+"Li2").removeClass("pw_bg");
				$("#"+obj.name+"Li5").text("");
			}else if (numReg.test($("input[name='"+obj.name+"']").val())) {
				$("#"+obj.name+"Li4").removeClass("pw_bg");
				$("#"+obj.name+"Li3").removeClass("pw_bg");
				$("#"+obj.name+"Li2").addClass("pw_bg");
				$("#"+obj.name+"Li5").text("弱");
			} else if (numEnReg.test($("input[name='"+obj.name+"']").val())) {
				$("#"+obj.name+"Li4").removeClass("pw_bg");
				$("#"+obj.name+"Li3").addClass("pw_bg");
				$("#"+obj.name+"Li2").addClass("pw_bg");
				$("#"+obj.name+"Li5").text("中");
			} else {
				$("#"+obj.name+"Li4").addClass("pw_bg");
				$("#"+obj.name+"Li3").addClass("pw_bg");
				$("#"+obj.name+"Li2").addClass("pw_bg");
				$("#"+obj.name+"Li5").text("强");
			}
			if (!/^(?=.*?[a-zA-Z_])(?=.*?[0-9_])[a-zA-Z0-9_]{6,18}$/.test($("input[name='"+obj.name+"']").val())) {
				$("#"+obj.name+"Err").show();
			}else{
				$("#"+obj.name+"Err").hide();
			}
		}
		function equaleToPassword(obj){
			if(obj.value==$("input[name='zhNewPassword']").val()){
				$("#"+obj.name+"Err").hide();
			}else{
				$("#"+obj.name+"Err").show();
			}
		}
		</script>
	</body>
</html>