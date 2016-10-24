<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>创始团队_关于我们_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/about.css" />
		<link rel="stylesheet" href="${ctx}/css1000/a_Team1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/a_Team750.css" />
		<link rel="stylesheet" href="${ctx}/css720/a_Team720.css" />
		<script type="text/javascript">
			$(document).ready(function(){
				$(".toin_left_menu li:eq(2)").addClass('abo_me_click').siblings().removeClass('abo_me_click');
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
					<a href="${ctx}/selfaboutus/a_CompanyProfile.jsp">关于我们</a><span class="active">>&nbsp;创始团队</span>
				</div>
			</div>
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/about_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="about_right_m">
				<!--主要股东背景-->
				<!-- div class="Team_gdbj">
					<label>主要股东背景来自于</label>
					<img src="${ctx}/img/partners/gfjy.png" />
					<img src="${ctx}/img/partners/caee.png" />
				</div-->
				<!--公司团队-->
				<div class="Team_gstd">
					<ul>
						<li>
							<div>
								<img src="${ctx}/img/pic/syh.png">
								<label>石宇华</label>
							</div>
							<h4>董事长、总裁</h4>
							<p>
								澳大利亚纽卡斯尔大学商学院金融管理学博士，曾就职于中植金智高级副总裁、澳新银行投行部总监、澳大利亚风腾国际集团总经理、冠福股份旗下寰宇创智资产董事兼总裁。15 年金融管理、资本运作及管理经验，具备丰富的国内外项目融资并购经验。与多家外资银行及海外金融机构建立了广泛和深入的合作联系，有着丰富的国际人脉及国际金融资源。
							</p>
						</li>
						<li>
							<div>
								<img src="${ctx}/img/pic/mxw.png">
								<label>孟宪伟</label>
							</div>
							<h4>副董事长、联席总裁</h4>
							<p>
								清华大学研究生，上海交通大学金融联盟理事，近10年金融机构从业经验，是中国信托行业市场化以来最早的一批从业者。 
								曾在招商信诺保险、中融国际信托、北京天地方中资产管理有限公司、深圳平安大华汇通财富管理有限公司等金融机构任要职，
								具有丰富的财富管理和资产管理经验。
							</p>
						</li>
						<%-- <li>
							<div>
								<img src="${ctx}/img/pic/yzp.png">
								<label>姚志平</label>
							</div>
							<h4>独立董事</h4>
							<p>
								中国互联网金融风控行业及风控准则的引领者，全面负责平安集团陆金所的风控体系，曾任平安集团陆金所副总经理、
								台新国际商业银行资深副总经理、美国HSBC资深授信及风险管理经理等职，在个人信用等级评定、风险管理体制规划、
								业务流程设计、风险计量评价、风险预警监控等管理工具运用方面 做了大量创新实践，具备20多年丰富的风险管理工作经验。
							</p>
						</li> --%>
						<li>
							<div>
								<img src="${ctx}/img/pic/zj.png">
								<label>郑军</label>
							</div>
							<h4>联席总裁</h4>
							<p>
								交大安泰 EMBA、台湾上市上柜公司亚太区副总、世界 500 强纽约主板上市科技公司亚太区资深总监、国内区域型 A 类证券公司上海投行部总经理、具有 16 年公司管理、运营，熟悉资本市场。
							</p>
						</li>
						<li>
							<div>
								<img src="${ctx}/img/pic/zx.png">
								<label>张宪</label>
							</div>
							<h4>专家顾问</h4>
							<p>
								 海通吉禾股权投资基金管理有限公司董事长，前海通证券股份有限公司投资银行部总经理。 从事银行、证券工作近30年，
								 牵头组织多家IPO和“粤电力”增发、“粤高速”配股等十余个重大项目。
							</p>
						</li>
						<li>
							<div>
								<img src="${ctx}/img/pic/ab_gjl.png">
								<label>管建林</label>
							</div>
							<h4>财富端执行总裁</h4>
							<p>
								 美国韦伯斯特大学工商管理学硕士，香港银行协会注册理财策划师，金融行业从业经验20年；曾经供职于中国银行、中信银行、荷兰银行、苏格兰皇家银行等金融企业担任过行长和副总裁职位。
							</p>
						</li>
						<li>
							<div>
								<img src="${ctx}/img/pic/ab_cy.png">
								<label>陈寅</label>
							</div>
							<h4>财富端执行总裁</h4>
							<p>
								 毕业于上海对外经贸大学，近10年大型金融机构管理经验，第一批互联网金融行业从业者。曾就职于中国人寿、上海陆家嘴国际金融资产交易市场股份有限公司，期间担任业务主任及业务总监职务。具有丰富的保险、银行、信托等金融机构产品以及跨境金融商品运作经验，熟悉互联网金融平台搭建及业务经营模式。
							</p>
						</li>
						<li>
							<div>
								<img src="${ctx}/img/pic/ab_wrj.png">
								<label>吴仁杰</label>
							</div>
							<h4>财富端执行总裁</h4>
							<p>
								 毕业于台湾逢甲大学银行保险学专业，荣获台湾金融研训院金融管理多项资格证书，近14年外资私人财富管理银行及金融机构从业经验。 曾在美商花旗银行、澳新银行、台新银行、中国平安陆金所等金融机构担任过行长和高级业务总监职务。 亦担任台湾及中国陆金所多场大型金融演说讲师，有丰富金融专业背景。
							</p>
						</li>
						<li>
							<div>
								<img src="${ctx}/img/pic/ab_gj.png">
								<label>关键</label>
							</div>
							<h4>风控总监</h4>
							<p>
								 毕业于上海财经大学经济学院，具有14年银行从业经验，其中10年以上风险管理工作经验。曾在广发银行、上海骏和集团、东虹桥小贷公司等知名金融机构任风控总监职位。任职期间主要负责信用风险治理、风险政策管理及风控框架搭建，并负责管理信用衍生产品交易以及信贷资产证券化业务等，对互联网金融行业风险管理有扎实的理论依据及丰富的实战经验。
							</p>
						</li>
						<!--<li>
							<div>
								<img src="img/pic/lxy.png">
								<label>李晓蕴</label>
							</div>
							<h4>IT总监</h4>
							<p>
								毕业于南华大学企业管理专业学士学位，是中国最早一批为国家电子政务系统开发与建设管理的高级软件专家及系统集成专家。 
								曾就职于长城计算机软件与系统有限公司、中国软件与技术服务有限公司中高层，国家税务总局“金税三期”工程应用总集成及核
								心征管项目工程总监， 拥有15年及以上组织实施国家级大型复杂软件系统建设经验及管理经验。
							</p>
						</li>-->
						<li>
							<div>
								<img src="${ctx}/img/pic/ly.png">
								<label>梁祎</label>
							</div>
							<h4>财富端副总裁</h4>
							<p>
								美国富特海斯州立大学工商管理学硕士，香港银行协会注册理财策划师，持有香港理财规划师、证券从业资格证、保险代理人资格证书、助理会计师。十五年以上国内知名银行、外资银行工作经验。
							</p>
						</li>
						<li>
							<div>
								<img src="${ctx}/img/pic/ccm.png">
								<label>蔡春明</label>
							</div>
							<h4>财富端营销副总裁</h4>
							<p>
								华东师范大学文学硕士，宁波大学文学、经济学双学位本科，持有证券从业人员资格证书、银行从业人员资格证书、保险代理从业人员资格考试证书（ALE）、投连险资格证书。五年外资银行工作经验，10年金融从业经验。
							</p>
						</li>
					</ul>
				</div>
			</div>
		</div>
	<%@ include file="/static/footer.jsp"  %>
	</body>
</html>
