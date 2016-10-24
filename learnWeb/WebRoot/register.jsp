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
<title>学呗_学呗互联网金融</title>
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/login_register.css" />
<link rel="stylesheet" href="css1000/register1000.css" />
<link rel="stylesheet" href="css750/register750.css" />
<link rel="stylesheet" type="text/css" media="only screen and (max-width:769px),only screen and (max-device-width:769px)" href="css/800.css"/>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/self-method.js"></script>
<script type="text/javascript" src="js/self-index.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<!--头部-->
	<div class="login_top">
		<div class="login_bod">
			<div onclick="window.location.href='${ctx}/system/fquerysumway.htm'"></div>
			<p>
				已有账号<a href="${ctx}/login/login.htm" class="log_reg">登录</a>
			</p>
			<a href="${ctx}/system/fquerysumway.htm" class="log_ind">首页</a>
		</div>
	</div>
	<!--用户登录-->
	<form name="register"  method="post">
		<input type="hidden" id="nextFlag" value="1"/>
		<div class="register_bod">
			<div class="register">
				<div class="reg_main">
					<p class="reg_title">
						<label>用户注册</label>
					</p>
					<ul class="reg_ti_list"><li class="reg_t1 reg_tit_bg"><span>1</span>填写信息</li>
						<!--<li class="reg_t2"><span>2</span>设置用户名</li>-->
						<li class="reg_t3"><span>2</span>完成</li>
					</ul>
					<!--
                    	作者：xgh_web@126.com
                    	时间：2015-09-08
                    	描述：信息不正确，给input添加class:'reg_inp_erro'
                    -->
					<!--填写信息-->
					<div class="reg_bz reg_1">
						<ul>
							<li><label>手机号</label> <input type="text" class="reg_inp_1"
								name="user_phone" id="user_phone" onblur="checkMobile()" />
								<p id="user_phone-show">请输入有效的手机号码！</p>
								<p id="user_phone-login">
									该号码已被注册，是否<a href="${ctx}/login/login.htm">登录</a>
								</p>
							</li>
							<li >
								<label>设置登录密码</label> <input
								type="password" class="reg_inp_1" onblur="verifyPass(this)"
								id="user_pass" name="user_pass" placeholder="数字、字母、下划线中任意2种"/>
								<p id="user_pass_show">登录密码格式不正确</p>
							</li>		
							<li>
								<label>验证码</label>
								<input type="text" id="kaptcha" name="kaptcha"  class="reg_inp_2"  onblur="kaptchas()"/>
								<div class="reg_yzm"><img src="/captcha-image" id="kaptchaImage"></div>
								<a href="javascript:void(0)" class="reg_sx" onclick="flushYzm()"></a><p id="yzm">验证码不匹配</p>
							</li>
							<li >
								<label>手机验证码</label>  <input type="text"
								class="reg_inp_2" id="phone_ver_no" name="phone_ver_no"
								onblur="phoneVerNo(this)" /> <input type="button" value="获取验证码"
								class="reg_btn_y" id="get_phone_ver"  />
								<input type="button" value="60" class="reg_djs" id="regdjs" />
								<p id="phoneYzm">手机验证码不正确</p><p id="phoneYzmNum">获取验证码不能超过5次!</p>
							</li>
							<li><label>推荐人手机号</label><input type="text" placeholder="选填"
								class="reg_inp_3" name="recommender" onblur="validatePhone(this)"/>
								<p id="phoneErr">不是平台用户</p></li>
							<li class="reg_btn_check">
								<div class="chec_xy"></div>我已阅读并同意<a href="${ctx}/registerxy.jsp#reg_d1" target="target">《学呗网站声明》</a>和<a href="${ctx}/registerxy.jsp#reg_d2" target="target">《学呗网服务协议》</a>
							</li>
							<li class="reg_btn_next">
								<div id="rb_no_next" class="rb_no">下一步</div>
								<a href="javascript:void(0)" >下一步</a>
							</li>
						</ul>
					</div>
					<!--完成-->
					<div class="reg_bz reg_3">
						<h3>恭喜您注册成功！<br /></h3>
						<p class="reg_img"><img src="img/reg_im_1.png" /><a href="${ctx}/system/fquerysumway.htm">先去逛逛&nbsp;&gt;</a></p>
						<p><img src="img/reg_im_2.png" /><a href="${ctx}/person/editPerson.htm">继续完善用户信息&nbsp;&gt;</a></p>
					</div>
				</div>
			</div>
		</div>
	</form>
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
		$(function(){
			var phones=window.location.search;
			if(phones!=""){
				phones=phones.substring(7);
				$("input[name='recommender']").val(phones);
				$("input[name='recommender']").attr('readonly','readonly');
			}
		})
	</script>
</body>
</html>
