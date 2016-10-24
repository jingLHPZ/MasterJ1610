<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<%@ include file="/static/commonTags.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>关于我们_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/public.css" />
		<script type="text/javascript" src="${ctx}/js/jquery-1.7.2.js" ></script>
		<script type="text/javascript" src="${ctx}/js/method.js" ></script>
	</head>
	<body>
		<div id="about_menu">
			<!--左边分类菜单-->
			<div class="toin_left_menu">
				<ul>
					<li class="abo_me_click" onclick="window.location.href='${ctx}/selfaboutus/a_CompanyProfile.jsp'">公司简介</li>
					<li onclick="window.location.href='${ctx}/selfaboutus/a_Shareholder.jsp'">股东背景</li>
					<li onclick="window.location.href='${ctx}/selfaboutus/a_Team.jsp'">创始团队</li>
					<li onclick="window.location.href='${ctx}/selfaboutus/a_partners.jsp'">合作伙伴</li>
					<li onclick="window.location.href='${ctx}/newsnotice/fqueryallnotice.htm'">网站公告</li>
					<li onclick="window.location.href='${ctx}/newsinformation/fqueryallinformation.htm'">行业新闻</li>
					<!--<li onclick="window.location.href='../a_notice.html'">资费说明</li>-->
					<%-- <li onclick="window.location.href='${ctx}/selfaboutus/a_recruitment.jsp'">招贤纳士</li> --%>
					<li onclick="window.location.href='${ctx}/selfaboutus/a_contact.jsp'">联系我们</li>
				</ul>
			</div>
		</div>
		<script type="text/javascript">
		$(function(){
			
			if(!BASE.versions().mobile){
				leftMenuFloat();
			};
			function leftMenuFloat(){
				var styleNode = document.createElement("style");
				var timeOut;
				styleNode.innerHTML = "#about_menu .toin_left_menu .float{position: fixed;top: 50px;background: #faf9f3;z-index:0} .footer{position: relative;} #zb_footer{position: relative;}";
				document.getElementsByTagName("body")[0].appendChild(styleNode);
				
				$(window).scroll(function(e){
				    if($(this).scrollTop() > 130){
			        	$(".toin_left_menu ul").addClass("float");
			        }else{
			        	$(".toin_left_menu ul").removeClass("float");
			        };
				});
			}

		})
		</script>
	</body>
</html>