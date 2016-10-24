<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>个人资料_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/personal.css" />
		<link rel="stylesheet" href="${ctx}/css1000/mediaPublic.css" />
		<link rel="stylesheet" href="${ctx}/css1000/personal1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/personal750.css" />
		<link rel="stylesheet" href="${ctx}/css720/personal720.css" />
		<script src="${ctx}/js/Area.js" type="text/javascript"></script>
		<script src="${ctx}/js/AreaData_min.js" type="text/javascript"></script>
		<script src="${ctx}/js/validateCard.js" type="text/javascript"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.js" ></script>
		<%@ include file="/static/top.jsp" %>
	</head>
	<body>
		<div class="content_body">
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/left_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="right_main">
				<div class="person_tab">
					<a href="javascript:void(0)" class="per_tab_hov" onclick="openTabBasic()">基本资料</a>
					<a href="javascript:void(0)" id="setRealName" onclick="openReal()">实名认证</a>
					<a href="javascript:void(0)" onclick="openTabHead()">头像设置</a>
					<a href="javascript:void(0)" id='setPass' >密码设置</a>
				</div>
				<!--密码修改成功提示-->
					<div class="password_alert" >
						<div class="ps_al_bod">
							<h1>您已<span class="allchange"></span>!</h1>
							<p>2S&nbsp;后自动返回...</p>
						</div>
					</div>
				<!--基本资料-->
				<div class="per_bod pesa_1">
				
				<form id="formBasic" method="post">
				<input type="hidden" id="headFlag" value="${headFlag}"/>
					<ul>
						<li>
							<label><span>*</span>用户名：</label>
							<!-- <div class="pb_div" id="user_name">1845121857</div> -->
							<input type="text" id="user_name" name="user_name"  />
							<a class="edit_name" href="javaScript://" style="display: none;">修改</a>
						</li>
						<li>
							<label><span>*</span>手机号码：</label>
							<input type="text" id="user_phone" disabled="disabled"/>
							<p>修改手机号请联系客服</p>
						</li>
						<li>
							<label>邮箱：</label>
							<!--未验证过邮箱的状态-->
							<div class="email_yz">
								<input type="button" name="" value="验证邮箱" />
							</div>
							<!--验证过邮箱的状态-->
							<div class="email_end">
								<div>${usermail}</div>
								<a href="javascript:updateMail();" >修改</a>
							</div>
							<!-- <input type="text" name="user_email" onblur="validateEmail(this)"/>
							<p style="color: red;display: none;" id="emailErr">邮箱格式错误</p> -->
						<!-- 	<p>保存后您会收到一份Email认证邮件，请注意查收并认证</p> -->
						</li>
						<li>
							<label>常用QQ：</label>
							<input type="text" name="qq" onblur="validateQQ(this)"/>
							<p style="color: red;display: none;" id="qqErr">QQ号码格式错误</p>
						</li>
						<li>
							<label>现居住地：</label>
							<select  id="seachprov"  onChange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');">

							</select>
							<select id="seachcity"  onChange="changeCity(this.value,'seachdistrict','seachdistrict');">

							</select>
							<span id="seachdistrict_div"><select id="seachdistrict" ></select></span>
							<input type="hidden" name="province"/>
							<input type="hidden" name="city"/>
							<input type="hidden" name="area"/>
						</li>
						<li>
							<label>详细住地：</label>
							<input type="text" name="address" class="per_zt" />
							<p>XX市/县 XX区/乡镇 XX街道 XX路XX号XX室</p>
						</li>
						<li>
							<label>紧急联系人：</label>
							<input type="text" name="contact1" />
							<p>在紧急情况下，能够联系到与当事人相关的人。</p>
						</li>
						<li>
							<label>电话：</label>
							<input type="text" name="contact1Tel" />
						</li>
						<li>
							<label>与联系人关系：</label>
							<select name="contact1Re" id="contact1Re">
								<option value="">请选择</option>
								<option value="1">家庭成员</option>
								<option value="2">朋友</option>
								<option value="3">商业伙伴 </option>
							</select>
						</li>
						<li class="per_bc_btn"><a href="javascript:void(0)" onclick="saveBasic()">保存</a></li>
					</ul>
					</form>
				<!--验证邮箱-->
					<div class="yz_email">
						<h1>验证邮箱</h1>
						<!--身份验证-->
						<ul class="yz_bod1 bod1_block">
							<li>
								<label>已绑定手机号：</label>
								<p></p>
							</li>
							<li>
								<label>图形验证码：</label>
								<input type="text" name="" class="yz_text" id="kaptcha" onblur="kaptchas();"/>
								<span class="lo_list_alert" id="yzm"></span>
								<div class="yz_img" onclick="flushYzm()"><img src="${ctx}/captcha-image.htm" class="kaptchaImage" ></div>
								<a class="reg_sx" href="javascript:flushYzm();"></a>
								<h4>图形验证码不正确</h4>
							</li>
							<li>
								<label>短信验证码：</label>
								<input type="text" class="yz_text" id="messageVeri" onblur="phoneVerNo(this)">
								<input type="button" name="" value="发送短信" class="yz_but">
								<div class="yz_djs" style="display:none;">60 S</div>
								<p id="phoneYzm" style="display:none;color:red">手机验证码不正确</p><p id="phoneYzmNum" style="display:none;color:red">发送验证码已超过十次!</p>
								<h4>短信验证码不正确</h4>
							</li>
							<li>
								<input type="button" name="" value="提交" class="yz_subm" />
							</li>
						</ul>
						<!--提交邮箱-->
						<ul class="yz_bod1">
							<li>
								<label>我的邮箱：</label>
								<input type="text" name="" class="yz_text email_text" onblur="emailCheck(this.value);"/>
								<span id="myemail"></span>
							</li>
							<li>
								<label>图形验证码：</label>
								<input type="text" name="" class="yz_text" id="kaptcha1" onblur="kaptchas1();"/>
								<span class="lo_list_alert" id="yzm1"></span>
								<div class="yz_img" onclick="flushYzm()"><img src="${ctx}/captcha-image.htm" class="kaptchaImage" ></div>
								<a class="reg_sx" href="javascript:flushYzm();"></a>
								<h4>图形验证码不正确</h4>
							</li>
							<li>
								<input type="button" name="" value="提交" class="yz_subm" id="mailsub"/>
							</li>
							<!--提交之后提示发送邮件-->
							<li class="email_href">
								<b>已发送邮件至：<span></span></b>
								<p>验证邮件24小时内有效，请尽快登录您的邮箱<a href="javascript:toMailLogin();"></a>，点击验证链接完成验证</p>
							</li>
						</ul>
						<!--验证结果-->
						<ul class="yz_bod1">
							<!--验证成功-->
							<li class="email_cg">
								<b>恭喜您，邮箱验证成功！</b>
								<p>最新安全等级</p>
								<div class="email_leve"><div></div></div>
							</li>
							<!--验证失败-->
							<li class="email_sb">
								<b>抱歉，验证失败，可能原因如下：</b>
								<p>
									1、您的邮箱验证超时。请在发送验证邮件后的24小时内，进入邮箱点击验证链接。<br />
									2、您已点击过此链接，链接已失效。
								</p>
							</li>
							<li>
								<input type="button" name="" value="我知道了" class="yz_subm yz_mb" onclick="iknow()"/>
							</li>
						</ul>
					</div>
				</div>
				<!--实名认证-->
				<div class="per_bod smrz_zl">
					<form id="formRealName" method="post">
					<ul>
						<li>
							<label></label>
							<a class="open_certifie_gat" href="javascript://">港澳臺居民請點擊這裡＞＞</a>
						</li>
						<li id="rzErr" style="display: none;">
							<label></label>
							<p id="rzP" style="display: block;">身份证号和姓名不符</p>
						</li>
						<li>
							<label>姓名：</label>
							<input type="text" name="realName" onblur="validateRealName(this)"/>
							<p id="realNameErr">请输入中文</p>
						</li>
						<li>
							<label>身份证号：</label>
							<input type="text" name="idcard" onblur="validateIdcard(this)"/>
							<p id="idcardErr">身份证格式不对</p>
						</li>
						<li class="per_bc_btn" ><a href="javascript:void(0)" onclick="submitRealName()" id="realA">确认</a></li>
					</ul>
					</form>
				</div>
				<!--头像设置-->
				<div class="per_bod">
				<form id="formUpload" method="post" enctype="multipart/form-data" >
					<div class="pic_tx">
						<img src="${ctx}/img/icon/superman.gif" id="personImg">
					</div>
					<p class="pic_error" style="display:none;"><label>格式或者大小不正确</label></p>
					<p class="pic_alert">图片格式：jpg、gif、png、bmp（1M以内）</p>
					<a href="javascript:void(0)" class="pic_sc_btn"><input type="file" name="file" id="file" value="本地上传" onchange="uploadFile(this)"/>本地上传</a>
				</form>
				</div>
				<!--密码设置-->
				<div class="per_bod pesa_3">
					
					<!--修改密码-->
					<div class="per_password">
						<p class="pass_tit">修改登录密码</p>
						<c:choose>
							<c:when test="${empty sessionScope.localUser.payPass}">
								 <p>设置交易密码</p>
							</c:when>
							<c:otherwise>
								 <p>修改交易密码</p>
							</c:otherwise>
						</c:choose>
						<c:if test="${not empty sessionScope.localUser.payPass}">
							<p id="findPayPass">找回交易密码</p>
						</c:if>
					</div>
					<!--登录密码重置-->
					<form id="formLogin" method="post">
					<div class="end_pass ep_show">
						<h3>登录密码重置</h3>
						<ul>
							
							<li>
								<label>原密码：</label>
								<input style="width:250px;" type="password" name="loginPass" placeholder="请输入原密码" onblur="validatePass(this)"/>
								<p id="loginPassErr">原密码不正确！</p>
							</li>
							
							<li class="per_pass_qd">
								<label>新密码：</label>
								<input style="width:250px;" type="password" name="loginNewPass" placeholder="密码至少含数字、字母、下划线中的2种！" onkeyup="verifyPass(this)"/>
								<p style="display:block;">&nbsp;</p>
								<p id="loginNewPassErr" >密码格式不正确</p>
								<!--
	                        	作者：xgh_web@126.com
	                        	时间：2015-10-04
	                        	描述：
	                        		以下是默认状态；
	                        	     	弱：给".rpb_2"添加".pw_bg"
	                        	     	中：给".rpb_2,.rpb_3"添加".pw_bg"
	                        	     	强：给".rpb_2,.rpb_3,.rpb_4"添加".pw_bg"
	                            -->
								<ul >
									<li class="rpb_1">密码强度</li>
									<li class="rpb_2" id="loginNewPassLi2"></li>
									<li class="rpb_2" id="loginNewPassLi3"></li>
									<li class="rpb_2" id="loginNewPassLi4"></li>
									<li class="rpb_3" id="loginNewPassLi5"></li>
								</ul>
							</li>
							<li>
								<label>确认新密码：</label>
								<input style="width:250px;" type="password" name="loginYesPass" placeholder="同上一致" onblur="validateYesPass(this)"/>
								<p id="loginYesPassErr">两次密码输入不一致！</p>
							</li>
							<li class="per_bc_btn"><a href="#" onclick="submitLogin()">确认</a></li>
						</ul>
						
					</div>
					</form>
					<!--修改交易密码-->
					<form id="formPay" method="post">
					<div class="end_pass">
						<h3>交易密码重置</h3>
						<ul>
						<c:if test="${not empty sessionScope.localUser.payPass}">
							<li>
								<label>原密码：</label>
								<input type="password" name="payPass" placeholder="请输入原密码" onblur="validatePass(this)"/>
								<p id="payPassErr">原密码不正确！</p>
							</li>
						</c:if>
							<li class="per_pass_qd">
								<label>新密码：</label>
								<input type="password" name="payNewPass" placeholder="密码是6位数字" onkeyup="verifyPayPass(this)" maxlength="6" />
								<p style="display:block;">&nbsp;</p>
								<p id="payNewPassErr">密码格式不正确</p>
								<!--
	                        	作者：xgh_web@126.com
	                        	时间：2015-10-04
	                        	描述：
	                        		以下是默认状态；
	                        	     	弱：给".rpb_2"添加".pw_bg"
	                        	     	中：给".rpb_2,.rpb_3"添加".pw_bg"
	                        	     	强：给".rpb_2,.rpb_3,.rpb_4"添加".pw_bg"
	                            -->
								<!-- <ul >
									<li class="rpb_1">密码强度</li>
									<li class="rpb_2" id="payNewPassLi2"></li>
									<li class="rpb_2" id="payNewPassLi3"></li>
									<li class="rpb_2" id="payNewPassLi4"></li>
									<li class="rpb_3" id="payNewPassLi5"></li>
								</ul> -->
							</li>
							<li>
								<label>确认新密码：</label>
								<input type="password" name="payYesPass" placeholder="同上一致" onblur="validateYesPass(this)" maxlength="6" onkeyup="value=value.replace(/[^\d]/g,'')"/>
								<p id="payYesPassErr">两次密码输入不一致！</p>
							</li>
							<li class="per_bc_btn"><a href="javascript:void(0)" onclick="submitPay()">确认</a></li>
						</ul>	
					</div>
					</form>
					<!--找回交易密码-->
					<form id="formFindPay" method="post">
					<div class="end_pass">
						<h3>通过注册的手机号码找回交易密码</h3>			
						<ul>
							<li>
								<label>手机号：</label>
								<div class="pb_div" id="phones">${sessionScope.localUser.userPhone}</div>
								<a href="javascript:void(0);"  class="pas_yzm" onclick="validateShow2()">获取验证码</a>
								<div class="yzm_djs"></div>
								<p id="phoneYzmErr">获取验证码不能超过10次！</p>
							</li>
							<li>
								<label>验证码：</label>
								<input type="password" name="findPayPass" placeholder="请输入手机验证码" onblur="validatePhone(this)"/>	
								<p id="findPayPassErr">手机验证码不正确！</p>
							</li>
							<li class="per_pass_qd">
								<label>新密码：</label>
								<input type="password" name="findPayNewPass" placeholder="密码是6位数字" onkeyup="verifyPayPass(this)" maxlength="6" />
								<p style="display:block;">&nbsp;</p>
								<p id="findPayNewPassErr">密码格式不正确</p>
								<!--
	                        	作者：xgh_web@126.com
	                        	时间：2015-10-04
	                        	描述：
	                        		以下是默认状态；
	                        	     	弱：给".rpb_2"添加".pw_bg"
	                        	     	中：给".rpb_2,.rpb_3"添加".pw_bg"
	                        	     	强：给".rpb_2,.rpb_3,.rpb_4"添加".pw_bg"
	                            -->
								<!-- <ul >
									<li class="rpb_1">密码强度</li>
									<li class="rpb_2" id="findPayNewPassLi2"></li>
									<li class="rpb_2" id="findPayNewPassLi3"></li>
									<li class="rpb_2" id="findPayNewPassLi4"></li>
									<li class="rpb_3" id="findPayNewPassLi5"></li>
								</ul> -->
							</li>
							<li>
								<label>确认新密码：</label>
								<input type="password" name="findPayYesPass" placeholder="同上一致" onblur="validateYesPass(this)" maxlength="6" onkeyup="value=value.replace(/[^\d]/g,'')"/>
								<p id="findPayYesPassErr">两次密码输入不一致！</p>
							</li>
							<li class="per_bc_btn"><a href="javascript:void(0)" onclick="submitFindPay()">确认</a></li>
						</ul>					
					</div>
					</form>
					
				</div>
				<!--港台实名认证-->
				<form id="formHKM" method="post" enctype="multipart/form-data" action="${ctx}/person/submitHKAndMRealName.htm">
				<input id="gangaotai" value="" type="hidden"/>
				<input name="frontImage" value="" type="hidden"/>
				<input name="backImage" value="" type="hidden"/>
				<div class="per_bod certifie_gat">
					<div class="gt_left">
						<ul>
							<li>
								<label></label>
								<a class="close_certifie_gt" href="javascript://">大陆居民请点这里＞＞</a>
							</li>
							<li style="padding:0;display:none;">
								<label style="height:20px;"></label>
								<p style="color: red;height:20px;line-height:20px;">xxx</p>
							</li>
							<li>
								<label>姓名：</label>
								<input type="text" placeholder="请输入简体字" name="checkName"/>
							</li>
							<li class="select_cont">
								<label>證件類型：</label>
								<div class="select_gt">
									<p val="gangao" id="cardType">港澳居民來往內地通行證</p>
									<input type="hidden" name="cardType"/>
									<ul class="">
										<li className="gangao">港澳居民來往內地通行證</li>
										<li className="taiwan">台胞證</li>
									</ul>
								</div>
							</li>
							<li>
								<label>證件號碼：</label>
								<input type="text"  name="checkCard"/>
							</li>
							
							<li class="add_img">
								<label>證件圖片：</label>
								<a class="front" href="javascript://">
									<em>＋</em>正面
									<input type="file" name="file1" id="file1" onchange="uploadFile1(this)"/>
								</a>
								<a class="back" href="javascript://">
									<em>＋</em>背面
									<input type="file" name="file2" id="file2" onchange="uploadFile2(this)"/>
								</a>
								<p class="pic_alert">图片格式：jpg、png、bmp（2M以内）</p>
							</li>
						
							<li>
								<label></label>
								<a class="submit_gt" href="javascript:void(0)" onclick="submitHKMRealName()">提交</a>
							</li>
						</ul>
					</div>
					<div class="gt_right">
						<div class="imgs_cont gangao">
							<h4>上傳示例1：《港澳居民來往內地通行證》</h4>
							<p>
								<img src="${ctx}/img/gangao_front.jpg"/>
								<span>1、證件正面</span>
							</p>
							<p>
								<img src="${ctx}/img/gangao_back.jpg"/>
								<span>2、證件背面</span>
							</p>
						</div>
						<div class="imgs_cont taiwan">
							<h4>上傳示例2：《臺胞證》</h4>
							<p>
								<img src="${ctx}/img/taiwan_front.jpg"/>
								<span>1、個人信息</span>
							</p>
							<p>
								<img src="${ctx}/img/taiwan_back.jpg"/>
								<span>2、簽發信息</span>
							</p>
						</div>
					</div>
					<div class="promopt">
						<h4>溫馨提示：</h4>
						<p>
							1、實名認證條件：年滿18周歲；持有可正常接收簡訊的內地移動電話號碼；持有本人在內地銀行開立的借記卡，且賬戶為活期賬戶，借記卡需正常可使用；<br />
							2、您需要上傳本人《港澳居民來往內地通行證》或《臺胞證》的清晰彩色照片或影印件；<br />
							3、 如有必要，漲唄網會通過您註冊時預留的內地移動電話號碼與您聯系，請保持電話暢通。<br />
							4、漲唄網將嚴格依照相關法律及內部規範保護用戶相關隱私信息。
						</p>
					</div>
				</div>
					</form>
				<!--港台实名认证中ing-->
				<div class="per_bod gat_ing">
					<h1>認證審核中</h1>
					<p>恭喜！您的實名認證信息已提交</p>
					<p>我們將盡快完成審核，請稍作等待</p>
				</div>
				
				<!--港台实名认证失败-->
				<div class="per_bod gat_fail">
					<h1>認證未通过</h1>
					<p>抱歉，您的實名認證未通過</p>
					<p>
						原因是：<em id="reasonErr">圖片清晰度過低，工作人員難以辨認</em>
					</p>
					<p class="btn_cont">
						<a href="javascript:void(0)" onclick="javascript:$('.certifie_gat').show();$('.smrz_zl').hide();$('.gat_fail').hide();">重新上传</a>
					</p>
				</div>
				
				<!--港台实名认证中成功-->
				<div class="per_bod gat_success">
					<ul>
						<li>
							<label>姓名：</label>
							<p>蔡中文</p>
						</li>
						<li>
							<label>证件号码：</label>
							<p>18844445878</p>
						</li>
						<li>
							<label></label>
							<a href="javascript://">已认证</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!--edit account name-->
		<div class="pop_edit_name">
			<div style="display: block;" class="page_1 cont">
				<h3>修改用户名</h3>
				<p class="">
					<label>当前用户名：</label>
					<span></span>
				</p>
				<p>
					<label>新用户名：</label>
					<input type="text" placeholder="请填写昵称，而非真实姓名" id="editUserName"/>
				</p>
				<p class="ipt"></p>
				<p>
					<a class="yes" href="javascript://">修 改</a>
					<a class="no" href="javascript://">取 消</a>
				</p>
				<p>
					<i>温馨提示：用户名只能修改一次</i>
				</p>
			</div>
			<div style="display: ;" class="page_2 cont">
				<h3>用户名修改成功！</h3>
				<a class="close" href="javascript://">好 的</a>
			</div>
		</div>
	<%@ include file="/static/footer.jsp" %>
