document.writeln("<!DOCTYPE html>");
document.writeln("<html>");
document.writeln("	<head>");
document.writeln("		<meta charset=\"utf-8\">");
document.writeln("		<title>left_menu</title>");
document.writeln("	</head>");
document.writeln("	<body>");
document.writeln("		<div id=\"left_menu\">");
document.writeln("			<!--面包屑-->");
document.writeln("			<div class=\"left_title\">");
document.writeln("				您的位置:<a href=\"accounts.html\">我的账户</a><span>>&nbsp;我的投资</span>");
document.writeln("			</div>");
document.writeln("			<!--侧边导航-->");
document.writeln("			<div class=\"menu_bod\">");
document.writeln("				<!--用户信息-->");
document.writeln("				<div class=\"menu_b1\">");
document.writeln("					<ul>");
document.writeln("						<li class=\"wd_ls1\"><img src=\"img/icon/logo.png\"></li>");
document.writeln("						<li class=\"wd_ls2\" title=\"Hi!sdfasdgsgasdgasdfsdfaf\">Hi!sdfasdgsgasdgasdfsdfaf</li>");
document.writeln("						<li class=\"wd_ls3\" onclick=\"window.location.href=\'integration.html\'\">总积分：100</li>");
document.writeln("						<li class=\"wd_ls4\">");
document.writeln("							<p class=\"ls_bg1\" onclick=\"window.location.href=\'personal.html\'\"></p>");
document.writeln("							<p class=\"ls_bg2\" onclick=\"window.location.href=\'personal.html\'\"></p>");
document.writeln("							<p class=\"ls_bg3\" onclick=\"window.location.href=\'bankCard.html\'\"></p>");
document.writeln("							<p class=\"ls_bg4\" onclick=\"window.location.href=\'personal.html\'\"></p>");
document.writeln("						</li>");
document.writeln("						<li class=\"wd_ls5\">");
document.writeln("							<label>安全等级</label>");
document.writeln("							<div class=\"leve_line\">");
document.writeln("								<div class=\"leve_bod\"></div>");
document.writeln("							</div>");
document.writeln("						</li>");
document.writeln("					</ul>");
document.writeln("				</div>");
document.writeln("				<div class=\"menu_tit\" onclick=\"window.location.href=\'accounts.html\'\">我的账户首页</div>");
document.writeln("				<!--投资管理-->");
document.writeln("				<div class=\"menu_b2\">");
document.writeln("					<h4>投资管理<span>(4)</span></h4>");
document.writeln("					<div class=\"b2_main\">");
document.writeln("						<ul>");
document.writeln("							<li class=\"mb_bg1\" onclick=\"window.location.href=\'investment.html\'\">我的投资</li>");
document.writeln("							<li class=\"mb_bg2\" onclick=\"window.location.href=\'bondAssignment.html\'\">债权转让</li>");
document.writeln("							<li class=\"mb_bg3\" onclick=\"window.location.href=\'bidSet.html\'\">投标设置</li>");
document.writeln("							<li class=\"mb_bg4\" onclick=\"window.location.href=\'financeRecord.html\'\">活期宝</li>");
document.writeln("						</ul>");
document.writeln("					</div>");
document.writeln("				</div>");
document.writeln("				<!--资产管理-->");
document.writeln("				<div class=\"menu_b2\">");
document.writeln("					<h4>资产管理<span>(4)</span></h4>");
document.writeln("					<div class=\"b2_main\">");
document.writeln("						<ul>");
document.writeln("							<li class=\"mb_bg5\" onclick=\"window.location.href=\'recharge.html\'\">充值</li>");
document.writeln("							<li class=\"mb_bg6\" onclick=\"window.location.href=\'withdraw.html\'\">提现</li>");
document.writeln("							<li class=\"mb_bg7\" onclick=\"window.location.href=\'transaction.html\'\">资金明细</li>");
document.writeln("							<li class=\"mb_bg8\" onclick=\"window.location.href=\'bankCard.html\'\">银行卡</li>");
document.writeln("						</ul>");
document.writeln("					</div>");
document.writeln("				</div>");
document.writeln("				<!--已赚奖励-->");
document.writeln("				<div class=\"menu_b2\">");
document.writeln("					<h4>已赚奖励<span>(3)</span></h4>");
document.writeln("					<div class=\"b2_main\">");
document.writeln("						<ul>");
document.writeln("							<li class=\"mb_bg15\" onclick=\"window.location.href=\'experience.html\'\">体验金</li>");
document.writeln("							<li class=\"mb_bg16\" onclick=\"window.location.href=\'links.html\'\">邀请奖励</li>");
document.writeln("							<li class=\"mb_bg17\" onclick=\"window.location.href=\'integration.html\'\">积分奖励</li>");
document.writeln("							<li class=\"mb_bg18\" onclick=\"window.location.href=\'cardCoupons.html\'\">卡券包</li>");
document.writeln("						</ul>");
document.writeln("					</div>");
document.writeln("				</div>");
document.writeln("				<!--个人资料-->");
document.writeln("				<div class=\"menu_b2\">");
document.writeln("					<h4>个人资料<span>(4)</span></h4>");
document.writeln("					<div class=\"b2_main\">");
document.writeln("						<ul>");
document.writeln("							<li class=\"mb_bg11\" onclick=\"window.location.href=\'personal.html\'\">账户设置</li>");
document.writeln("							<li class=\"mb_bg12\" onclick=\"window.location.href=\'safety.html\'\">安全验证</li>");
document.writeln("							<li class=\"mb_bg13\">密码管理</li>");
document.writeln("							<li class=\"mb_bg14\" onclick=\"window.location.href=\'stationnews.html\'\">我的消息</li>");
document.writeln("						</ul>");
document.writeln("					</div>");
document.writeln("				</div>");
document.writeln("				<!--借款管理-->");
document.writeln("				<div class=\"menu_b2\">");
document.writeln("					<h4>借款管理<span>(2)</span></h4>");
document.writeln("					<div class=\"b2_main\">");
document.writeln("						<ul>");
document.writeln("							<li class=\"mb_bg9\" onclick=\"window.location.href=\'borrowingData.html\'\">我的借款</li>");
document.writeln("							<li class=\"mb_bg10\" onclick=\"window.location.href=\'loan.html\'\">我要借款</li>");
document.writeln("						</ul>");
document.writeln("					</div>");
document.writeln("				</div>");
document.writeln("			</div>");
document.writeln("		</div>");
document.writeln("	</body>");
document.writeln("</html>");
document.writeln("");

$(document).ready(function(){
	$(".list_nav li a").removeClass('nav_bor');
	$(".list_nav>li:eq(6)").find('a').addClass('nav_bor');
	
	$(".left_title span").text(english($("title").text()));
	function english(s){ 
		var pattern = new RegExp("[a-zA-Z`~!@#$^&*()-_-——]");
		var rs = ""; 
		for (var i = 0; i < s.length; i++) { 
			rs = rs+s.substr(i, 1).replace(pattern, ''); 
		} 
		return rs; 
	} 
})