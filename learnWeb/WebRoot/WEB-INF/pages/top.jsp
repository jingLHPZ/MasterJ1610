<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/static/commonTags.jsp"%>
<!--top-->
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
				<a>帮助中心</a>
			</li>
			<li>
				<a>安全保障</a>
			</li>
			<li>
				<a>新手指引</a>
			</li>
			<li>
				<a>关于我们</a>
			</li>
			<li>
				<a>App下载</a>
			</li>
			<li>
				<label></label>
			</li>
			<li class="user login">
				<a>请登录</a>
			</li>
			<li class="user reg">
				<a>免费注册</a>
			</li>
			<!--登录后show出welcome；hide（login，reg）-->
			<li class="user welcome">
				<p class="info">
					欢迎：<a>XXXX</a>
				</p>
				<!--新消息数量：手机端显示，-->
				<p class="mess">
					<span>2</span>
				</p>
				<p class="logout">
					<a href="javascript://">退出</a>
				</p>
			</li>
		</ul>
	</div>
</div>

<div class="bg nav_warp">
	<div class="top_nav">
		<div class="container">
			<div class="left_logo"><a href="index.html"></a></div>
			<a class="list_btn" href="javascript://"></a>
			<ul class="top_menu">
				<li><a class="active">首页</a></li>
				<li><a>新手专区</a></li>
				<li><a>现金理财</a></li>
				<li><a>专享理财</a></li>
				<li><a>涨业贷</a></li>
				<li class="my_account">
					<a class="falsh_light">我的学呗</a>
				</li>
			</ul>
		</div>
	</div>
</div>

<div class="right_menu">
	<ul>
		<c:if test="${not empty sessionScope.localUser}">
			<c:if test="${sessionScope.localUser.message > 0}">
				<li class="item_1"><label><span>${sessionScope.localUser.message}</span></label></li>
			</c:if>
		</c:if>
		<li class="item_2">
			<label>
				
			</label>
		</li>
		<li class="item_3">
			<label>
			</label>
			<p>4001-199-399</p>
		</li>
		<li class="item_5">
			<label>
			</label>
		</li>
	</ul>
	<div class="arrowup">
		<i class="fa fa-angle-up"></i>
	</div>
</div>