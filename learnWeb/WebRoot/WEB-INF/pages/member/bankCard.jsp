<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>银行卡_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/bankCard.css" />
		<link rel="stylesheet" href="${ctx}/css/personal.css" />
		<link rel="stylesheet" href="${ctx}/css1000/bankCard1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/bankCard750.css" />
		<link rel="stylesheet" href="${ctx}/css720/bankCard720.css" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	</head>
	<script type="text/javascript" src="${ctx}/js/self-index.js"></script>
<script type="text/javascript">
	/* $(function(){
		$("#sjld").sjld("#shenfen","#chengshi","#quyu");
	}) */
</script>	
<style type="text/css">
 *{ margin:0; padding:0}
 .clearfix:after{
     content:".";        
     display:block;        
     height:0;        
     clear:both;        
     visibility:hidden;    
} 
.clearfix{*zoom:1}
/* m_zlxg */
.m_zlxg{ width:93px; height:30px; line-height:30px;cursor:pointer;float:left;margin:0 10px 0 0;background:url(${ctx}/static/zlxg2.jpg) no-repeat;}
.m_zlxg p{ width:71px; padding-left:10px; overflow:hidden; line-height:30px; color:#333333; font-size:12px; font-family:"微软雅黑";text-overflow:ellipsis; white-space:nowrap;}
.m_zlxg2{ position:absolute; border:1px solid #ded3c1;background:#fff; width:91px; display:none; max-height:224px;-height:224px; overflow-x:hidden; overflow-y:auto;white-space:nowrap;}
.m_zlxg2 ul{margin:0;}
.m_zlxg2 ul li{ display:block; margin:0; padding:0 0 0 10px;}
.m_zlxg2 li{line-height:28px;white-space:nowrap;font-family:"微软雅黑";color:#333333; font-size:12px;}
.m_zlxg2 li:hover{ color:#7a5a21;}
</style>
<script type="text/javascript">
</script>
	<body>
	<%@ include file="/static/top.jsp" %>
	<input type="hidden" value="${realname}" id="realname">
		<div class="content_body">
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/left_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="right_main">
				<!--银行卡列表-->
				<ul class="bankC_bod">
					<!--
                    	作者：xgh_web@126.com
                    	时间：2015-09-11
                    	描述：以下状态只会出现一个，没有绑定银行卡的情况下只有第三个li
                    	    已经绑定银行卡了，隐藏第三个li
                    -->
                    <c:choose>
                    <c:when test="${empty bankCardInfo && handleStatus != 'process'}">
                   		<li class="bankcard_add" onclick="showAddCard();"></li>
                    </c:when>
                    <c:when test="${handleStatus == 'process'}">
                    	<!-- <li class="bankcard_add" style="background-image:none" onclick="getAllInPayStatus();">绑卡中</li> -->
                    	<li class="bankcard_add" style="background-image:none;" onclick="getAllInPayStatus();"><div class="refresh"></div><!--添加银行卡--></li>
                    </c:when>
                    <c:otherwise>
	                    <li>
	                    	<!-- <div><a href="javascript://">删&nbsp;除</a></div> -->
	                    	<h1>
								<span>${bankCardInfo.cardBank}</span>
							</h1>
	                    	<p>${bankCardInfo.bankCardNo}</p>
	                    </li>
                    </c:otherwise>
                    </c:choose>
                    <li class="prompt_cont">
						<div>
							<h3>温馨提示：</h3>
							<p>
								1、您只能绑定实名认证用户本人名下的银行卡，请正确填写相关信息，否则无法正常提现；<br />
								2、如需换绑银行卡，请联系在线客服或拨打客服热线：4001-199-399。<br />
							</p>
						</div>
					</li>
				</ul>
				
				<!--银行卡列表-->
				<!-- <ul class="bankC_bod">
					
                    	作者：xgh_web@126.com
                    	时间：2015-09-11
                    	描述：以下状态只会出现一个，没有绑定银行卡的情况下只有第三个li
                    	    已经绑定银行卡了，隐藏第三个li
                   
					<li><div><a href="javascript://">删&nbsp;除</a></div><h1>中国建设银行</h1><p>123*************6789</p></li>
					<li class="ban_e">修改绑定请联系客服：4001-199-399</li>
					<li class="bankcard_add">添加银行卡</li>
				</ul> -->
				<!--身份验证-->
				<ul class="bankC_yz">
					<li>
						<h2>身份验证</h2>
						<h3>删除银行卡前，请先完成身份验证</h3>
					</li>
					<li>
						<label>您绑定的手机号：</label>
						<p id="user_phone">${sessionScope.localUser.userPhone}</p>
					</li>
					<li>
						<label>短信验证码：</label>
						<input type="text" class="yz_text" id="messageVeri" onblur="phoneVerNo(this)">
						<div class="bankC_yzm">获取验证码</div>
						<div class="bankC_djs">60S</div>
						<p id="phoneYzm" style="display:none;color:red">手机验证码不正确</p><p id="phoneYzmNum" style="display:none;color:red">发送验证码已超过十次!</p>
						<h4>验证码不正确？</h4>
					</li>
					<li>
						<label>交易密码：</label>
						<input type="password" class="yz_text" id="payPass">
						<span id="checkpwd" style="float:left;height:30px; line-height:30px;"></span>
						<span id="remberpwd" style="float:left;height:30px; line-height:30px;margin-left:10px;"></span>
					</li>
					<li>
						<input type="button" value="确认删除" class="yz_btn1">
						<input type="button" value="取消" class="yz_btn2">
					</li>
					<!--删除确认提示框-->
					<div class="bankC_del">
						<div class="del_bod">
							<h1>通知</h1>
							<b>您已成功删除银行卡</b>
							<p>${bankCardInfo.bankCardNo}</p>
							<input type="button" value="确认" onclick="confirm();"/>
						</div>
					</div>
				</ul>
				<!--添加银行卡-->
				<div class="add_bc" style="<c:if test="${not empty display}">display:block</c:if>">
				<form action="${ctx}/bankcard/fAddMemberInfo.htm" id="myForm" method="post" onsubmit="return formcheck()">
					<input type="hidden" name="token" value="${token}">
					<div class="addb_bod">
						<input type="hidden" name="merOrderId" id="merOrderId" />
						<input type="hidden" name="phoneToken" id="phoneToken" />
						<input type="hidden" name="bankName" id="bankName"/>
						<div class="addb_close"></div>
						<h3>添加银行卡</h3>
						<ul>
							<li><label>真实姓名</label><input type="text" name="realName" readonly="readonly" id="realName" value="${memberInfo.realName}" /><span id="checkname"></span></li>
							<li><label>银行账号</label><input maxlength="19" type="text" name="bankCardNo" id="bankCardNo"/><span id="checkbankcardno"></span></li>
							<!-- <li>
								<label>证件类型</label>
								<select name="credentialsType" id="credentialsType" style="width: 197px;">
									<option value="">选择证件类型</option>
									<option value="0">身份证</option>
									<option value="4">港澳台通行证</option>
									<option value="18">台胞证</option>
								</select>
								<span id="checkcredentials"></span></li>
							<li><label>证件号码</label><input maxlength="20" type="text" name="idcard" id="idcard"/><span id="checkidcard"></span></li> -->
							<li>
								<label>开户银行</label>
								<select name="cardBank" id="cardBank">
						        <option value="1">选择开户行</option>
					            <option value="0102">中国工商银行</option>
					            <option value="0103">中国农业银行</option>
					            <option value="0104">中国银行</option>
					            <option value="0303">中国光大银行</option>
					            <option value="0309">兴业银行</option>
					            <option value="0302">中信银行</option>
					            <option value="0304">华夏银行</option>
					            <option value="04105840">平安银行</option>
					            <option value="0305">中国民生银行</option>
					           	<!-- <option value="0105">中国建设银行</option> -->
						        <!-- <option value="0308">招商银行</option>
					           	<option value="0310">浦发银行</option>
					            <option value="0403">中国邮政储蓄银行</option>
					            <option value="04083320">宁波银行</option>
					            <option value="04243010">南京银行</option>
					            <option value="04202220">大连银行</option> -->
					            
					            
					            <!-- <option value="03010000">中国交通银行</option>
					            <option value="04202220">大连银行</option>
					            <option value="0306">广东发展银行</option>
					            <option value="04012900">上海银行</option>
					            <option value="14055810">广州农村商业银行</option>
					            <option value="04135810">广州银行</option>
					            <option value="65012900">上海农村商业银行</option>
					            <option value="04031000">北京银行</option>
					            <option value="03170000">渤海银行</option>
					            <option value="14181000">北京农商银行</option>
					            <option value="26150704">东亚银行</option>
					            <option value="01033320">宁波银行</option>
					            <option value="04233310">杭州银行</option>
					            <option value="04403600">徽商银行</option>
					            <option value="03160000">浙商银行</option>
					            <option value="05213000">江苏银行</option>
					            <option value="04202220">大连银行</option> -->
								<%-- <c:choose>
									<c:when test="${empty bankinfolist}"><option value="">暂时没有银行卡信息！</option>暂时没有银行卡信息！</c:when>
									<c:otherwise>
										<c:forEach items="${bankinfolist}" var="bankinfo">
										   <option value="${bankinfo.aliasname}">${bankinfo.aliasname}</option>
										</c:forEach>
									</c:otherwise>
								</c:choose> --%>
								</select>
								<span id="checkselect"></span>
							</li>
							<li id="sjld">
							<input type="hidden" name="province" id="province"/>
							<input type="hidden" name="city" id="city"/>
							<input type="hidden" name="area" id="area"/>
								<label>开户行所在地</label>
								<select  id="seachprov" onChange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');">
								</select>
								<select id="seachcity" onChange="changeCity(this.value,'seachdistrict','seachdistrict');">
								</select>
								<span id="seachdistrict_div" style="display:none"><select id="seachdistrict"></select></span>
								
								<!-- <div class="m_zlxg" id="shenfen">
									<p title="" id="bprovince" >选择省份</p>
									<input type="hidden" class="province" name="province" value="">
									<div class="m_zlxg2">
										<ul></ul>
									</div>
								</div>
								<div class="m_zlxg" id="chengshi">
									<p title="" id="bcity">选择城市</p>
									<input type="hidden" class="city" name="city" value="">
									<div class="m_zlxg2">
										<ul></ul>
									</div>
								</div>
								<div class="m_zlxg" id="quyu">
									<p title="" id="barea">选择区域</p>
									<input type="hidden" class="area" name="area" value="">
									<div class="m_zlxg2">
										<ul></ul>
									</div>
								</div> -->
								<input id="sfdq_num" type="hidden" value="" />
								<input id="csdq_num" type="hidden" value="" />
								<input id="sfdq_tj" type="hidden" value="" />
								<input id="csdq_tj" type="hidden" value="" />
								<input id="qydq_tj" type="hidden" value="" />
								 <span id="checkpca"></span>
                            </li>
							<li><label>支行名称</label><input type="text" name="cardBranchBank" id="zbank"/><span id="checkzh"></span> </li>
							<!-- <li>
								<label>验证码</label><input type="text" name="phoneVercode" id="phoneVercode" style="width: 93px;"/>
								<div class="yzm_hq" onclick="if(checkCode()) setTimeout('getCode()', 300);" style="margin: 0 0 0 10px; height: 27px;">获取验证码</div>
								<div class="yzm_djs" style="margin: 0 0 0 10px; height: 27px;">60S</div>
							</li> -->
							<li class="checkInfoCont"><span id="checkInfo"></span></li>
							<li class="bank_s_bt"><input type="submit" value="确认提交" id="tijiao"><!-- <a href="javascript://">确认提交</a> --></li>
						</ul>
					</div>
					</form>
				</div>
			</div>
		</div>
		<div class="success_pop">
			<div class="cont">
				<h1></h1>
				<p></p>
				<a href="${ctx}/bankcard/fquerybank.htm" class="btn">确定</a>
			</div>
		</div>
		
		<div id="openReal"></div>
		
		<!--设置交易密码-->
			<div class="Szzf_password" style="display:none;">
				<form id="formJy" method="post">
					<div class="szp_bod">
						<a href="javascript:(0)" class="szp_clo"></a>
						<input type="hidden" id="zeroPass" name="zeroPass"/>
						<h3>设置交易密码</h3>
						<div class="szp_mmk">
							<p id="titles">请输入6位数字的交易密码</p>
							<!--第一次输入密码-->
							<ul id="ul0">
								<li><input type="password" name="" maxlength="1" /></li>
								<li><input type="password" name="" maxlength="1"/></li>
								<li><input type="password" name="" maxlength="1"/></li>
								<li><input type="password" name="" maxlength="1"/></li>
								<li><input type="password" name="" maxlength="1"/></li>
								<li><input type="password" name="" maxlength="1"/></li>
							</ul>
							<!--确认密码-->
							<ul class="szp_qrli" id="ul1">
								<li><input type="password" name="" maxlength="1" /></li>
								<li><input type="password" name="" maxlength="1"/></li>
								<li><input type="password" name="" maxlength="1"/></li>
								<li><input type="password" name="" maxlength="1"/></li>
								<li><input type="password" name="" maxlength="1"/></li>
								<li><input type="password" name="submitPass" maxlength="1"/></li>
							</ul>
						</div>
						<div class="szp_btn">
							<input type="button" name="" value="重置" class="szp_btn_cz" />
							<input type="button" name="" value="确认" class="szp_btn_qr" />
						</div>
						<p class="szp_alert">您已成功设置交易密码！</p>
					</div>
					</form>
				</div>	
		<jsp:include page="/tradePwdSet.jsp"></jsp:include> 
		
<script src="${ctx}/js/Area.js" type="text/javascript"></script>
<script src="${ctx}/js/AreaData_min.js" type="text/javascript"></script>

<script type="text/javascript">
$.ajaxSetup({ async: false });

var flag = false;
function showAddCard(){
	$.ajax({
		type : "post",
		url : "${ctx}/person/getPersonReal.htm",
		data : {},
		success : function(data) {
			var datas=JSON.parse(data);
			if(datas.realName!= ""){
				window.location.href='${ctx}/bankcard/fquerybank.htm?display=true';
			}else{
				$("#openReal").load("${ctx}/realName.jsp");
			}
		}
	});	
}

	function  formcheck(){
		var realname=$("#realName").val();
		var bankcardno=$("#bankCardNo").val();
		var zbank=$("#zbank").val();
		if(checkname(realname)&checkbankcardno(bankcardno)&checkbank()&checkaddress()&checkzband(zbank)){
			$("#checkInfo").text("正在绑卡中，请稍后。。。");
			$("#checkInfo").css("color","red");
			setTimeout('submitForm()', 300);
			return false;
		} else {
			return false;
		}
		return false;
	}
	function checkname(realname){ 
		var chinese = /^[\u4e00-\u9fa5]+$/;
		if(realname==''){
			$("#checkname").text("请输入姓名！");
			$("#checkname").css("color","red");
			$("#realName").val("");
			$("#realName").focus();
			return false;
		}else{
			return true;
			/* if(chinese.test(realname)){
				$("#checkname").text("");
			}else{
				$("#checkname").text("姓名只能是汉字！").css("color","red");
				$("#realName").val("");
				$("#realName").focus();
				return false;
			} */
		}
	}
	
	function checkbankcardno(bankcardno) {
		if (bankcardno==null||bankcardno=='') {
			$("#checkbankcardno").text("请输入银行账户！");
			$("#checkbankcardno").css("color","red");
			return false;
		} else {
			$("#checkbankcardno").text("");
			var pattern = new RegExp("^[0-9]*$");
	        if (bankcardno.length < 7) {
	        	$("#checkbankcardno").text("请输入正确的银行卡号。");
	        	$("#checkbankcardno").css("color","red");
    	  		return false;
	        } else if (pattern.test(bankcardno)) {
				$("#checkbankcardno").text("");
				return true;
			} else {
				$("#checkbankcardno").text("请输入数字卡号。");
    	  		$("#checkbankcardno").css("color","red");
    	  		return false;
		      }
		  }
		}	
	function checkbank(){	
		 if($("#cardBank").val()=='1'){
			 $("#checkselect").text("请选择开户行！");
			 $("#checkselect").css("color","red");
			 return false;
		 }else{
			 $("#checkselect").text("");
			 return true;
		 }
	}
	function checkaddress(){
		var province=$("#seachprov").find("option:selected").text();
		var city=$("#seachcity").find("option:selected").text();
		var area=$("#seachdistrict").find("option:selected").text();
		$("input[name='province']").val(province=="请选择"?"":province);
		$("input[name='city']").val(city=="请选择"?"":city);
		$("input[name='area']").val(area=="请选择"?"":area);
		
		 if(province=='请选择' || province == ''){
			 $("#checkpca").text("请选择地址");
			 $("#checkpca").css("color","red");
			 return false;
		 }
		 if(city=='请选择' || city== ''){
			 $("#checkpca").text("请选择地址");
			 $("#checkpca").css("color","red");
			 return false;
		 }
		 $("#checkpca").text("");
		 return true;
   } 
	function checkzband(zbank){
		if(zbank==null||zbank==''){
			$("#checkzh").text("请输入支行名称！");
			 $("#checkzh").css("color","red");
			return false;
		}else{
			$("#checkzh").text("");
			return true;
		}
	}
	
	/* function checkPhoneVercode() {
		var phoneVercode = $("#phoneVercode").val();
		if (phoneVercode == null || phoneVercode == '') {
			$("#checkInfo").text("验证码不能为空！");
			$("#checkInfo").css("color","red");
			return false;
		} else return true;
	} */
     $(function(){
			//从这里开始 点击按钮 本来先判断可是还是会跳转页面  就是表单 
			$("#realName").blur(function(){
			var realname=$("#realName").val();
			checkname(realname);
			})
			$("#bankCardNo").blur(function(){
			var bankcardno=$("#bankCardNo").val();
			checkbankcardno(bankcardno);
			})
			$("#zbank").blur(function(){
				var zbank=$("#zbank").val();
				checkzband(zbank);
			})
	});
     
     
     $(".szp_mmk ul:eq(0) input").bind("click",function(){
			for (var s = 0; s<6; s++) {
				if ($('.szp_mmk ul:eq(0) input').eq(s).val()!='') {
					var si = s;
					while(true){
						si=si+1;
						if($('.szp_mmk ul:eq(0) input').eq(si).val()==""){
							$(".szp_mmk ul:eq(0) input").eq(si).focus();
							break;
						}
					}
				} else{
					$(".szp_mmk ul:eq(0) input").eq(s).focus();
					break;
				}
			}
		})
		
		$(".szp_mmk ul:eq(0) input").bind("keyup",function(){
			var values=$(this).val();
			values=values.replace(/[^\d]/g,'');
			$(this).val(values);
			if(values!=''){
				$(this).parent('li').next().find('input').focus();
			}	
			if($("input[name='submitPass']").val()!=''){
				var str="";
				for(var i=0;i<6;i++){
					str+=$('.szp_mmk ul:eq(1) input').eq(i).val();
				}
				if(str==$("#zeroPass").val()){
					submitJy();
				}else{
					$("#titles").text("两次密码不一致请重新输入").css("color","red");
					$(".szp_mmk ul:eq(1) input").val('');
					$(".szp_mmk ul:eq(1) input:eq(0)").focus();
				}
			}
		})
		//设置交易密码
		$(".szp_btn_cz").bind("click",function(){
			$(".szp_mmk ul:eq(0) input").val('');
			$(".szp_mmk ul:eq(0) input:eq(0)").focus();
		})
		$(".szp_btn_qr").bind("click",function(){
			var flag=0;
			var str="";
			for(var i=0;i<6;i++){
				str+=$('.szp_mmk ul:eq(0) input').eq(i).val();
				if ($('.szp_mmk ul:eq(0) input').eq(i).val()=='') {
					flag++;
				}
			}
			if(flag==0){
				$("#zeroPass").val(str);
				$(".szp_mmk ul:eq(0),.szp_btn").hide();
				$(".szp_mmk ul:eq(1)").show();
				$("#titles").text("请再次输入确认交易密码");
				$(".szp_mmk ul:eq(1) input:eq(0)").focus();
			}
			
		})
		$(".szp_clo").bind("click",function (){
			$(".Szzf_password").hide();
		});
		function openTabPass(){
			$('#formJy')[0].reset();  
			$("#ul0").show();
			$("#ul1").hide();
			$(".Szzf_password,.szp_btn").show();
			$("#titles").text("请输入6位数字的交易密码").css('color','#54B8FE');
			$(".szp_alert").hide();
		}  
		function submitJy(){
			$.ajax({
				type : "post",
				url : "${ctx}/person/submitJy.htm",
				data : $("#formJy").serialize(),
				dataType : "text",
				success : function(data) {
					if(data=="success"){
						$(".szp_alert").show();
						$(".szp_mmk p").hide();
						setTimeout("backPass()",1000);
						$("#remberpwd").html("<p>忘记交易密码,</p><a href='javascript:openDiv()'>请点这里</a><h4></h4>");
						$("#checkpwd").html("");
					}
				}
			});
			isPayPass = true;
		}
		function backPass(){
			$(".Szzf_password").hide();
		}
     
		
		 //验证码倒计时
		var set = 60;
		function showTime() {
			$(".bankC_yzm").hide();
			$(".bankC_djs").text(set+' s').show();
			set--;
			if (set == -1) {
				set = 60;
				$(".bankC_djs").hide().prev(".bankC_yzm").show();
			} else {
				setTimeout("showTime()", 1000);
			}
		}  
		
	 	$(".bankC_yzm").click(function(){
	 		//$(this).hide().next(".bankC_djs").show();
	 		validateShow();
	 	});
	   //检验验证码发送次数
	 	function validateShow(){
	 		$.ajax({
	 			type : "post",
	 			url : "${ctx}/message/checkYzm.htm",
	 			data : {
	 				userPhone : $("#user_phone").text(),userPhoneNums:10
	 			},
	 			success : function(data) {
	 				if (data =="err") {
	 					$(".bankC_yzm").show();
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
					user_phone : '${sessionScope.localUser.userPhone}',messageType:5
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
					code : $("#messageVeri").val(),messageType:5
				},
				dataType : "text",
				success : function(data) {
					if(data=="success"){
						flag = true;
						$("#phoneYzm").hide();
					}else{
						flag = false;
						$("#phoneYzm").show();
						$("#phoneYzmNum").hide();
					}
				}
			});
		}
		
		//解绑银行卡
		function cardDelete() {
			var is_no = false;
			if(flag) {
				$.get("${ctx}/borrowinvest/paypwd.htm",{"tradepwd":$('#payPass').val()},function(data){
					if(data == 'yes'){
		             	$("#remberpwd").html("<p>忘记交易密码,<a href='javascript:openDiv()'>请点这里</a></p><h4></h4>");
		             	is_no=true;
		             }else if(data == 'isno'){
		            	$("#checkpwd").html("<p style='color:#727272'>您还没有设置交易密码,<a onclick='openTabPass()' href='javascript:void(0)'>请点这里</a></p></li>");
		            	$("#remberpwd").html("");
		 		   		is_no=false;
		             }else if(data == 'isnull'){
		            	 $("#remberpwd").html("<p>忘记交易密码,<a href='javascript:openDiv()'>请点这里</a></p><h4 style='display:block;'>请输入交易密码</h4>");
						 is_no=false;
		             }else{
		            	 $("#remberpwd").html("<p>忘记交易密码,<a href='javascript:openDiv()'>请点这里</a></p><h4 style='display:block;'>密码错误</h4>");
		            	 flushYzm();
		            	 is_no=false;
		             }
				})
				
				if(is_no) {
					var cardCode = '${cardCode}';
					$(".del_bod").find("b").text("您已成功删除银行卡");
					$.ajax({
						url:"${ctx}/bankcard/unbindCard.htm",
						type:"post",
						dataType:"json",
						data:{"payPass":$("#payPass").val(),"bankCard":cardCode},
						success:function(data) {
							if(data.payPass == "fail") {
								$("#checkpwd").html("<p style='color:red'>交易密码错误</p>");
								return;
							}
							if(data.withDraw == "fail") {
								$(".del_bod").find("b").text("该银行卡存在处理中的提现记录，不可解绑!").show();
								$(".bankC_del").show();
								return;
							}
							if(data.result == "interfail") {
								$(".del_bod").find("b").html("<span>抱歉，解绑失败， 您的网络可能不稳定，请稍后重试 。</span><br><span>您也可咨询客服：4001-199-399</span>");
								$(".del_bod").find("p").hide();
								$(".bankC_del").show();
								return;
							}
							if(data.result == "success") {
								$(".bankC_del").show();
							}
						}
					});
				}
			}
		}
		
		function confirm() {
			location.reload();
		}
   
</script>
<script type="text/javascript">
	$(function(){
		initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array, '11', '0', '0');
		//窗体加载看是否实名认证
		var real=$("#realname").val();
		var pass = '${pass}';
		if(real=='meiyou'){
			$("#openReal").load("${ctx}/realName.jsp");
		}	
		if(pass == 'true') {
			$("#remberpwd").html("<p>忘记交易密码,<a href='javascript:openDiv()'>请点这里</a></p><h4></h4>");
	   	}else{
	   		$("#checkpwd").html("<p>您还没有设置交易密码,<a onclick='openTabPass()' href='javascript:void(0)'>请点这里</a></p><h4>密码错误</h4></li>");
		}
		//获取银行logo
		if('${bankCardInfo}' != null) {
			var bankName = '${bankCardInfo.cardBank}';
			var logoName;
			if(bankName == '中国工商银行') {
				logoName = 'cardpic_gsyh';
			}
			if(bankName == '中国农业银行') {
				logoName = 'cardpic_nyyh';
			}
			if(bankName == '中国银行') {
				logoName = 'cardpic_zgyh';
			}
			if(bankName == '中国建设银行') {
				logoName = 'cardpic_jsyh';
			}
			if(bankName == '中信银行') {
				logoName = 'cardpic_zxyh';
			}
			if(bankName == '中国光大银行') {
				logoName = 'cardpic_gdyh';
			}
			if(bankName == '华夏银行') {
				logoName = 'cardpic_hxyh';
			}
			if(bankName == '招商银行') {
				logoName = 'cardpic_zsyh';
			}
			if(bankName == '兴业银行') {
				logoName = 'cardpic_xyyh';
			}
			if(bankName == '浦发银行') {
				logoName = 'cardpic_pfyh';
			}
			if(bankName == '平安银行') {
				logoName = 'cardpic_payh';
			}
			if(bankName == '中国邮政储蓄银行') {
				logoName = 'cardpic_yzcx';
			}
			if(bankName == '宁波银行') {
				logoName = 'cardpic_nbyh';
			}
			if(bankName == '南京银行') {
				logoName = 'cardpic_njyh';
			}
			if(bankName == '中国民生银行') {
				logoName = 'cardpic_msyh';
			}
			if(bankName == '大连银行') {
				logoName = 'cardpic_dlyh';
			}
			var logoUrl = '../img/bankLogo/' + logoName + '.png';
			$(".bankC_bod li h1 span").css("background-image",'url(' + logoUrl + ')');
		}
			
	})

	var seconds = 60;
	var t = null;
	function showTime2() {
		$(".yzm_hq").hide();
		$(".yzm_djs").text(seconds+' s').show();
		seconds--;
		if (seconds == -1) {
			seconds = 60;
			$(".yzm_djs").hide().prev(".yzm_hq").show();
		} else {
			t = setTimeout(function(){
				showTime2();
	        }, 1000);
		}
	}
	
	//	发送短信验证码
	/* function checkCode() {
		var cardNo = $("#bankCardNo").val();
		var bankNo = $("#cardBank").val();
		var zbank = $("#zbank").val();
		//var idcard = $("#idcard").val();
		//var credentialsType = $("#credentialsType").val();
		if(!checkbankcardno(cardNo)) { return false;}
		//if(!checkCredentials()) { return ;}
		if(!checkbank()) { return false;}
		if(!checkaddress()) { return false;}
		if(!checkzband(zbank)) { return false;}
		
		$("#checkInfo").text("短信正在发送中，请稍后。。。");
		$("#checkInfo").css("color","red");
		showTime2();
		return true;
	} */
	
	/* function getCode() {
		var cardNo = $("#bankCardNo").val();
		var bankNo = $("#cardBank").val();
		var result = '';
		$.post("${ctx}/bankcard/dynamicAuthentication.htm", 
				{"cardNo" : cardNo, "bankNo" : bankNo 
				 //"idcard" : idcard, "credentialsType" : credentialsType
				 }, 
				function (data) {
					 result = data;
		}, "text");
		
		if(result != null && result != '') {
			var info = JSON.parse(result);
			if (info["error"] == null) {
				$("#checkInfo").text("发送成功！");
				$("#merOrderId").val(info["merOrderId"]);
				$("#phoneToken").val(info["phoneToken"]);
			} else {
				$("#checkInfo").text(info["error"]);
				$("#checkInfo").css("color","red");
			}
		}
	} */
	
	function submitForm() {
		var result = '';
		var bankName = $("#cardBank").find("option:selected").text();
		$("#bankName").val(bankName);
		$.post("${ctx}/bankcard/fAddMemberInfo.htm",
				$("#myForm").serializeArray(), 
				function (data) {
					result = data;
		}, "text");
		
		if(result != null && result != '') {
			$(".add_bc").hide();
			var info = JSON.parse(result);
			if(info["type"] == 'success') {
				$(".cont h1").text("银行卡绑定成功");
				$(".cont p").text("提现时，您的资金将打款到此银行卡中");
				$(".success_pop").show();
			}else if(info["type"] == 'fail') {
				$(".cont h1").text("抱歉，绑定未成功");
				$(".cont p").html("请确保银行名称、卡号、开户人姓名完全匹配</br>若有仍疑问，欢迎致电客服：4001-199-399 ");
				$(".success_pop").show();
			}else if(info["type"] == 'process') {
				$(".cont h1").text("支付通道处理中");
				$(".cont p").text("第三方正在处理您的绑卡请求，请稍后刷新查看结果");
				$(".success_pop").show();
			}else {
				window.location.href="${ctx}" + info["url"];
			}
			/* if (info["type"] == 'tips') {
				$("#checkInfo").text(info["msg"]);
				$("#checkInfo").css("color","red");
			} else {
				window.location.href="${ctx}" + info["url"];
			} */
		}
	}
	
	function checkCredentials() {
		var credentialsType = $("#credentialsType").val();
		var idcard = $("#idcard").val();
		
		if (credentialsType == null || credentialsType == '') {
			$("#checkcredentials").text("请选择证件类型！");
			$("#checkcredentials").css("color","red");
			return false;
		} else {
			$("#checkcredentials").text("");
			$("#checkcredentials").css("color","white");
		}
		if (idcard == null || idcard == '') {
			$("#checkidcard").text("请输入证件号码！");
			$("#checkidcard").css("color","red");
			return false;
		} else {
			$("#checkidcard").text("");
			$("#checkidcard").css("color","white");
		}
		return true;
	}
	
	function getAllInPayStatus() {
		$.get("${ctx}/bankcard/getAllInPayStatus.htm",function(data){
			if(data == "success") {
				showAddCard();
			}
			if(data == "process") {
				return;
			}
		});
	}
	
</script>
		<%@ include file="/static/footer.jsp" %>
	</body>
</html>