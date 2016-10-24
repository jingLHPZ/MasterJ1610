<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>新手指引_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/guide.css" />
		<link rel="stylesheet" href="${ctx}/css1000/guide1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/guide750.css" />
		<link rel="stylesheet" href="${ctx}/css720/guide720.css" />
		<script type="text/javascript">
			//导航
			$(document).ready(function(){
				$(".list_nav li a").removeClass('nav_bor');
				$(".list_nav>li:eq(4)").find('a').addClass('nav_bor');
			})
		</script>
	</head>
	<body>
	<%@ include file="/static/top.jsp" %>
		<!--banner-->
		<div class="guide_banner"></div>
		
		<!--新手投资指引-->
		<div class="guide_d0">
			<div class="cont">
				<h3>新手投资指引</h3>
				<img src="${ctx}/img/guide_00.png"/>
			</div>
		</div>
		
		<!--注册-->
		<div class="guide_d1 guide_bg">
			<div class="cont">
				<div class="title">
					<b>1</b>
					<h1>注册</h1>
					<p>进入www.51zhangbei.com,点击右上角“注册”，完成相关操作即可完成注册。</p>
				</div>
				<img src="${ctx}/img/guide_01.png"/>
			</div>
		</div>
		
		<!--实名认证-->
		<div class="guide_d2 guide_bg">
			<div class="cont">
				<div class="title">
					<b>2</b>
					<h1>实名认证</h1>
					<p>进入“个人中心”，点击实名认证图标，完成相关操作即可完成实名认证。</p>
				</div>
				<img src="${ctx}/img/guide_02.png"/>
			</div>
		</div>
		
		<!--充值-->
		<div class="guide_d3 guide_bg">
			<div class="cont">
				<div class="title">
					<b>3</b>
					<h1>充值</h1>
					<p>进入“个人中心”，点击“充值”，进入充值界面，完成后续相关操作即可成功充值。</p>
				</div>
				<img src="${ctx}/img/guide_03.png"/>
			</div>
		</div>
		
		<!--投资-->
		<div class="guide_d4 guide_bg">
			<div class="cont">
				<div class="title">
					<b>4</b>
					<h1>投资</h1>
					<p>点击“我要投资”，选择所要投资项目，确认标的符合投资要求，再完成相关操作即可成功投资。</p>
				</div>
				<img src="${ctx}/img/guide_04.png"/>
			</div>
		</div>
		
		<!--收息-->
		<div class="guide_d5 guide_bg">
			<div class="cont">
				<div class="title">
					<b>5</b>
					<h1>收息</h1>
					<p>学呗上线送钱啦！注册就送10000体验金！</p>
					<div class="secu_resgi" onclick="window.location.href='${ctx}/register.jsp'"></div>
				</div>
				<img src="${ctx}/img/guide_05.png"/>
			</div>
		</div>
		
		<%@ include file="/static/footer.jsp" %>
	</body>
</html>
