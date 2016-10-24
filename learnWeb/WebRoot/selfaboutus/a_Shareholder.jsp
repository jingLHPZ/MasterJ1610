<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>股东背景_关于我们_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/about.css" />
		<link rel="stylesheet" href="${ctx}/css1000/a_Shareholder1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/a_Shareholder750.css" />
		<link rel="stylesheet" href="${ctx}/css720/a_Shareholder720.css" />
		<script type="text/javascript">
			$(document).ready(function(){
				$(".toin_left_menu li:eq(1)").addClass('abo_me_click').siblings().removeClass('abo_me_click');
				$(".list_nav li a").removeClass('nav_bor');
				$(".list_nav>li:eq(5)").find('a').addClass('nav_bor');
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
					<a href="${ctx}/selfaboutus/a_CompanyProfile.jsp">关于我们</a><span class="active">>&nbsp;股东背景</span>
				</div>
			</div>
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/about_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="about_right_m">
				<div class="item_gdbj">
					<img src="${ctx}/img/partners/gfjy.png"/>
					<div>
						<h1>主板上市公司“冠福股份”大股东林氏家族(股票代码002102)</h1>
						<p>主板上市公司“冠福股份”大股东林氏家族（简称:“冠福股份”，股票代码:002102）“冠福股份”转型“大健康产业”，正在向“健康冠福”迈进。冠福健康核心产业“能特科技和正在并购的“宝众宝达”将支撑起全新“冠福健康”的未来。冠福旗下“中国梦谷”文创健康园区，是践行习大大“中国梦”和克强总理“大众创业 万众创新”的文创商业运营园区平台，新时代下充满着无可想象的发展空间，将成为上市公司新的引擎和支撑。历史悠久文化厚重，中国china全国日用陶瓷龙头企业，国家高新技术产业，“世界瓷都”、“中国瓷都”德化龙头企业。</p>
					</div>
				</div>
				<div class="item_gdbj gdbj_down">
					<img src="${ctx}/img/partners/caee.png" style="width:158px;height:37px;">
					<div>
						<h1>上海文化产权交易所众申艺术品交易中心</h1>
						<p>
							上海文化产权交易所众申艺术品交易中心以中宣部、商务部、文化部、广电总局、新闻出版总署5个部门共同出台的《加强文化产权交易和艺术品交易管理的意见》 （49 号文）为指导，依托国家级综合性文化产权交易服务机构，打造的规范化文化物权类市场交易平台。 
      						上海文化产权交易所众申艺术品交易中心，按照国家相关法律法规并在上海文化产权交易所的监管授权下可以开展各类艺术品投融资管理、艺术品实物交易、艺术品金融产品设计开发、艺术品仓储保管、艺术品文化产业园区设立等相关产权交易服务方面的工作。
						</p>
					</div>
				</div>

			</div>
		</div>
			<%@ include file="/static/footer.jsp"  %>
	</body>
</html>