<script src="${ctx}/js/ajaxfileupload.js" type="text/javascript" ></script>
	<script type="text/javascript">
	 $(document).ready(function(){
		certifieGat();
		initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array, '11', '0', '0');
		var param = '${param.param}';
		if(param == 'withdraw') {
			$(".per_tab_hov").removeClass("per_tab_hov");
			$("#setPass").addClass("per_tab_hov");
			$("#setPass").click();
			$(".pass_tit").removeClass("pass_tit");
			$("#findPayPass").addClass("pass_tit");
			$("#findPayPass").click();
		}
		
		var editType = '${editType}';
		if (editType == 'realName') {
			$(".per_tab_hov").removeClass("per_tab_hov");
			$("#setRealName").addClass("per_tab_hov");
			$("#setRealName").click();
		}
		if(editType == 'mail') {
			updateMail();
		}
		/* if('${mail}' == "1") {
			$('.email_yz').hide();
			$('.email_end').show();
		}
		if('${mail}' == "0") {
			$('.email_end').hiden();
			$('.email_yz').show();
		} */
	}) 
	//根据地区码查询地区名
	function getAreaNamebyID(areaID){
		var areaName = "";
		if(areaID.length == 2){
			areaName = area_array[areaID];
		}else if(areaID.length == 4){
			var index1 = areaID.substring(0, 2);
			areaName = area_array[index1] + " " + sub_array[index1][areaID];
		}else if(areaID.length == 6){
			var index1 = areaID.substring(0, 2);
			var index2 = areaID.substring(0, 4);
			areaName = area_array[index1] + " " + sub_array[index1][index2] + " " + sub_arr[index2][areaID];
		}
		return areaName;
	}
		//获取验证码倒计时
		var set = 60;
		function show() {
			$(".yzm_djs").text(set+' s');
			set--;
			if (set == 0) {
				set=60;
				$(".yzm_djs").hide().prev(".pas_yzm").show();
			}else{
				setTimeout("show()",1000);
			}
		}
		//实名认证-港澳台
		var certifieGat = function(){
			var status = {
				"没有认证":".certifie_gat",
				"认证ing":".gat_ing",
				"认证失败":".gat_fail",
				"认证成功":".gat_success"
			}
			
			var val = "没有认证";
			//打开港澳台实名认证
			$(".open_certifie_gat").bind("click",function(){
				$(".smrz_zl").hide();
				$(status[val]).show();
			})
			
			//关闭港澳台实名认证
			$(".close_certifie_gt").bind("click",function(){
				$(".certifie_gat").hide();
				$(".smrz_zl").show();
			})
			
			//lect选择框
			$('.select_gt p').bind("click",function(){
				$(".select_gt ul").toggleClass("active");
			})
			
			//港台切换
			$(".select_gt ul li").bind("click",function(){
				$('.select_gt p').text($(this).text());
				$('.select_gt p').attr('val',$(this).attr("className"));
				$(".gt_right .imgs_cont").hide();
				$(".gt_right ."+$(this).attr("className")).show();
				$(".select_gt ul").removeClass('active');
			})
			
			/* //添加照片
			$(".add_img input").change(function(){
				var imgUrl = window.URL.createObjectURL($(this).get(0).files.item(0));
				console.log(imgUrl);
				$(this).parent().css("background-image","url("+imgUrl+")");
			}) */
			
			$(document).ready(function(){
				if(document.location.hash == "#gat"){
					$(".person_tab a").eq(1).click();
					$(".open_certifie_gat").click();
				}
			})
			
		};
		
		$(function(){
			var headFlag=$("#headFlag").val();
			switch(headFlag)
			{
			case '0':
				$('.person_tab a:eq(1)').click();
			break;
			case '1':
				$('.person_tab a:eq(2)').click();
			break;
			case '2':
				$('.person_tab a:eq(3)').click();
			break;
			case '3':
				$('.person_tab a:eq(3)').click();
				if($('.per_password p').length>2){
					$('.per_password p:eq(2)').click();
				}else{
					$('.per_password p:eq(1)').click();
				}	
			 break;
			case '102':
				$('.person_tab a:eq(1)').click();
				$("#gangaotai").val(102);
			break;
			default:
				openTabBasic();
			}
		})
		
		function openTabBasic(){
			if('${mail}' == "1") {
				$('.pesa_1').find('ul:eq(0)').hide();
				$(".yz_email").show();
				$(".yz_email").find('.yz_bod1').hide().eq(2).show();
				$(".yz_email>h1").css('background','url(${ctx}/img/per_email_ti3.png) center bottom no-repeat');
				$(".email_cg").hide();
				$(".email_sb").show();
			}
			if('${mail}' == "2") {
				$('.pesa_1').find('ul:eq(0)').hide();
				$(".yz_email").show();
				$(".yz_email").find('.yz_bod1').hide().eq(2).show();
				$(".yz_email>h1").css('background','url(${ctx}/img/per_email_ti3.png) center bottom no-repeat');
				$(".email_cg").show();
				$(".email_sb").hide();
			}
			//最新安全等级设置
			var count = 1;
	 		var realName = '${sessionScope.localUser.isRealName}';
	 		var addCard = '${sessionScope.localUser.isAddCard}';
	 		var email = '${sessionScope.localUser.userEmail}';
	 		if(realName == 1) {
	 			count++;
	 		}
	 		if(addCard == 1) {
	 			count++;
	 		}
	 		if(email != null && "" != email) {
	 			count++;
	 		}
	 		$(".yz_email .yz_bod1 .email_cg .email_leve div").css("width",count/4*100 + "%");
			
			$.ajax({
				type : "post",
				url : "${ctx}/person/getPerson.htm",
				data : {},
				success : function(data) {
					var datas=JSON.parse(data);
					if(datas.userEmail == null || '' == datas.userEmail) {
						$('.email_yz').show();
						$('.email_end').hide();
					} else {
						$('.email_end div').text(datas.userEmail);
						$('.email_yz').hide();
						$('.email_end').show();
					}
					$("#user_name").val(datas.userName);
					if(datas.info!=null&&datas.info.extField==1){
						$(".edit_name").hide();
					}else{
						$(".edit_name").show();
					}
					$(".pop_edit_name span").html(datas.userName);
					var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
					if(!myreg.test(datas.user_name)){
						$("#user_name").attr("disabled","disabled");
					}else{
						$("#user_name").removeAttr("disabled");
					}
					$(".bod1_block p:eq(0)").text(datas.userPhone);
					$("#user_phone").val(datas.userPhone);
					$("input[name='user_email']").val(datas.userEmail);
					$("input[name='qq']").val(datas.info.qq);
					$("input[name='address']").val(datas.info.address);
					$("input[name='province']").val(datas.info.province);
					$("input[name='city']").val(datas.info.city);
					$("input[name='area']").val(datas.info.area);
					$("input[name='contact1']").val(datas.contact.contact1);
					$("#contact1Re").val(datas.contact.contact1Re); 
					$("input[name='contact1Tel']").val(datas.contact.contact1Tel); 
					var provinceS=datas.info.province==""?"请选择":datas.info.province;
					var cityS=datas.info.city==""?"请选择":datas.info.city;
					var areaS=datas.info.area==""?"请选择":datas.info.area;
					$("#seachprov").find("option:contains('"+provinceS+"')").attr("selected",true);
					var province=$("#seachprov").find("option:contains('"+provinceS+"')").val();
					changeComplexProvince(province, sub_array, 'seachcity', 'seachdistrict');
					$("#seachcity").find("option:contains('"+cityS+"')").attr("selected",true);
					var city=$("#seachcity").find("option:contains('"+cityS+"')").val();
					changeCity(city,'seachdistrict','seachdistrict')
					$("#seachdistrict").find("option:contains('"+areaS+"')").attr("selected",true);
					
				}
			});
		}
		function openReal(){
			$.ajax({
				type : "post",
				url : "${ctx}/person/getPersonReal.htm",
				data : {},
				success : function(data) {
					var datas=JSON.parse(data);
					if(datas.realName!= ""&&datas.idcard!= ""){
						$(".smrz_zl ul li:eq(0)").hide();
						$("input[name='realName']").val(datas.realName);
						var str=datas.idcard;
						var newStr=str.substring(str.length-4, str.length);
						var strs="";
						for (var i = 0; i < str.length-4; i++) {
							strs+="*";
						}
						$("input[name='idcard']").val(strs+newStr);
						$("input[name='realName']").attr("disabled","disabled");
						$("input[name='idcard']").attr("disabled","disabled");
						$("#realA").text("已认证").removeAttr("onclick");
					}else{
						if(datas.checkInfo==undefined){
							var gangaotai=$("#gangaotai").val();
							if(gangaotai==102){
								$(".smrz_zl").hide();
								$(".certifie_gat").show();
								$("#gangaotai").val("");
							}
						}else{
							if(datas.checkInfo.status==100){//待审核
								$(".smrz_zl").hide();
								$(".gat_ing").show();
							}else if(datas.checkInfo.status==101){//通过	
								
							}else if(datas.checkInfo.status==102){//不通过
								$(".smrz_zl").hide();
								$(".gat_fail").show();
								$("#reasonErr").html(datas.checkInfo.reason);
							}
						}	
					}
				}
			});		
		}
		function openTabHead(){
			$.ajax({
				type : "post",
				url : "${ctx}/person/getPersonHead.htm",
				data : {},
				success : function(data) {
					var datas=JSON.parse(data);
					if(datas.headshotUrl!=""){
						$("#personImg").attr("src",datas.headshotUrl);
					}
					
				}
			});		
		}
		function validateEmail(obj){
			var email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			if(obj.value!=""){
				if(!email.test(obj.value)){
					 $("#emailErr").show();
				 }else{
					 $("#emailErr").hide();
				 }
			}else{
				$("#emailErr").hide();
			}
		}
		function validateQQ(obj){
			 var tel = /^[1-9]\d{4,9}$/;
			if(obj.value!=""){
				 if(!tel.test(obj.value)){
					 $("#qqErr").show();
				 }else{
					 $("#qqErr").hide();
				 }
			}else{
				 $("#qqErr").hide();
			}
		}
		function saveBasic(){
			if(!$("#qqErr").is(":hidden")){
				return false;
			}
			var province=$("#seachprov").find("option:selected").text();
			var city=$("#seachcity").find("option:selected").text();
			var area=$("#seachdistrict").find("option:selected").text();
			var arr = ["请选择"];
			$("input[name='province']").val($.inArray(province, arr)==0?"":province);
			$("input[name='city']").val($.inArray(city, arr)==0?"":city);
			$("input[name='area']").val($.inArray(area, arr)==0?"":area);
			
				$.ajax({
					type : "post",
					url : "${ctx}/person/savePerson.htm",
					data : $("#formBasic").serialize(),
					 dataType : 'text',
					success : function(data) {
						if(data=="success"){
							$(".password_alert").find(".allchange").text("成功保存信息");
							$('.password_alert').show();
							location.reload(true);
							setTimeout("javascript:$('.').hide();$('.person_tab a:eq(1)').click();",2000);
							$('#setRealName').click();
						}
						
					}
				}); 
		}
		function uploadFile(obj){
			
			$.ajaxFileUpload({  
		        url : '${ctx}/person/uploadPerson.htm', //用于文件上传的服务器端请求地址  
		        secureuri : false, //一般设置为false  
		        fileElementId : 'file', //文件上传空间的id属性  <input type="file" id="file" name="file" />  
		        type : 'post',  
		        dataType : 'text', //返回值类型 一般设置为json  
		        success : function(data, status) //服务器成功响应处理函数  
		        {  
		        	var data=JSON.parse(data);
		        	if(data.msg=="success"){
		        		$(".password_alert").find(".allchange").text("完成头像认证");
			        	$('.password_alert').show();
						setTimeout("backToinvest()",2000);
		        	}else{
		        		$(".pic_error").show();
		        	}
		        	
		        },  
		        error : function(data, status, e)//服务器响应失败处理函数  
		        {  
		            $(".pic_error").show();
		        }  
		    });  
		}
		function uploadFile1(obj){
			$.ajaxFileUpload({  
		        url : '${ctx}/person/uploadCard1.htm', //用于文件上传的服务器端请求地址  
		        secureuri : false, //一般设置为false  
		        fileElementId : 'file1', //文件上传空间的id属性  <input type="file" id="file" name="file" />  
		        type : 'post',  
		        dataType : 'text', //返回值类型 一般设置为json  
		        success : function(data, status) //服务器成功响应处理函数  
		        {  
		        	var data=JSON.parse(data);
		        	if(data.msg=="success"){
		        		$(".gt_left ul li:eq(1)").hide();
		    			$(".add_img input").eq(0).parent().css("background-image","url("+data.url+")");
		    			$("input[name='frontImage']").val(data.fileName);
		        	}else{
						$(".gt_left ul li:eq(1)").show().find("p").html("图片格式或大小不正确");
					}
		        },  
		        error : function(data, status, e)//服务器响应失败处理函数  
		        {  
		        	$(".gt_left ul li:eq(1)").show().find("p").html("上传错误"); 
		        }  
		    });  
		}
		function uploadFile2(obj){
			
			$.ajaxFileUpload({  
		        url : '${ctx}/person/uploadCard2.htm', //用于文件上传的服务器端请求地址  
		        secureuri : false, //一般设置为false  
		        fileElementId : 'file2', //文件上传空间的id属性  <input type="file" id="file" name="file" />  
		        type : 'post',  
		        dataType : 'text', //返回值类型 一般设置为json  
		        success : function(data, status) //服务器成功响应处理函数  
		        {  
		        	var data=JSON.parse(data);
		        	if(data.msg=="success"){
		        		$(".gt_left ul li:eq(1)").hide();
		        		$(".add_img input").eq(1).parent().css("background-image","url("+data.url+")");
						$("input[name='backImage']").val(data.fileName);
		        	}else{
		        		$(".gt_left ul li:eq(1)").show().find("p").html("图片格式或大小不正确");
					}
		        },  
		        error : function(data, status, e)//服务器响应失败处理函数  
		        {  
		        	$(".gt_left ul li:eq(1)").show().find("p").html("上传错误");  
		        }  
		    });  
		}
		function validatePass(obj){
			$.ajax({
				type : "post",
				url : "${ctx}/person/validatePass.htm",
				data : {
					userPass : obj.value,flag:obj.name
				},
				dataType : "text",
				success : function(data) {
					if (data=="success") {
						$("#"+obj.name+"Err").hide();
					} else {
						$("#"+obj.name+"Err").show();
					}
				}
			}); 
		}
		function verifyPass(obj) {
			  var pwd=obj.value;
			  var m=0; 
			  var Modes=0; 
			  for(i=0; i<pwd.length; i++){ 
			    var charType=0; 
			    var t=pwd.charCodeAt(i); 
			    if(t>=48 && t <=57){charType=1;} 
			    else if(t>=65 && t <=90){charType=2;} 
			    else if(t>=97 && t <=122){charType=4;} 
			    else{charType=4;} 
			    Modes |= charType; 
			  } 
			  for(i=0;i<4;i++){ 
			  if(Modes & 1){m++;} 
			      Modes>>>=1; 
			  } 
			  if(pwd.length<=5){m=1;} 
			  if(pwd.length<=0){m=0;} 
			  switch(m){ 
			    case 1 : 
		    	 	$("#"+obj.name+"Li4").removeClass("pw_bg");
					$("#"+obj.name+"Li3").removeClass("pw_bg");
					$("#"+obj.name+"Li2").addClass("pw_bg");
					$("#"+obj.name+"Li5").text("弱");
			   	break; 
			    case 2 : 
			    	$("#"+obj.name+"Li4").removeClass("pw_bg");
					$("#"+obj.name+"Li3").addClass("pw_bg");
					$("#"+obj.name+"Li2").addClass("pw_bg");
					$("#"+obj.name+"Li5").text("中");
			    break; 
			    case 3 : 
			    	$("#"+obj.name+"Li4").addClass("pw_bg");
					$("#"+obj.name+"Li3").addClass("pw_bg");
					$("#"+obj.name+"Li2").addClass("pw_bg");
					$("#"+obj.name+"Li5").text("强");
			    break; 
			    default : 
			    	$("#"+obj.name+"Li4").removeClass("pw_bg");
					$("#"+obj.name+"Li3").removeClass("pw_bg");
					$("#"+obj.name+"Li2").removeClass("pw_bg");
					$("#"+obj.name+"Li5").text("");
			    break; 
			  } 
				if (!/^(?=.*?[a-zA-Z_])(?=.*?[0-9_])[a-zA-Z0-9_]{6,18}$/.test($("input[name='"+obj.name+"']").val())) {
					$("#"+obj.name+"Err").show();
				}else{
					$("#"+obj.name+"Err").hide();
				}
		}
		function verifyPayPass(obj) {
			if (!/^[0-9]{6,18}$/.test($("input[name='"+obj.name+"']").val())) {
				$("#"+obj.name+"Err").show();
			}else{
				$("#"+obj.name+"Err").hide();
			}
		}
		
		function submitLogin(){
			if($("input[name='loginPass']").val()==""||$("input[name='loginNewPass']").val()==""||$("input[name='loginYesPass']").val()==""){
				return false;
			}
			
			if($("#loginPassErr").is(":hidden")&&$("#loginNewPassErr").is(":hidden")&&$("#loginYesPassErr").is(":hidden")){
				$.ajax({
					type : "post",
					url : "${ctx}/person/submitLogin.htm",
					data : $("#formLogin").serialize(),
					dataType : "text",
					success : function(data) {
						if (data=="success") {
							$(".password_alert").find(".allchange").text("成功修改登录密码");
							$('.password_alert').show();
							setTimeout("backLogin()",2000);
							
						} 
					}
				}); 
			}
			
		}
		function backLogin(){
			$('#formLogin')[0].reset();
			location.href="${ctx}/login/login.htm";
		}
		function backPay(){
			location.href='${ctx}/person/editPerson.htm';
		}
		function backToinvest(){
			location.href='${ctx}/borrowinvest/toinvest.htm';
		}
		function submitPay(){
			var paypass=$("input[name='payPass']").length;
			if(paypass>0){
				if($("input[name='payPass']").val()==""||$("input[name='payNewPass']").val()==""||$("input[name='payYesPass']").val()==""){
					return false;
				}
				if($("#payPassErr").is(":hidden")&&$("#payNewPassErr").is(":hidden")&&$("#payYesPassErr").is(":hidden")){
					$.ajax({
						type : "post",
						url : "${ctx}/person/submitPay.htm",
						data : $("#formPay").serialize(),
						dataType : "text",
						success : function(data) {
							if (data=="success") {
								$(".password_alert").find(".allchange").text("成功修改交易密码");
								$('.password_alert').show();
								setTimeout("backPay()",2000);
							} 
						}
					}); 
				}
			}else{
				if($("input[name='payNewPass']").val()==""||$("input[name='payYesPass']").val()==""){
					return false;
				}
				if($("#payNewPassErr").is(":hidden")&&$("#payYesPassErr").is(":hidden")){
					$.ajax({
						type : "post",
						url : "${ctx}/person/submitPay.htm",
						data : $("#formPay").serialize(),
						dataType : "text",
						success : function(data) {
							if (data=="success") {
								$(".password_alert").find(".allchange").text("成功设置交易密码");
								$('.password_alert').show();
								setTimeout("backPay()",2000);
							} 
						}
					}); 
				}
			}
			
		}
		function submitFindPay(){
			if($("input[name='findPayPass']").val()==""||$("input[name='findPayNewPass']").val()==""||$("input[name='findPayYesPass']").val()==""){
				return false;
			}
			if($("#findPayPassErr").is(":hidden")&&$("#findPayNewPassErr").is(":hidden")&&$("#findPayYesPassErr").is(":hidden")){
			$.ajax({
				type : "post",
				url : "${ctx}/person/submitFindPay.htm",
				data : $("#formFindPay").serialize(),
				dataType : "text",
				success : function(data) {
					if (data=="success") {
						$(".password_alert").find(".allchange").text("成功找回交易密码");
						$('.password_alert').show();
						setTimeout("backPay()",2000);
					} 
				}
			}); 
			}
		}
		function getPhoneVerify2() {
				$.ajax({
					type : "post",
					url : "${ctx}/message/sendMessage.htm",
					data : {
						user_phone : '${sessionScope.localUser.userPhone}',
						messageType:3
					},
					dataType : "json",
					success : function(data) {
					}
				});
		}
		function validatePhone(obj){
			$.ajax({
				type : "post",
				url : "${ctx}/message/equalToCode.htm",
				data : {
					code : obj.value,
					messageType:3
				},
				dataType : "text",
				success : function(data) {
					if(data=="success"){
						$("#findPayPassErr").hide();
					}else{
						$("#findPayPassErr").show();
					}
				}
			});
		}
		function validateYesPass(obj){
			var str=obj.name;
			str=str.replace('Yes','New');
			if(obj.value==$("input[name='"+str+"']").val()){
				$("#"+obj.name+"Err").hide();
			}else{
				$("#"+obj.name+"Err").show();
			}
		}
		var commitFlag=0;
		function submitRealName(){			
			if($("input[name='realName']").val()==''){
				$("#realNameErr").show();
			}else if($("input[name='idcard']").val()==''){
				$("#idcardErr").show();
			}
			if(commitFlag !=0)return;
			commitFlag = 1;
			if($("#realNameErr").is(":hidden")&&$("#idcardErr").is(":hidden")){
				$('#realA').html("验证中.....");
				$('#realA').unbind('click', submitRealName);//取消RecommandProduct 函数
			}
			if($("#realNameErr").is(":hidden")&&$("#idcardErr").is(":hidden")){
				$.ajax({
					type : "post",
					url : "${ctx}/person/submitRealName.htm",
					data : $("#formRealName").serialize(),
					dataType : "text",
					success : function(data) {
						commitFlag=0;
						$('#realA').html("确定");
						$('#realA').bind('click', submitRealName);
						if(data=="success"){
							$("#rzErr").hide();
							$(".password_alert").find(".allchange").text("成功实名认证");
							$('.password_alert').show();
							setTimeout("javascript:$('.password_alert').hide();$('.person_tab a:eq(2)').click();",2000);
						}else if(data=="numsErr"){
							$("#rzErr").show();
							$("#rzP").html('错误次数超过3次，请联系客服！');
						}else if(data=="numsCardErr"){
							$("#rzErr").show();
							$("#rzP").html('此身份证已被注册，认证失败！');
						}else{
							$("#rzErr").show();
							$("#rzP").html(data);
						}
					}
				});
			}
			
		}
		function validateRealName(obj){
			 var chinese = /^[\u4e00-\u9fa5]+$/;
			 if(!chinese.test(obj.value)){
				 $("#"+obj.name+"Err").show();
			 }else{
				 $("#"+obj.name+"Err").hide();
			 }
		}
		function validateIdcard(obj){
			var checkIdCard = new IdCardValidate(obj.value);
			//var card=/(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			 if(!checkIdCard.IsValid()){
				 $("#"+obj.name+"Err").show();
			 }else{
				 $("#"+obj.name+"Err").hide();
			 }
		}
		var phoneflag = false;
		var codeflag = false;
		var codeflag1 = false;
		var email = false;
		
		//修改邮箱
		function updateMail() {
			$('.email_end').parents('ul').hide().parents('form').next('.yz_email').show();
		}
		
		//验证邮箱
		$(".email_yz").bind('click',function(){   //第一步身份验证
			$(this).parents('ul').hide().parents('form').next('.yz_email').show();
		});
		$(".yz_subm:eq(0)").bind('click',function(){    //第二步提交邮箱
			//判断图形验证码和短信验证码是否正确
			if(phoneflag && codeflag) {
				$(this).parents('.yz_bod1').hide().next('ul').show();
				$(".yz_email>h1").css('background','url(${ctx}/img/per_email_ti2.png) center bottom no-repeat');
			}
		});
		$(".yz_subm:eq(1)").bind('click',function(){    //第二步提交邮箱提示发送成功
 			if(codeflag1) {
				//发送邮件
				$.ajax({
					url:"${ctx}/person/sendMail.htm",
					type:"post",
					data:{"email":$(".email_text").val()},
					success:function(data) {
						$(".email_href span").text($(".email_text").val());
						$(".email_href a").text($(".email_text").val());
						$("#mailsub").parents('.yz_bod1').find("li").hide();
						$("#mailsub").parents('.yz_bod1').find(".email_href").show();
					}
				});
			}
		});
		/* $(".email_href a").bind('click',function(){    //第三步邮箱验证结果
			$(".yz_email>h1").css('background','url(${ctx}/img/per_email_ti3.png) center bottom no-repeat');
			$(this).parents('.yz_bod1').hide().next('ul').show();
		}); */
		
		
		//图形验证码刷新
		function flushYzm() {
			$(".kaptchaImage").hide().attr('src','${ctx}/captcha-image.htm?'+ Math.floor(Math.random() * 100)).fadeIn();
		}
		//图形验证码校验
		function kaptchas() {
			if($("#kaptcha").val() == "") {
				$(".lo_list_alert").html("请输入验证码！").css("color","red");
				codeflag = false;
				return;
			}
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
						codeflag = false;
						$(".lo_list_alert").html("验证码错误！").css("color","red");
						$("#yzm").show();
						flushYzm();
					}else{
						codeflag = true;
						$("#yzm").hide();
					}
				}
			});
		}
		
		function kaptchas1() {
			if($("#kaptcha1").val() == "") {
				$(".lo_list_alert").html("请输入验证码！").css("color","red");
				codeflag1 = false;
				return;
			}
			$.ajax({
				type : "post",
				url : "${ctx}/login/kaptchaVer.htm",
				data : {
					kaptcha : $("#kaptcha1").val()
				},
				async:false,
				dataType : "text",
				success : function(data) {
					if (data == 0) {
						codeflag1 = false;
						$(".lo_list_alert").html("验证码错误！").css("color","red");
						$("#yzm1").show();
						flushYzm();
					}else{
						codeflag1 = true;
						$("#yzm1").hide();
					}
				}
			});
		}
		 //验证码倒计时
		var set = 60;
		function showTime() {
			$(".yz_but").hide();
			$(".yz_djs").text(set + " s").show();
			set--;
			if (set == -1) {
				set = 60;
				$(".yz_djs").hide().prev(".yz_but").show();
			} else {
				setTimeout("showTime()", 1000);
			}
		}  
		
	 	$(".yz_but").click(function(){
	 		//$(this).hide().next(".bankC_djs").show();
	 		if(codeflag) {
		 		validateShow();
	 		}
	 	});
	   //检验验证码发送次数
	 	function validateShow(){
	 		$.ajax({
	 			type : "post",
	 			url : "${ctx}/message/checkYzm.htm",
	 			data : {
	 				userPhone : '${sessionScope.localUser.userPhone}',
	 				userPhoneNums:10
	 			},
	 			success : function(data) {
	 				if (data =="err") {
	 					$(".yz_but").show();
	 					$("#phoneYzmNum").show();
	 					$("#phoneYzm").hide();
	 				}else{
	 					showTime();
	 					getPhoneVerify();
	 				}
	 			}
	 		});
	 	}
		//发送验证码
	 	function getPhoneVerify() {
			$.ajax({
				type : "post",
				url : "${ctx}/message/sendMessage.htm",
				data : {
					user_phone : '${sessionScope.localUser.userPhone}',messageType:6
				},
				dataType : "json",
				success : function(data) {

				}
			});
	 	}
		
		//短信验证码校验
		function phoneVerNo(obj) {
			$.ajax({
				type : "post",
				url : "${ctx}/message/equalToCode.htm",
				data : {
					code : $("#messageVeri").val(),messageType:6
				},
				dataType : "text",
				success : function(data) {
					if(data=="success"){
						phoneflag = true;
						$("#phoneYzm").hide();
					}else{
						phoneflag = false;
						$("#phoneYzm").show();
						$("#phoneYzmNum").hide();
					}
				}
			});
		}
		
		function emailCheck(email) {
			if(email.trim() == null || email.trim(email) == '') {
				/* $('.email_text').next().html("<span>邮箱不能为空</span>").show(); */
				$('#myemail').text("邮箱不能为空").css("color","red").show();
				email = false;
				return;
			}
			var reg = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/; 
			if(reg.test(email)) {
				$('.email_text').next().hide();
				email = true;
			}else {
				/* $('.email_text').next().html("<span>邮箱格式不正确</span>").show(); */
				$('#myemail').text("邮箱格式不正确").css("color","red").show();
				email = false;
			}
		}
		
		function toMailLogin() {
			$.ajax({
				url:"${ctx}/person/toMailLogin.htm",
				type:"post",
				data:{"email":$(".email_text").val()},
				success:function(data) {
					window.open(data);
				}
			});
		}
		
		function iknow() {
			location.href="${ctx}/person/editPerson.htm";
		}
		function validateShow2(){
			$.ajax({
				type : "post",
				url : "${ctx}/message/checkYzm.htm",
				data : {
					userPhone : '${sessionScope.localUser.userPhone}',
					userPhoneNums:10
				},
				success : function(data) {
					if (data =="err") {
						$(".yzm_djs").hide();
						$(".pas_yzm").show();
						$("#phoneYzmErr").show();
					}else{
						$("#phoneYzmErr").hide();
						show();
						getPhoneVerify2();
					}
				}
			});
		}
		function submitHKMRealName(){
			var checkName=$("input[name='checkName']").val();
			var checkCard=$("input[name='checkCard']").val();
			var frontImage=$("input[name='frontImage']").val();
			var backImage=$("input[name='backImage']").val();
			 var chinese = /^[\u4e00-\u9fa5]+$/;
			 if(!chinese.test(checkName)){
				 $(".gt_left ul li:eq(1)").show().find("p").html("請輸入中文姓名");
				 return false;
			 }
			if(checkCard==""){
				$(".gt_left ul li:eq(1)").show().find("p").html("請輸入證件號碼");
				return false;
			}
			var checkCardErr=/^(\d|[a-zA-Z])+$/;
			if(!checkCardErr.test(checkCard)){
				$(".gt_left ul li:eq(1)").show().find("p").html("證件號碼非法");
				return false;
			}
			var cardType=$("#cardType").attr("val");
			if(cardType=="gangao"){
				$("input[name='cardType']").val(2);
			}else{
				$("input[name='cardType']").val(3);
			}
			if(frontImage==""){
				$(".gt_left ul li:eq(1)").show().find("p").html("请上传正面照");
				return false;
			}
			if(backImage==""){
				$(".gt_left ul li:eq(1)").show().find("p").html("请上传背面照");
				return false;
			}
			if(!$(".gt_left ul li:eq(1)").is(":hidden")){
				return false;
			}
			$("#formHKM").submit();
		}
		function submitRegister(){
			var userName=$("#editUserName").val();
			if(userName!=""){
				var len = userName.replace(/[^\x00-\xff]/g, "**").length;
			    if(len<4 || len>20){
			    	$(".ipt").html("必须为4~20位字符的中文、数字或字母");
			    	return false;
			    }else{
			    	$(".ipt").html("");
			    }
			    var checkNumber=/[^\d]/g;
			    if(!checkNumber.test(userName)){
			    	$(".ipt").html("必须为4~20位字符的中文、数字或字母");
			    	return false;
			    }else{
			    	$(".ipt").html("");
			    }
			}
			if(userName!=""&&$(".ipt").html()==""){
				$.ajax({
					type : "post",
					url : "${ctx}/person/checkName.htm",
					data : {
						userName : userName
					},
					dataType:'text',
					success : function(data) {
						if (data =="err") {
							$(".ipt").html("该名称已被占用");
						}else{
							$("#user_name").val(userName);
							$(".ipt").hide();
							$(".edit_name").hide();
							$('.pop_edit_name .page_1').fadeOut(300);
							$('.pop_edit_name .page_2').fadeIn(300);
						}
					}
				});
			}
		}
		$(function(){
			PFUN.editName();
		});
		
		PFUN.editName = function(){
			//pop
			$(".edit_name").bind("click",function(){
				$(".ipt").html("");
				$("#editUserName").val("");
				$('.pop_edit_name').fadeIn(300);
			})
			//close
			$(".pop_edit_name .no").bind("click",function(e){
				$('.pop_edit_name').fadeOut(300);
			})
			//close
			$(".pop_edit_name").bind("click",function(e){
				$('.pop_edit_name').fadeOut(300);
				e.stopPropagation();
			})
			//stopPropagation
			$(".pop_edit_name .cont").bind("click",function(e){
				e.stopPropagation();
			})
			//submit
			$(".pop_edit_name .yes").bind("click",function(e){
				submitRegister();
			})
			//close
			$(".pop_edit_name .close").bind("click",function(e){
				$('.pop_edit_name').fadeOut(300);
			})
		}
		
	</script>
	</body>
</html>
