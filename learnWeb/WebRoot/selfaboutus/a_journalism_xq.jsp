<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>行业新闻_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/about.css" />
        <link rel="stylesheet" href="${ctx}/css1000/a_journalism_xq1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/a_journalism_xq750.css" />
		<link rel="stylesheet" href="${ctx}/css720/a_journalism_xq720.css" />
		<script type="text/javascript">
			$(document).ready(function(){
				$(".toin_left_menu li:eq(5)").addClass('abo_me_click').siblings().removeClass('abo_me_click');
				//导航
				$(document).ready(function(){
					$(".list_nav li a").removeClass('nav_bor');
					$(".list_nav>li:eq(5)").find('a').addClass('nav_bor');
				})
			})
		</script>
	</head>
	<%@ include file="/static/top.jsp" %>
	<body>
		<div id="ab_body">
			<!--面包屑-->
			<div class="left_title">
				<a href="${ctx}/selfaboutus/a_CompanyProfile.jsp">关于我们</a><span>>&nbsp;行业新闻</span>
			</div>
			<!--左边查单栏-->
			<div class="left_menu">
			<%@ include file="/static/about_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="about_right_m">
				<!--标题-->
				<div class="journa_xq_title">
					<h3>${newsinfo.newstitle}</h3>
					<label><fmt:formatDate value="${newsinfo.createdate}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></label>
					<p style="display: none;">来源：中国广播网(北京）</p>
				</div>
				<!--正文-->
				<div class="not_xq_bod">
					${newsinfo.newscontent}
				</div>
				<!--返回列表-->
				<a href="javascript:void(0);" onclick="window.history.go(-1);" class="not_xq_fh">返回列表></a>
			</div>
		</div>
		<%@ include file="/static/footer.jsp"  %>
	</body>
</html>
