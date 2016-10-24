<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE11" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<title>学呗_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/public.css" />
		<link rel="stylesheet" href="${ctx}/css/login_register.css" />
		<link rel="stylesheet" href="${ctx}/css1000/login1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/login750.css" />
		<link rel="stylesheet" type="text/css" media="only screen and (max-width:769px),only screen and (max-device-width:769px)" href="${ctx}/css/800.css"/>
		<script type="text/javascript" src="${ctx}/js/jquery-1.7.2.js" ></script>
		<script type="text/javascript" src="${ctx}/js/method.js" ></script>
		<script type="text/javascript" src="${ctx}/js/jquery.js" ></script>
		<script type="text/javascript" src="${ctx}/js/jquery.cookie.js" ></script>
	</head>
	
	<body>
		<!--头部-->
		<div class="login_top">
			<div class="login_bod">
				<div onclick="window.location.href='${ctx}/system/fquerysumway.htm'"></div>
				<p>已有账号<a href="${ctx}/register.jsp" class="log_reg">注册</a></p>
				<a href="${ctx}/system/fquerysumway.htm" class="log_ind">首页</a>
			</div>
		</div>
		<!--用户登录-->
		<div class="login_from">
			<div class="lf_bod">
				<ul>
					<li class="lf_tit" ><h3>用户登录</h3></li>
					<li class="lf_alert" id="abc">
					<p>用户名或密码错误</p>
					<input type="hidden" id="isYzm"/>
					</li>
					<li><input type="text" name="user_phone" id="user_phone" class="uname" placeholder="用户名/手机号"/></li>
					<li><input type="password" name="user_pass" id="user_pass" class="pwd"  placeholder="密码"/></li>
					<li class="yzmStyle" style="display: none;">
						<input type="text" id="kaptcha" name="kaptcha"  class="yzm" placeholder="验证码"/>
						<p class="yzm_img"><img src="${ctx}/captcha-image.htm" id="kaptchaImage"></p>
						<a href="javascript:void(0)" class="sx_yzm" onclick="flushYzm()"></a>
					</li>
					<li class="operation">
						<div class="chec_login"></div>记住我
						<div class="cont_r">
							<a href="${ctx}/zhPassword.jsp" class="pwd_wj">找回密码</a>
							<i></i>
							<a class="go_regist" href="${ctx}/register.jsp">注册</a>
						</div>
					</li>
					<li class="btn">
					 <input type="button" name="btn" value="立即登录" onclick="loginSub()"/>
					 <input type="hidden" value="${view}" id="view">
					</li>
				</ul>
			</div>
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
		<div class="lg_copy">Copyright &copy; 2015   上海学呗互联网金融信息服务有限公司  沪ICP备 15038104号
			<script type="text/javascript">
				var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1256850438'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/z_stat.php%3Fid%3D1256850438%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));
			</script>
		</div>
		
		<script type="text/javascript">
		var flag;
		$(function() {
			//生成验证码
			flag=0;
			flushYzm();
			document.onkeydown=function(event){
		        var e = event || window.event || arguments.callee.caller.arguments[0];         
		         if(e && e.keyCode==13){ 
		        	 loginSub();
		         }
		    }; 
		   //判断之前是否有设置cookie，如果有，则设置【记住我】选择框  
		    if($.cookie('login_userName')!=undefined){  
		    	$(".chec_login").addClass("active");
		    	  $('#user_phone').val($.cookie('login_userName'));  
		    }else{  
		    	$(".chec_login").removeClass("active");
		    }  
		    //监听【记住我】事件  
			$(".chec_login").toggle(
				function(){
					$(this).addClass("active");
				},
				function(){
					$(this).removeClass("active");
				}
			)
		});
		function flushYzm() {
			$("#kaptchaImage").hide().attr('src','${ctx}/captcha-image.htm?'+ Math.floor(Math.random() * 100)).fadeIn();
		}
		function kaptchas() {
			$.ajax({
				type : "post",
				url : "${ctx}/login/kaptchaVer.htm",
				data : {
					kaptcha : $("#kaptcha").val()
				},
				async:false,
				dataType : "text",
				success : function(data) {
					if (data == 0) {
						flag=1;
						$("#abc p").show().html("验证码错误");
					}else{
						flag=0;
						$("#abc p").hide().html("");
					}
				}
			});
		}
		function loginSub() {
			/* var mail = '${mail}';
			var time = '${time}';
			var user = '${user}'; */
			if($("#user_phone").val()==""){
				$("#abc p").show().html("请输入您的用户名");
				return false;
			}
			if($("#user_pass").val()==""){
				$("#abc p").show().html("请输入您的密码");
				return false;
			}
			if($(".yzmStyle").css("display")=="block"){
				kaptchas();
			}
			if(flag==1){
				return false;
			}
			
			var result = '';
			$.ajax({
				type : "post",
				url : "${ctx}/login/loginSub.htm",
				data : {
					user_phone : $("#user_phone").val(),
					user_pass : $("#user_pass").val(),
					view : $("#view").val()
				},
				dataType : "json",
				async: false,
				success : function(data) {
					result = data;
				}
			});
			
			if (result.tag == 1) {
				$("#abc p").show().html("用户名或密码错误");
				if(result.loginErrCount>3){
					$(".yzmStyle").css("display", "block");
				}
				flushYzm();
			}else if (result.tag == 3) {
				$("#abc p").show().html("您的学呗账号已冻结!请致电客服：4001-199-399");
			}else{
				if($(".chec_login").hasClass("active")){
					 $.cookie('login_userName', $('#user_phone').val(),{ expires: 7 });  
				}else{
					 $.removeCookie('login_userName');  
				}
				/* if(mail != null && '' != mail) {
					location.href="${ctx}/person/mailVerify.htm?user="+user+"&time="+time+"&mail="+mail;
					return;
				} */
				if(result.view!=""){
					if(document.referrer!="" && document.referrer.indexOf("logout") == -1){
						self.location=document.referrer;
						return;
					}
					location.href="${ctx}/system/fquerysumway.htm";
					return false;
				}
				location.href="${ctx}/system/fquerysumway.htm";
			}
		}
		</script>
	</body>
</html>
