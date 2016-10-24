<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/static/commonTags.jsp"%>
<meta name = "format-detection" content="telephone = no" />
<div class="bg top_bar">
	<div class="container">
		<p>
			客服热线   <em>4001-199-399</em>
		</p>
		<ul>
			<li>
				欢迎光临学呗！
			</li>
			<li>
				<a href="${ctx}/aboutus/querySecurity.htm">安全保障</a>
			</li>
			<li>
				<a href="javascript://">新手指引</a>
			</li>
			<li>
				<a href="${ctx}/aboutus/queryAboutUs.htm">关于我们</a>
			</li>
			<li>
				<a class="red" href="${ctx}/help.jsp">帮助中心</a>
			</li>
			<!-- <li>
				<a href="javascript://">App下载</a>
			</li> -->
			<li>
				<label></label>
			</li>
			<c:choose>
				<c:when test="${sessionScope.localUser==null}">
					<li class="user login">
						<a href="${ctx}/login/login.htm">请登录</a>
					</li>
					<li class="user reg">
						<a href="${ctx}/register.jsp">免费注册</a>
					</li>
				</c:when>
				<c:otherwise>
					<!--登录后show出welcome；hide（login，reg）-->
					<li class="user welcome">
						<p class="info">
							欢迎：<a onclick="window.location.href='${ctx}/borrowinvest/toinvest.htm'">${sessionScope.localUser.userName}</a>
						</p>
						<!--新消息数量：手机端显示，-->
						<p class="mess">
							<span onclick="window.location.href = '${ctx}/message/personMessage.htm'">${sessionScope.localUser.message}</span>
						</p>
						<p class="logout">
							<a href="${ctx}/system/logout.htm">退出</a>
						</p>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</div>

<div class="bg nav_warp">
	<div class="top_nav">
		<div class="container">
			<div class="left_logo">
				<a href="${ctx}/system/fquerysumway.htm"></a>
				<img alt="公司logo" title='公司logo' src="${ctx}/V2/img/bg/logo.png">
			</div>
			<a class="list_btn" href="javascript://"></a>
			<ul class="top_menu">
				<li><a href="${ctx}/system/fquerysumway.htm" class="<c:if test="${active==1}">active</c:if>">首页</a></li>
				<li><a href='javascript://' class="<c:if test="${active==2}">active</c:if>">新手专区</a></li>
				<li><a href='javascript://' class="<c:if test="${active==3}">active</c:if>">专享理财</a></li>
				<li><a href='javascript://' class="<c:if test="${active==4}">active</c:if>">盈享理财</a></li>
				<li class="senior_top">
					<span class="">
						<label>高端理财</label>
						<div class="sub_menu">
							<p class="item_1 ">
								<a href="javascript://">私募基金</a>
							</p>
							<p class="item_2">
								<a href="javascript://">券商理财</a>
							</p>
						</div>
					</span>
				</li>
				<li class="my_account">
					<c:choose>
						<c:when test="${sessionScope.localUser==null}">
							<a class="falsh_light" href="${ctx}/borrowinvest/toinvest.htm">我的学呗</a>
						</c:when>
						<c:otherwise>
							<a class="falsh_light" href="${ctx}/borrowinvest/toinvest.htm">我的学呗</a>
						</c:otherwise>
					</c:choose>
				</li>
			</ul>
		</div>
	</div>
</div>

<div class="right_menu">
	<ul>
		<c:if test="${not empty sessionScope.localUser}">
			<c:if test="${sessionScope.localUser.message > 0}">
				<li class="item_1" onclick='window.location.href="${ctx}/message/personMessage.htm"'><label><span>${sessionScope.localUser.message}</span></label></li>
			</c:if>
		</c:if>
		<li class="item_4">
			<label>
				<i class="fa fa-qrcode" aria-hidden="true"></i>
				<a href="javascript://">下载地址</a>
			</label>
			<p>
				<img src="${ctx}/V2/img/bg/iOS.png"/>
				<img class="android" src="${ctx}/V2/img/bg/Android.png"/>
				<span>IOS</span>
				<span class="android">Android</span>
			</p>
		</li>
		<li class="item_2">
			<label><a href="${ctx}/calculator/toCalculator.htm" target="_blank">投资计算</a></label>
		</li>
		<li class="item_3">
			<label>
				<a href="javascript://">客服热线</a>
			</label>
			<p>4001-199-399</p>
		</li>
		<li class="item_5">
			<label><a href="http://wpa.b.qq.com/cgi/wpa.php?ln=2&uin=4001199399" target="_blank">在线咨询</a></label>
		</li>
	</ul>
	<div class="arrowup">
		<i class="fa fa-angle-up"></i>
		<a href="javascript://">返回顶部</a>
	</div>
</div>