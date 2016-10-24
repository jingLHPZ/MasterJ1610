<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
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
		<link rel="stylesheet" href="${ctx}/css1000/a_partners1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/a_partners750.css" />
		<link rel="stylesheet" href="${ctx}/css720/a_partners720.css" />
		<script type="text/javascript">
			$(document).ready(function(){
				$(".toin_left_menu li:eq(3)").addClass('abo_me_click').siblings().removeClass('abo_me_click');
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
					<a href="${ctx}/selfaboutus/a_CompanyProfile.jsp">关于我们</a><span class="active">>&nbsp;合作伙伴</span>
				</div>
			</div>
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/about_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="about_right_m">
				<!--银行-->
				<div class="partn_div">
					<h3>银行</h3>
					<ul>
						<li onclick="javascript:window.open('http://www.ccb.com')" target="_blank"><img src="${ctx}/img/partners/zgjsyh.png"></li>
						<li  onclick="javascript:window.open('http://www.cmbc.com.cn')" target="_blank"><img src="${ctx}/img/partners/zgmsyh.png"></li>
						<li onclick="javascript:window.open('http://www.boc.cn')"><img src="${ctx}/img/partners/zgyh.png"></li>
					</ul>
				</div>
				<!--证券-->
				<div class="partn_div">
					<h3>证券</h3>
					<ul>
						<li onclick="javascript:window.open('http://www.gjzq.com.cn')" target="_blank"><img src="${ctx}/img/partners/gjzq.png"></li>
						<li onclick="javascript:window.open('http://www.dwjq.com.cn')" target="_blank"><img src="${ctx}/img/partners/dwzq.png"></li>
						<li onclick="javascript:window.open('http://www.xzsec.com')" target="_blank"><img src="${ctx}/img/partners/txzq.png"></li>
					</ul>
				</div>
				<!--信托-->
				<div class="partn_div">
					<h3>信托</h3>
					<ul>
						<li onclick="javascript:window.open('http://www.jxi.cn')" target="_blank"><img src="${ctx}/img/partners/zjxt.png"></li>
						<li onclick="javascript:window.open('http://www.zritc.com')" target="_blank"><img src="${ctx}/img/partners/zrxt.png"></li>
						<li onclick="javascript:window.open('http://www.ajxt.com.cn')" target="_blank"><img src="${ctx}/img/partners/ajxt.png"></li>
						<li onclick="javascript:window.open('http://www.mintrust.com')" target="_blank"><img src="${ctx}/img/partners/wkxt.png"></li>
						<li onclick="javascript:window.open('http://www.zhongtaitrust.com')" target="_blank"><img src="${ctx}/img/partners/ztxt.png"></li>
						<li onclick="javascript:window.open('http://www.msxt.cn')" target="_blank"><img src="${ctx}/img/partners/msxt.png"></li>
						<li onclick="javascript:window.open('http://www.dgxt.com')" target="_blank"><img src="${ctx}/img/partners/dgxt.jpg"></li>
						<li onclick="javascript:window.open('http://www.ljzitc.com.cn')" target="_blank"><img src="${ctx}/img/partners/ljzxt.png"></li>
						<li onclick="javascript:window.open('http://www.caitc.cn')" target="_blank"><img src="${ctx}/img/partners/caxt.png"></li>
						<li onclick="javascript:window.open('http://www.fd-trust.com')" target="_blank"><img src="${ctx}/img/partners/fzdyxt.png"></li>
						<li onclick="javascript:window.open('http://www.wti-xa.com')" target="_blank"><img src="${ctx}/img/partners/xbxt.png"></li>
						<li onclick="javascript:window.open('http://www.ebtrust.com')" target="_blank"><img src="${ctx}/img/partners/gdxlxt.png"></li>
						<li onclick="javascript:window.open('http://www.bohaitrust.com')" target="_blank"><img src="${ctx}/img/partners/bhxt.png"></li>
						<li onclick="javascript:window.open('http://www.dytrustee.com')" target="_blank"><img src="${ctx}/img/partners/dyxt.jpg"></li>
					</ul>
				</div>
				<!--律师-->
				<div class="partn_div">
					<h3>律所</h3>
					<ul>
						<%-- <li onclick="javascript:window.open('http://www.dachengnet.com')" target="_blank"><img src="${ctx}/img/partners/dcls.png"></li>
						<li onclick="javascript:window.open('http://www.kpmg.com')" target="_blank"><img src="${ctx}/img/partners/bmwls.png"></li> --%>
						<li onclick="javascript:window.open('http://www.hiwayslaw.com')" target="_blank"><img src="${ctx}/img/partners/hhls.jpg"></li>
					</ul>
				</div>
				<!--支付-->
				<div class="partn_div">
					<h3>支付</h3>
					<ul>
						<%-- <li onclick="javascript:window.open('http://www.cmbc.com.cn')" target="_blank"><img src="${ctx}/img/partners/mszf.png"></li> --%>
						<li onclick="javascript:window.open('http://www.allinpay.com')" target="_blank"><img src="${ctx}/img/partners/tlzf.png"></li>
					</ul>
				</div>
				<!--其他-->
				<div class="partn_div">
					<h3>其他</h3>
					<ul>
						<%-- <li onclick="javascript:window.open('http://www.pingan.com/?WT.mc_id=SEM-BDBZ-PC0040&amp;WT.srch=1')" target="_blank"><img src="${ctx}/img/partners/zgpa.png"></li>
						<li onclick="javascript:window.open('http://www.zhongan.com/?hmsr=baidubrand&amp;hmmd=cpc&amp;hmpl=title&amp;bizOrigin=pc_baidubrand&amp;utm_source=baidu&amp;utm_medium=brand&amp;utm_campaign=webtitle')" target="_blank"><img src="${ctx}/img/partners/zabx.png"></li>
						 --%>
						 <li onclick="javascript:window.open('http://www.guanfu.com')"><img src="${ctx}/img/partners/gfjy.png"></li>
						<li onclick="javascript:window.open('http://www.wenfex.com')"><img src="${ctx}/img/partners/wjs.png"></li>
					</ul>
				</div>
			</div>
		</div>
		<%@ include file="/static/footer.jsp"  %>
	</body>
</html>
