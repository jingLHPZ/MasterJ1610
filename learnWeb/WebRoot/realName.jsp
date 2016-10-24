	<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>实名认证_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/personal.css" />
		<script type="text/javascript" src="${ctx}/js/jquery-1.7.2.js" ></script>
		<script type="text/javascript" src="${ctx}/js/validateCard.js"></script>
	</head>
	<body>
	<%-- <%@ include file="/static/top.jsp" %> --%>
		<div class="smrz_posi">
		<form id="formReal" method="post">
			<div class="smr_bloak">
				<a href="javascript:void(0)" class="smr_clor" onclick="javascript:$('.smrz_posi').hide();"></a>
				<h3>实名认证</h3>
				<p class="smr_alert"><!--身份证号码格式不正确！--></p>
				<p><label>真实姓名</label><input type="text" name="formName" onblur="validateRealName(this)"/><font id="aErr" style="color:red;display: none;">请输入中文</font></p>
				
				<p><label>身份证号</label><input type="text" name="formCard" onblur="validateIdcard(this)"/><font id="bErr" style="color:red;display: none;">身份证错误</font></p>
				
				<input type="button" name="" id="realA" value="确认" class="smr_btn" onclick="submitRealName()"/>
				<a class="open_gat" href="${ctx}/person/editPerson.htm?headFlag=102">（ 港澳臺居民請點擊這裡&gt;&gt;）</a>
			</div>
			</form>
		</div>
		<!-- <div class="smrz_bod"></div> -->
		<div class="password_alert" id="formClose" style="display: none;">
						<div class="ps_al_bod">
							<h1>您已修改成功！</h1>
							<p>2S&nbsp;后自动返回...</p>
						</div>
		</div>
		<!-- <script type="text/javascript" src="static/footer.js"></script> -->
		<script type="text/javascript">
		function validateRealName(obj){
			 var chinese = /^[\u4e00-\u9fa5]+$/;
			 if(!chinese.test(obj.value)){
				 $("#aErr").show();
			 }else{
				 $("#aErr").hide();
			 }
		}
		function validateIdcard(obj){
			var checkIdCard = new IdCardValidate(obj.value);
			//var card=/(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
			 if(!checkIdCard.IsValid()){
				 $("#bErr").show();
			 }else{
				 $("#bErr").hide();
			 }
		}
		var commitFlag = 0;
		function submitRealName(){
			if($("input[name='formName']").val()==''){
				$("#aErr").show();
			}else if($("input[name='formCard']").val()==''){
				$("#bErr").show();
			}
			if(commitFlag !=0)return;
			commitFlag = 1;
			if($("#aErr").is(":hidden")&&$("#bErr").is(":hidden")){
				$('#realA').val("验证中.....");
				$('#realA').unbind('click', submitRealName);//取消RecommandProduct 函数
			}
			if($("#aErr").is(":hidden")&&$("#bErr").is(":hidden")){
				$.ajax({
					type : "post",
					url : "/person/submitRealName.htm",
					data : {'realName':$("input[name='formName']").val(),'idcard':$("input[name='formCard']").val()},
					dataType : "text",
					success : function(data) {
						commitFlag = 0;
						$('#realA').val("确定");
						$('#realA').bind('click', submitRealName);
						if(data=="success"){
							$(".smr_alert").hide();
							$('.smrz_posi').hide();
							$('#formClose').show();
							$(".menu_bod .menu_b1 .wd_ls4 .ls_bg1").css('background','${ctx}/img/icon/sfrz_icon.png');
							$(".menu_bod .menu_b1 .wd_ls4 .ls_bg1").css('background-position','0px -34px');
							setTimeout("backForm()",2000);
						}else if(data=="numsErr"){
							$(".smr_alert").show();
							$(".smr_alert").html('错误次数超过3次，请联系客服！');
						}else if(data=="numsCardErr"){
							$(".smr_alert").show();
							$(".smr_alert").html('此身份证已被注册，认证失败！');
						}else{
							$(".smr_alert").show();
							$(".smr_alert").html(data);
						}
						
					}
				});
			}
			
		}
		function backForm(){
			$('#formClose').hide();
		}
		</script>
	</body>
</html>