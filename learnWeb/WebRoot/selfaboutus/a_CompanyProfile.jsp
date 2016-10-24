<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>公司简介_关于我们_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/about.css" />
		<link rel="stylesheet" href="${ctx}/css1000/a_CompanyProfile1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/a_CompanyProfile750.css" />
		<link rel="stylesheet" href="${ctx}/css720/a_CompanyProfile720.css" />
		<script type="text/javascript">
			//导航
			$(document).ready(function(){
				$(".list_nav li a").removeClass('nav_bor');
				$(".list_nav>li:eq(5)").find('a').addClass('nav_bor');
			})
		</script>
	</head>
	
	<body>
	<script type="text/javascript">
		 	$(function(){
				$(".toin_left_menu li:eq(0)").addClass('abo_me_click').siblings().removeClass('abo_me_click');
			}) 
	</script>
	<%@ include file="/static/top.jsp" %>
	
		<div id="ab_body">
			<!--面包屑-->
			<div class="bg tp_crumb">
				<div class="container">
					<a href="${ctx}/system/fquerysumway.htm">首页</a>&gt;
					<a href="${ctx}/selfaboutus/a_CompanyProfile.jsp">关于我们</a><span class="active">>&nbsp;公司简介</span>
				</div>
			</div>
			<!--左边查单栏-->
			<div class="left_menu">
			<%@ include file="/static/about_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="about_right_m">
				<div class="zb_logo_icon"><p></p></div>
				<p class="comp_p">
					上海学呗互联网金融信息服务有限公司（www.51zhangbei.com）是华夏文冠旗下的互联网金融服务平台，核心团队来自于平安陆金所、中融信托、国泰君安、国金证券、中国软件等知名企业，依托成功的行业经验和领先的风险管控模式，为客户提供“安全、稳健、专业”的金融产品和服务，构建出一个高效、透明、人性化易操作的网络金融服务平台，为国内广大个人、上市公司和国有企业解决贷款和融资需求的同时，也为富裕阶层、高净值人群以及互联网人群提供专业、安全、全方位的财务规划与财富增值服务。
				</p>
				<!-- <p class="comp_p">
					得益于中国经济的持续快速增长，中国高净值人士群体基数在未来数年将持续扩大，上海学呗互联网金融信息服务有限公司创建了第三方理财团队，旗下的财富管理公司将依托控股股东企业集团在金融、房地产开发、国有企业等方面的雄厚资源，致力于为客户提供细致入微的个性化、量身定制的理财规划、投资方案及高增值服务，为高端客户提供全方位的理财服务。
				</p> -->
				<ul class="comp_ul">
					<li>
						<h3>公司愿景&nbsp;/&nbsp;</h3>
						<b>COMPANY VISION</b>
						<p>提供极致安全的产品和优质的服务体验，创造美好生活。</p>
					</li>
					<li>
						<h3>企业精神&nbsp;/&nbsp;</h3>
						<b>THE SPIRIT OF ENTERPRISE</b>
						<p>专业，诚信，稳健，创新</p>
					</li>
					<li>
						<h3>企业文化&nbsp;/&nbsp;</h3>
						<b>COMPANY CULTURE</b>
						<p>专业创造价值</p>
					</li>
				</ul>
			</div>
		</div>
		<%@ include file="/static/footer.jsp"  %>
	</body>
</html>
