<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>支付指南_学呗互联网金融</title>
	</head>
	<body>
		<!--banner-->
		<%@ include file="/static/top.jsp" %>
		<div class="payZn_banner"></div>
		<!--充值、提现切换-->
		<div class="payZn_tit">
			<div>
				<a href="javascript://" class="pZ_t_1"><img src="${ctx}/img/btn/pZ_cz_hov.png"></a>
				<a href="javascript://"><img src="${ctx}/img/btn/pZ_tx.png"></a>
			</div>
		</div>
		<!--充值-->
		<div class="pZ_cz">
			<div><img src="${ctx}/img/pZ_cz.png"></div>
		</div>
		<!--提现-->
		<div class="pZ_tx">
			<div><img src="${ctx}/img/pZ_tx.png"></div>
		</div>
	</body>
	<%@ include file="/static/footer.jsp" %>
</html>
