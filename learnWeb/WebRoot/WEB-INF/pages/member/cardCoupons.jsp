<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>我的卡券包_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/integration.css" />
		<link rel="stylesheet" href="${ctx}/css/cardCoupons.css" />
		<link rel="stylesheet" href="${ctx}/css1000/cardCoupons1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/cardCoupons750.css" />
		<link rel="stylesheet" href="${ctx}/css720/cardCoupons720.css" />
	</head>
	<script type="text/javascript">
	var is_num = false;
	var is_kaptcha = false;
	var rewardtype;
	var usetype;
	$(function() {//生成验证码
		$(".cap_error").hide();
		flushYzm();
		$(".hb_lqbtn").click(function(){
			$(".hb_alert").hide();
		}) 
		rewardtype = $("#rewardtype").val();
		usetype = $("#usetype").val();
	});
	function flushYzm() {
		$("#kaptchaImage").hide().attr('src','${ctx}/captcha-image.htm?'+ Math.floor(Math.random() * 100)).fadeIn();
	}
	
	//编码空值判断
	 function numcheck() {
		 var num=$(".cap_winp_txt").val();
		 $("#num").html("");
		 if(num==null||num.trim()==''){
		    $("#num").show();
			$("#num").html("编码不能为空！");
			is_num = false;
			return;
		 } else {
			 is_num = true;
		 }
	 }
	//验证码判断
	 function kaptchacheck() {
		var kaptcha=$("#inputyzm").val();
		$("#kaptcha").html("");
		if(kaptcha == null || kaptcha.trim() == "") {
			flushYzm();
			$("#kaptcha").show();
			$("#kaptcha").html("验证码不能为空！");
			is_kaptcha = false;
			return;
		}else {
			is_kaptcha = true;
		}
	 }
	//立即领取
	 function checkalls(){
		numcheck();
		kaptchacheck();
		var is_correctyzm = false;
		var is_correctnum = false;
		if(is_num && is_kaptcha) {
			//判断验证码是否正确
			$.ajax({
				type : "post",
				url : "${ctx}/login/kaptchaVer.htm",
				data : {
					kaptcha : $("#inputyzm").val()
				},
				async:false,
				dataType : "text",
				success : function(data) {
					if (data == 0) {
						is_correctyzm = false;
						$("#kaptcha").show();
						$("#kaptcha").html("验证码不正确！");
						flushYzm();
						return;
					}else{
						flushYzm();
						is_correctyzm = true;
					}
				}
			});
		}
		//判断编码是否正确
		if(is_num && is_kaptcha && is_correctyzm) {
			$.ajax({
	    		type : "post",
	    		url : "${ctx}/membercardcoupons/checkcardbm.htm",
	    		data : {
	    			'bm' : $(".cap_winp_txt").val(),"rewardtype":$("#rewardtype").val()
	    		},
	    		async:false,
	    		dataType : "text",
	    		success : function(data) {
	    			var datas=JSON.parse(data);
	    			if (datas.tag == 0) {
	    				$("#num").show();
	    				$("#num").html("编码不能不为空！");
	    				is_correctnum = false;
	    				flushYzm();
	    				return;
	    			}else if(datas.tag == 1){
    					 $(".cap_winp_txt").val("");
						 $(".cap_winp_txt").focus();
						 is_correctnum = false;
						 $(".hb_alert").show().find(".hb_Lqsb").show().prev().hide();
						 flushYzm();
						 return;
	    			}else if(datas.tag == 2){
	    				if(datas.proValue!=null){
	    					if($("#rewardtype").val() == "2") {
		    					$(".hb_Lqcg").find("h3").html("<h3>恭喜，您已成功领取加息券<b>100</b>%！</h3>");
	    					}
	    					if($("#rewardtype").val() == "3") {
	    						$(".hb_Lqcg").find("h3").html("<h3>恭喜，您已成功领取投资红包<b>100</b>元！</h3>");
	    					}
	    					$(".hb_alert").find(".hb_Lqcg").find("b").text(datas.proValue);
	    					 flushYzm();
	    				}
	    				is_correctnum = true;
	    			}
	    		}
	    	});
		}
		
		//编码正确，领取奖励
		if(is_correctnum) {
			$.ajax({
				type : "post",
	    		url : "${ctx}/membercardcoupons/updateRewardRecordById.htm",
	    		data : {
	    			'content' : $(".cap_winp_txt").val()
	    		},
	    		async:false,
	    		dataType : "json",
	    		success:function(data) {
	    			if(data.result == "success") {
	    				$(".hb_alert").show().find(".hb_Lqcg").show().prev().hide();
	    				$(".hb_Lqsb").hide();
	    				$("#content").val("");
	    				$("#inputyzm").val("");
	    				flushYzm();
	    				return;
	    			}else {
	    				flushYzm();
	    				return;
	    			}
	    		}
			});
		}
	}
	
	function iknow() {
		$.ajax({
			url:"${ctx}/membercardcoupons/querypage.htm",
			type:"POST",
			data:{"rewardtype":$("#rewardtype").val(),"usetype":$("#usetype").val()},
			success:function(result) {
				if($("#rewardtype").val() == "1") {
					$('#cashFormList').html(result);
				}
				if($("#rewardtype").val() == "2" && $("#usetype").val() == "1") {
					$('#interestFormList').html(result);
				}
				if($("#rewardtype").val() == "2" && $("#usetype").val() == "0") {
					$('#uninterestFormList').html(result);
				}
				if($("#rewardtype").val() == "3" && $("#usetype").val() == "1") {
					$('#investFormList').html(result);
				}
				if($("#rewardtype").val() == "3" && $("#usetype").val() == "0") {
					$('#unInvestFormList').html(result);
				}
			}
		});
	}
	
	 function cash() {
		 flushYzm();
		 $(".cap_winp_txt").val("");
		 $("#inputyzm").val("");
		 $("#rewardtype").val("1");
		 $("#numName").html("输入现金红包编码");
		 $(".hb_Lqsb").find("h3").html("对不起，您的红包编码无效或已过期");
		 $("#num").hide();
		 $("#kaptcha").hide();
		 iknow();
	 }
	 
	 function ticket() {
		 flushYzm();
		 $(".cap_winp_txt").val("");
		 $("#inputyzm").val("");
		 $("#rewardtype").val("2");
		 $("#usetype").val("0");
		 $("#numName").html("输入加息券编码");
		 $(".hb_Lqsb").find("h3").html("对不起，您的加息券编码无效或已过期");
		 $("#num").hide();
		 $("#kaptcha").hide();
		 iknow();
	 }
	 
	 function red() {
		 flushYzm();
		 $(".cap_winp_txt").val("");
		 $("#inputyzm").val("");
		 $("#rewardtype").val("3");
		 $("#usetype").val("0");
		 $("#numName").html("输入投资红包编码");
		 $(".hb_Lqsb").find("h3").html("对不起，您的投资红包编码无效或已过期");
		 $("#num").hide();
		 $("#kaptcha").hide();
		 iknow();
	 }
	 
	function use() {
		 $("#usetype").val("1");
		 iknow();
	 }
	 function unuse() {
		 $("#usetype").val("0");
		 iknow();
	 }
	 
	 function queryCashPage(pageNo,totalCount,pageSize) {
			var pars = $("#cashForm").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
			$.ajax({
				type: "POST",
				url: "${ctx}/membercardcoupons/querypage.htm?rewardtype=1&usetype=1",
				data: pars,
				success: function(result) {
					$('#cashFormList').html(result);
				}
			}); 
		}
	 
	 function queryUnInvestPage(pageNo,totalCount,pageSize) {
			var pars = $("#unInvestForm").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
			$.ajax({
				type: "POST",
				url: "${ctx}/membercardcoupons/querypage.htm?rewardtype=3&usetype=0",
				data: pars,
				success: function(result) {
					$('#unInvestFormList').html(result);
				}
			}); 
		}
	 
	 function queryInvestPage(pageNo,totalCount,pageSize) {
			var pars = $("#investForm").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
			$.ajax({
				type: "POST",
				url: "${ctx}/membercardcoupons/querypage.htm?rewardtype=3&usetype=1",
				data: pars,
				success: function(result) {
					$('#investFormList').html(result);
				}
			}); 
		}
	 
	 function queryUnInterestPage(pageNo,totalCount,pageSize) {
			var pars = $("#uninterestForm").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
			$.ajax({
				type: "POST",
				url: "${ctx}/membercardcoupons/querypage.htm?rewardtype=2&usetype=0",
				data: pars,
				success: function(result) {
					$('#uninterestFormList').html(result);
				}
			}); 
		}
	 
	 function queryInterestPage(pageNo,totalCount,pageSize) {
			var pars = $("#interestForm").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
			$.ajax({
				type: "POST",
				url: "${ctx}/membercardcoupons/querypage.htm?rewardtype=2&usetype=1",
				data: pars,
				success: function(result) {
					$('#interestFormList').html(result);
				}
			}); 
		}
	
	</script>
	<body>
	<%@ include file="/static/top.jsp" %>
	<div class="content_body">
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/left_menu.jsp" %>
			</div>
			<!--右边主体-->
			<input type="hidden" id="rewardtype" value="1">
			<input type="hidden" id="usetype" value="0">
			<div class="right_main">
				<div class="integ_tit">
					<h2>我的卡券包</h2>
					<div>
						<a href="javascript:cash()" class="int_t_h"><span>我的现金红包</span></a>
						<a href="javascript:red()"><span>我的投资红包</span></a>
						<a href="javascript:ticket()"><span>我的加息券</span></a>
					</div>
				</div>
				<!--kaishi-->
				<form id="unForm">
					<div class="card_dhd">
						<ul>
							<li>
								<label id="numName">输入现金红包编码</label>
								<input type="text" id="content" name="content" class="cap_winp_txt" onblur="numcheck()" />
								<p id="num" class="an" style="display:none">编码不正确</p>
							</li>
							<li>
								<label>输入验证码</label>
								<input id="inputyzm" type="text" name="" class="cap_winp_txt cap_yam" onblur="kaptchacheck()"/>
								<div class="cap_yzmImg"><img src="${ctx}/captcha-image.htm" id="kaptchaImage"></div>
								<a href="javascript://" class="cap_yzmHref" onclick="flushYzm()"></a>
								<p id="kaptcha" class="an" style="display:none">验证码不正确</p>
							</li>
							<li>
								<input type="button" name="" value="立即领取" class="cap_winp_btn" onclick="checkalls();" />
							</li>
						</ul>
						<!--领取红包提示框-->
						<div class="hb_alert">
							<div class="hb_a_bod">
								<!--领取成功-->
								<div class="hb_Lqcg">
									<h3>恭喜，您已成功领取现金红包<b>100</b>元！</h3>
									<p>奖励将在稍后发放至您的学呗账户</p>
								</div>
								<!--领取未成功-->
								<div class="hb_Lqsb">
									<h3>对不起，您的红包编码无效或已过期</h3>
								</div>
								<!--我知道了-->
								<input type="button" name="" value="我知道了" class="hb_lqbtn" onclick="iknow()" />
							</div>
						</div>
					</div>
				</form>
				<!--end-->
				<!--我的现金红包-->
				<div class="cadCop_bod cp_show">
					<p class="cadCop_ttab">
						<!-- <label>现金红包状态</label>
						<a href="javascript://" class="cadC_tHov">未领取</a>
						<a href="javascript://">已领取</a> -->
					</p>
					<!--未领取-->
					<form id="cashForm">
					<div class="cap_zt cap_wlq" id="cashFormList">
					 <div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="23%">红包编码</th>
								<th width="23%">名称</th>
								<th width="23%">金额</th>
								<th width="31%">领取时间</th>
							</tr>
							<c:choose>
								<c:when test="${empty getcashredlist.result}">
									<tr><td colspan="4"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${getcashredlist.result}" var="cashred">
										<tr>
											<td>${cashred.content}</td>
											<td>${cashred.proValue}元
												<c:if test="${cashred.type==1}">
												现金红包
												</c:if>
												<c:if test="${cashred.type==2}">
												加息券
												</c:if>
												<c:if test="${cashred.type==3}">
												投资红包
												</c:if>
											</td>
											<td><fmt:formatNumber value="${cashred.proValue}" pattern="#,##0.00#"/>元</td>
											<td><fmt:formatDate value="${cashred.useTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
						</div>
						<!--分页-->
						<c:choose>
							<c:when test="${empty getcashredlist.result}"></c:when>
							<c:otherwise>
								<div class="cadCop_pg">
									<div class="page_fy">
										<li:pagination methodName="queryCashPage" pageBean="${getcashredlist}" sytleName="page_fy"/>
									</div>
						    	</div>
				    		</c:otherwise>
						</c:choose>
					</div>
					</form>
					<!--已领取-->
					<div class="cap_zt cap_ylq">
						
					</div>
				</div>
				<!--我的投资红包-->
				<div class="cadCop_bod">
					<p class="cadCop_ttab">
						<label>投资红包状态</label>
						<a href="javascript:unuse()" class="cadC_tHov">未使用</a>
						<a href="javascript:use()">已使用</a>
						<a href="${ctx}/iReward/loadIntegralReward.htm?flag=investred" class="dh_more">兑换更多></a>
					</p>
					<!--未使用-->
					<form id="unInvestForm">
					<div class="cap_zt cap_wlq cap_wsy" id="unInvestFormList">
					<div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="20%">名称</th>
								<th width="12%">金额</th>
								<th width="21%">领取时间</th>
								<th width="21%">过期时间</th>
								<th width="24%">备注</th>
							</tr>
							<c:choose>
								<c:when test="${empty investrednolist.result}">
									<tr><td colspan="5"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${investrednolist.result}" var="investredno">
										<tr>
											<td align="left">
											    <fmt:formatNumber value="${investredno.proValue}" pattern="#,##0.00#"/>
												<c:if test="${investredno.type==1}">
												现金红包
												</c:if>
												<c:if test="${investredno.type==2}">
												加息券
												</c:if>
												<c:if test="${investredno.type==3}">
												投资红包
												</c:if>
											</td>
											<td><fmt:formatNumber value="${investredno.proValue}" pattern="#,##0.00#"/>元</td>
											<td><fmt:formatDate value="${investredno.useTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<td><fmt:formatDate value="${investredno.expireTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<td>${investredno.memo}</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
						</div>
						<!--分页-->
						<c:choose>
							<c:when test="${not empty investrednolist.result}">
								<div class="cadCop_pg">
									<div class="page_fy">
										<li:pagination methodName="queryUnInvestPage" pageBean="${investrednolist}" sytleName="page_fy"/>
									</div>
						    	</div>
				    		</c:when>
						</c:choose>
					</div>
					</form>
					<!--已使用-->
					<form id="investForm">
					<div class="cap_zt cap_ylq" id="investFormList">
					<div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="20%">名称</th>
								<th width="12%">金额</th>
								<th width="21%">领取时间</th>
								<th width="21%">使用时间</th>
								<th width="24%">使用项目</th>
							</tr>
							<c:choose>
								<c:when test="${empty investredusedlist.result}">
									<tr><td colspan="5"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${investredusedlist.result}" var="investredused">
										<tr>
											<td align="left">
										    	<fmt:formatNumber value="${investredused.proValue}" pattern="#,##0.00#"/>元
											    <c:if test="${investredused.type==1}">
												现金红包
												</c:if>
												<c:if test="${investredused.type==2}">
												加息券
												</c:if>
												<c:if test="${investredused.type==3}">
												投资红包
												</c:if>
											</td>
											<td><fmt:formatNumber value="${investredused.proValue}" pattern="#,##0.00#"/>元</td>
											<td><fmt:formatDate value="${investredused.useTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<td><fmt:formatDate value="${investredused.updateTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<td>${investredused.productName}</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
						</div>
						<!--分页-->
						<c:choose>
							<c:when test="${empty investredusedlist.result}"></c:when>
							<c:otherwise>
								<div class="cadCop_pg">
									<div class="page_fy">
										<li:pagination methodName="queryInvestPage" pageBean="${investredusedlist}" sytleName="page_fy"/>
									</div>
						    	</div>
				    		</c:otherwise>
						</c:choose>
					</div>
					</form>
				</div>
				<!--我的加息券-->
				<div class="cadCop_bod">
					<p class="cadCop_ttab">
						<label>加息券状态</label>
						<a href="javascript:unuse()" class="cadC_tHov">可使用</a>
						<a href="javascript:use()">已使用</a>
					</p>
					<!--可使用-->
					<form id="uninterestForm">
					<div class="cap_zt cap_wlq cap_wsy" id="uninterestFormList">
					<div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="20%">名称</th>
								<th width="21%">领取时间</th>
								<th width="24%">过期时间</th>
								<th width="34%">备注</th>
							</tr>
							<c:choose>
								<c:when test="${empty addinterestnolist.result}">
									<tr><td colspan="4"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${addinterestnolist.result}" var="addinterestno">
										<tr>
											<td align="left">
											<fmt:formatNumber type="number" value="${addinterestno.proValue*100}" pattern="##0.00" maxFractionDigits="2"/>%
											    <c:if test="${addinterestno.type==1}">
												现金红包
												</c:if>
												<c:if test="${addinterestno.type==2}">
												加息券
												</c:if>
												<c:if test="${addinterestno.type==3}">
												投资红包
												</c:if>
											</td>
											<td><fmt:formatDate value="${addinterestno.useTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<td><fmt:formatDate value="${addinterestno.expireTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
									        <td>${addinterestno.memo}</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
						</div>
						<!--分页-->
						<c:choose>
							<c:when test="${empty addinterestnolist.result}"></c:when>
							<c:otherwise>
								<div class="cadCop_pg">
									<div class="page_fy">
										<li:pagination methodName="queryUnInterestPage" pageBean="${addinterestnolist}" sytleName="page_fy"/>
									</div>
						    	</div>
				    		</c:otherwise>
						</c:choose>
					</div>
					</form>
					<!--已使用-->
					<form id="interestForm">
					<div class="cap_zt cap_ylq" id="interestFormList">
					 <div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="20%">名称</th>
								<th width="21%">领取时间</th>
								<th width="24%">使用时间</th>
								<th width="34%">使用项目</th>
							</tr>
							<c:choose>
							    <c:when test="${empty addinterestusedlist.result}">
									<tr><td colspan="5"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${addinterestusedlist.result}" var="addinterestuse">
											<tr>
												<td align="left">
												<fmt:formatNumber type="number" value="${addinterestuse.proValue*100}" pattern="##0.00" maxFractionDigits="2"/>%
											    <c:if test="${addinterestuse.type==1}">
												现金红包
												</c:if>
												<c:if test="${addinterestuse.type==2}">
												加息券
												</c:if>
												<c:if test="${addinterestuse.type==3}">
												投资红包
												</c:if>
												</td>
												<td><fmt:formatDate value="${addinterestuse.useTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
												<td><fmt:formatDate value="${addinterestuse.updateTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
												<td>${addinterestuse.productName}</td>
											</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
						</div>
						<!--分页-->
						<c:choose>
							<c:when test="${empty addinterestusedlist.result}"></c:when>
							<c:otherwise>
								<div class="cadCop_pg">
									<div class="page_fy">
										<li:pagination methodName="queryInterestPage" pageBean="${addinterestusedlist}" sytleName="page_fy"/>
									</div>
						    	</div>
				    		</c:otherwise>
						</c:choose>
					</div>
					</form>
				</div>
			</div>
		</div>
		<%@ include file="/static/footer.jsp" %>
	</body>
</html>