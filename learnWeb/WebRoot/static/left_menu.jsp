<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script type="text/javascript">
	var count = 1;
 	$(function(){
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
 		$(".menu_bod .menu_b1 .wd_ls5 .leve_bod").css("width",count/4*100 + "%");
	})
</script>
		<div id="left_menu">
			<!--面包屑-->
			<div class="bg tp_crumb">
				<div class="container" id="left_title">
					<a href="${ctx}/system/fquerysumway.htm">首页</a>&gt;
					<a href="${ctx}/borrowinvest/toinvest.htm">我的账户</a>><span class="active">我的投资</span>
				</div>
			</div>
			<!--侧边导航-->
			<div class="menu_bod">
				<!--用户信息-->
				<div class="menu_b1">
					<ul>
						<li class="wd_ls1">
						<c:choose>
							<c:when test="${sessionScope.localUser.headshotUrl eq ''}">
								<a href="${ctx}/person/editPerson.htm?headFlag=1"><img src="${ctx}/img/icon/superman.gif" /></a>
							</c:when>
							<c:otherwise>
								<a href="${ctx}/person/editPerson.htm?headFlag=1"><img src="${sessionScope.localUser.headshotUrl}" /></a>
							</c:otherwise>
						</c:choose>
						
						</li>
						<li class="wd_ls2" title="Hi!${sessionScope.localUser.userName}">Hi!${sessionScope.localUser.userName}</li>
						<li class="wd_ls3">总积分： 
						<c:choose>
							<c:when test="${empty sessionScope.localUser.totalScore}">
							 0
							</c:when>
							<c:otherwise>
							${sessionScope.localUser.totalScore}
							</c:otherwise>
						</c:choose>
						</li>
						<li class="wd_ls4">
							<p onclick="window.location.href='${ctx}/person/editPerson.htm?tag=2'" class="<c:if test='${sessionScope.localUser.isRealName==1}'>ls_bg1</c:if><c:if test='${sessionScope.localUser.isRealName==0}'>ls_bga1</c:if>"  title="实名认证"></p><!-- 亮 -->
							<p onclick="window.location.href='${ctx}/person/editPerson.htm'" class="ls_bg2"  title="绑定手机" ></p><!-- 亮 -->
							<p class="<c:if test='${sessionScope.localUser.isAddCard==0}'>ls_bg3</c:if><c:if test='${sessionScope.localUser.isAddCard==1}'>ls_bgl3</c:if>"  title="绑定银行卡"></p><!--暗 -->
							<p onclick="window.location.href='${ctx}/person/editPerson.htm?tag=1'" class="<c:if test='${empty sessionScope.localUser.userEmail}'>ls_bg4</c:if><c:if test='${not empty sessionScope.localUser.userEmail}'>ls_bgl4</c:if>"  title="邮箱认证"></p><!-- 暗 -->
						</li>
						<li class="wd_ls5">
							<label>安全等级</label>
							<div class="leve_line">
								<div class="leve_bod"></div>
							</div>
						</li>
					</ul>
				</div>
				<div class="menu_tit" onclick="window.location.href='${ctx}/borrowinvest/toinvest.htm'">我的账户首页</div>
				<!--投资管理-->
				<div class="menu_b2">
					<h4>投资管理<span>(2)</span></h4>
					<div class="b2_main">
						<ul>
							<li class="mb_bg3" >我的投资</li>
							<li class="mb_bg1" >更多交易</li>
						</ul>
					</div>
				</div>
				<!--资产管理-->
				<div class="menu_b2">
					<h4>资产管理<span>(4)</span></h4>
					<div class="b2_main">
						<ul>
							<li class="mb_bg5">充值</li>
							<li class="mb_bg6">提现</li>
							<li class="mb_bg7">资金明细</li>
							<li class="mb_bg8">银行卡</li>
						</ul>
					</div>
				</div>
				<!--已赚奖励-->
				<div class="menu_b2">
					<h4>已赚奖励<span>(4)</span></h4>
					<div class="b2_main">
						<ul>
							<li class="mb_bg15" >体验金</li>
							<li class="mb_bg16" >邀请好友</li>
							<li class="mb_bg17">积分奖励</li>
							<li class="mb_bg18">卡券包</li>
						</ul>
					</div>
				</div>
				<!--个人资料-->
				<div class="menu_b2">
					<h4>个人资料<span>(2)</span></h4>
					<div class="b2_main">
						<ul>
							<li class="mb_bg11" onclick="window.location.href='${ctx}/person/editPerson.htm'">账户设置</li>
							<!-- <li class="mb_bg12">安全验证</li> -->
						    <!-- <li class="mb_bg13">密码管理</li> -->
							<li class="mb_bg14" onclick="window.location.href='${ctx}/message/personMessage.htm'">我的消息</li>
						</ul>
					</div>
				</div>
				<!--借款管理-->
				<div class="menu_b2">
					<h4>借款管理<span>(1)</span></h4>
					<div class="b2_main">
						<ul>
							<li class="mb_bg9">我的借款</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<script>
		$(document).ready(function(){
			$(".list_nav li a").removeClass('nav_bor');
			$(".list_nav>li:eq(6)").find('a').addClass('nav_bor');
			$("#left_title span").text(english($("title").text().replace("_学呗互联网金融","")));
			function english(s){ 
				var pattern = new RegExp("[a-zA-Z`~!@#$^&*()-_-——]");
				var rs = ""; 
				for (var i = 0; i < s.length; i++) { 
					rs = rs+s.substr(i, 1).replace(pattern, ''); 
				} 
				return rs; 
			}
		})
		
		
		</script>