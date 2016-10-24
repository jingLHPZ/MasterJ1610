<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>合作伙伴_关于我们_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/about.css" />
		<link rel="stylesheet" href="${ctx}/css1000/a_contact1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/a_contact750.css" />
		<link rel="stylesheet" href="${ctx}/css720/a_contact720.css" />
		<script type="text/javascript">
			$(document).ready(function(){
				$(".toin_left_menu li:eq(7)").addClass('abo_me_click').siblings().removeClass('abo_me_click');
				//导航
				$(document).ready(function(){
					$(".list_nav li a").removeClass('nav_bor');
					$(".list_nav>li:eq(5)").find('a').addClass('nav_bor');
				})
			})
		</script>
	</head>
	<body>
		<%@ include file="/static/top.jsp" %>
		<div id="ab_body">
			<!--面包屑-->
			<div class="bg tp_crumb">
				<div class="container">
					<a href="${ctx}/system/fquerysumway.htm">首页</a>&gt;
					<a href="${ctx}/selfaboutus/a_CompanyProfile.jsp">关于我们</a><span class="active">>&nbsp;联系我们</span>
				</div>
			</div>
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/about_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="about_right_m">
				<!--地图-->
				<img src="${ctx}/img/map.jpg" class="cont_map">
				<!--联系方式-->
				<ul class="cont_list">
					<li class="cont_li1">
						<b>地址</b>
						上海市黄浦区马当路388号SOHO复兴广场A座22层2203室
					</li>
					<li class="cont_li2">
						<b>电话</b>
						4001-199-399 / 021-63311199
					</li>
					<li class="cont_li3">
						<b>邮箱</b>
						kefu@51zhangbei.com
					</li>
					<li class="cont_li4">
						<b>网址</b>
						www.51zhangbei.com
					</li>
				</ul>
			</div>
		</div>
		<%@ include file="/static/footer.jsp"  %>
	</body>
</html>
