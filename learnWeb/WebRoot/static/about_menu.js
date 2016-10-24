document.writeln("<!DOCTYPE html>");
document.writeln("<html>");
document.writeln("	<head>");
document.writeln("		<meta charset=\"utf-8\">");
document.writeln("		<title>关于我们</title>");
document.writeln("		<link rel=\"stylesheet\" href=\"../css/public.css\" />");
document.writeln("		<script type=\"text/javascript\" src=\"../js/jquery-1.7.2.js\" ></script>");
document.writeln("		<script type=\"text/javascript\" src=\"../js/method.js\" ></script>");
document.writeln("	</head>");
document.writeln("	<body>");
document.writeln("		<div id=\"about_menu\">");
document.writeln("			<!--左边分类菜单-->");
document.writeln("			<div class=\"toin_left_menu\">");
document.writeln("				<ul>");
document.writeln("					<li class=\"abo_me_click\" onclick=\"window.location.href=\'a_CompanyProfile.html\'\">公司简介</li>");
document.writeln("					<li onclick=\"window.location.href=\'a_Team.html\'\">创始团队</li>");
document.writeln("					<li onclick=\"window.location.href=\'a_partners.html\'\">合作伙伴</li>");
document.writeln("					<li onclick=\"window.location.href=\'a_notice.html\'\">网站公告</li>");
document.writeln("					<li onclick=\"window.location.href=\'a_journalism.html\'\">行业新闻</li>");
//document.writeln("					<li onclick=\"window.location.href=\'a_notice.html\'\">资费说明</li>");
document.writeln("					<li onclick=\"window.location.href=\'a_recruitment.html\'\">招贤纳士</li>");
document.writeln("					<li onclick=\"window.location.href=\'a_contact.html\'\">联系我们</li>");
document.writeln("				</ul>");
document.writeln("			</div>");
document.writeln("		</div>");
document.writeln("	</body>");
document.writeln("</html>");
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
