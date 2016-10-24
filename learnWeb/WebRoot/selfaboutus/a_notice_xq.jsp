<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>网站公告_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/about.css" />
		<link rel="stylesheet" href="${ctx}/css1000/a_notice_xq1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/a_notice_xq750.css" />
		<link rel="stylesheet" href="${ctx}/css720/a_notice_xq720.css" />
		<script type="text/javascript">
			$(document).ready(function(){
				$(".toin_left_menu li:eq(4)").addClass('abo_me_click').siblings().removeClass('abo_me_click');
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
			<div class="left_title">
				<a href="${ctx}/selfaboutus/a_CompanyProfile.jsp">关于我们</a><span>>&nbsp;网站公告</span>
			</div>
			<!--左边查单栏-->
			<div class="left_menu">
					<%@ include file="/static/about_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="about_right_m">
				<!--标题-->
					<div class="not_xq_title"> 
						<h3>${newsnotice.newstitle}</h3>
						<label><fmt:formatDate value="${newsnotice.createdate}" type="both" pattern='yyyy-MM-dd'/></label>
					</div>
					<!--正文-->
					<div class="not_xq_bod">
						<!-- 亲爱的学呗用户：<br />
						您好！<br /><br />
						学呗拉新活动大升级！新版拉新活动会于2015年10月18日开始，凡是用户成功注册，可获得共100元的投资红包，投资红包可抵冲学呗理财产品部分投资金额。（具体以活动上线时间为准）<br /><br /> -->
						${newsnotice.newscontent}
					</div>
				<!--返回列表-->
				<a href="${ctx}/newsnotice/fqueryallnotice.htm" class="not_xq_fh">返回列表></a>
			</div>
		</div>
		<%@ include file="/static/footer.jsp"  %>
	</body>
</html>
