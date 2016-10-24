<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<title>网站地图_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/public.css" />
		<link rel="stylesheet" href="${ctx}/css1000/wz_map1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/wz_map750.css" />
		<link rel="stylesheet" href="${ctx}/css720/wz_map720.css" />
	</head>
	<body>
		<%@ include file="/static/top.jsp" %>
		<div class="wz_map">
			<ul>
				<li>
					<a href="${ctx}/product/fqueryallproduct.htm?type=1">涨中宝</a>
					<a href="${ctx}/product/fqueryallproduct.htm?type=2">散标投资</a>
					<a href="${ctx}/product/fqueryallproduct.htm?type=3">债权转让</a>
					<a href="${ctx}/calculator/toCalculator.htm">投资计算器</a>
				</li>
				<li>
					<a href="${ctx}/newHandProduct/querynewhand.htm">新手引导</a>
					<a href="${ctx}/aboutus/querySecurity.htm">安全保障</a>
					<a href="${ctx}/aboutus/queryPayZn.htm">支付指南</a>
					<a href="${ctx}/borrow/querystaticborrow.htm">我要借款</a>
				</li>
				<li style="margin-left: 135px;">
					<a href="${ctx}/selfaboutus/a_CompanyProfile.jsp">公司简介</a>
					<a href="${ctx}/selfaboutus/a_Team.jsp">创始团队</a>
					<a href="${ctx}/selfaboutus/a_partners.jsp">合作伙伴</a>
					<a href="${ctx}/newsnotice/fqueryallnotice.htm">网站公告</a>
					<a href="${ctx}/newsinformation/fqueryallinformation.htm">行业新闻</a>
					<a href="${ctx}/selfaboutus/a_recruitment.jsp">招贤纳士</a>
					<a href="${ctx}/selfaboutus/a_contact.jsp">联系我们</a>
				</li>
				<li>
					<a href="${ctx}/register.jsp">注册</a>
					<a href="${ctx}/system/fquerysumway.htm">登录</a>
					<a href="${ctx}/zhPassword.jsp">找回登录密码</a>
				</li>
			</ul>
		</div>
		<%@ include file="/static/footer.jsp" %>
	</body>
</html>