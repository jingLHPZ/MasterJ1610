<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>招贤纳士_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/about.css" />
		<link rel="stylesheet" href="${ctx}/css1000/a_recruitment1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/a_recruitment750.css" />
		<link rel="stylesheet" href="${ctx}/css720/a_recruitment720.css" />
		<script type="text/javascript">
			$(document).ready(function(){
				$(".toin_left_menu li:eq(6)").addClass('abo_me_click').siblings().removeClass('abo_me_click');
				$(".list_nav li a").removeClass('nav_bor');
				$(".list_nav>li:eq(5)").find('a').addClass('nav_bor');
			});
			
		</script>
		<%@ include file="/static/top.jsp" %>
	</head>
	<body>
		<div id="ab_body">
			<!--面包屑-->
			<div class="bg tp_crumb">
				<div class="container">
					<a href="${ctx}/system/fquerysumway.htm">首页</a>&gt;
					<a href="${ctx}/selfaboutus/a_CompanyProfile.jsp">关于我们</a><span class="active">>&nbsp;招贤纳士</span>
				</div>
			</div>
			<!--左边查单栏-->
			<div class="left_menu">
				<%@ include file="/static/about_menu.jsp" %>
			</div>
			<!--右边主体-->
			<div class="about_right_m">
				<!--招贤纳士标题-->
				<div class="recrui_title"><img src="${ctx}/img/zxns_icon.png"></div>
				<!--职位列表-->
				<ul class="recrui_list">
					<li>
						<h3>投行部项目经理&nbsp;&nbsp;&nbsp;&nbsp;1个</h3>
						<div>
							<h4>岗位职责：</h4>
							<p>
								1、挖掘优质项目，组织研发设计各类金融产品；<br />
								2、负责投行项目交易结构设计，组织项目尽职调查，拟定项目合同，独立撰写尽职报告、可行性分析报告、项目计划书、投资指引、募集说明书等；<br />
								3、与国内信托公司、券商、银行、投资公司、私募基金等机构开展全面业务合作。
							</p>
							<h4>任职要求：</h4>
							<p>
								1、金融等相关专业本科及以上学历，<br />
								2、有两年以上会计事务所或律所工作经验，财务基础扎实，有资管行业工作经验优先；<br />
								3、熟悉金融行业投行业务流程；<br />
								4、熟悉银行、证券、保险等金融机构投行业务类型及风险偏好优先；<br />
								5、熟悉项目操作流程及项目评判能力，并能完成项目整理报告；<br />
								6、思维敏捷、逻辑性强，沟通能力、谈判能力强。
							</p>
						</div>
					</li>
					<li>
						<h3>产品经理 &nbsp;&nbsp;&nbsp;&nbsp;2个</h3>
						<div>
							<h4>职位描述：</h4>
							<p>
								1、负责市场金融产品的引进及发行（固定收益、浮动收益），根据市场需求不断丰富公司产品线；同时积极维护同产品供应商的合作关系，不断深化合作领域；<br />
								2、定期拜访信托、三方、基金等合作伙伴，及时获取市场产品资讯并引进产品；<br />
								3、对当前国内外金融市场、互联网金融等领域的创新产品进行研究与分析，设计开发金融产品；<br />
								4、研究互联网金融和第三方理财的发展方向，参与制定产品发展策略；<br />
								5、与市场、运营、销售团队紧密配合，完成产品的推广、销售与跟踪评价工作。
							</p>
							<h4>任职资格：</h4>
							<p>
								1、具有2年以上证券、银行、信托、基金公司、财富管理公司产品采购和设计等相关工作经验，具有丰富的金融机构相关资源者优先；<br />
								2、熟悉金融产品、风险控制、投资管理、合法合规等方面的知识，具有较强的风险防范意识；<br />
								3、具有敏锐的洞察力和前瞻性，善于对行业与市场趋势、客户需求、标杆企业产品进行研究策划的能力；<br />
								4、具有较强的人际沟通能力、办公软件运用能力和管理和组织协调能力，能够承受有压力的工作。
							</p>
						</div>
					</li>
					<li>
						<h3>java开发工程师&nbsp;&nbsp;&nbsp;&nbsp;2个</h3>
						<div>
							<h4>岗位职责：</h4>
							<p>
								1、负责公司平台级产品的软件开发和维护；<br />
								2、参与公司系统平台及项目整体设计、并负责完成代码研发；<br />
								3、负责编写相关模块概要设计、详细设计等技术文档；<br />
								4、参与项目中业务功能接口和基础类库的设计，解决项目中的关键问题和技术难题;<br />
								5、根据开发规范与流程独立完成模块的设计、编码以及相关文档。
							</p>
							<h4>岗位要求：</h4>
							<p>
								1、2年及以上Java开发经验者；<br />
								2、熟悉Java语言，熟悉JSP、Servlet、JavaBean、JDBC等Java技术；<br />
								3、熟悉基于MySQL 数据库的设计和开发；<br />
								4、熟悉JavaScript 、SpringMVC、Hibernate、Struts等主流开源框架和技术；<br />
								5、熟悉 Linux 操作系统和tomcat服务器；<br />
								6、熟悉XHTML、CSS、JavaScript，有web开发功底者优先；<br />
								7、具有良好的学习能力和沟通能力。
							</p>
						</div>
					</li>
					<li>
						<h3>web前端开发工程师&nbsp;&nbsp;&nbsp;&nbsp;1个</h3>
						<div>
							<h4>岗位职责：</h4>
							<p>
								1.与产品经理、UI设计师协作完成页面制作； <br />
								2.与后台开发工程师协作，完成各种数据交互、动态信息展现和用户的互动；<br /> 
								3.维护及优化前端页面性能。
							</p>
							<h4>岗位要求：</h4>
							<p>
								1. 大学本科及以上学历，有2年以上使用(X)HTML strict、CSS和Javascript跨浏览器开发经验 ；<br />
								2. 熟悉原生JS，有一个以上复杂的前端开发案例 ；<br />
								3. 熟悉各种WEB技术，HTML/CSS/XML等，特别是jQuery框架，如果熟悉BootStrap更好。<br /> 
								4. 熟悉各主流浏览器之间的兼容性问题及解决方案； <br />
								5. 有丰富的关于Web标准、易用性、浏览器端原理以及网站性能等方面的知识；<br /> 
								6. 对前端技术有持续热情，逻辑性强，富有团队精神，善于学习，乐于探索；<br />
								7、熟悉HTML5,CSS3优先；有UI、美工功底者优先。
							</p>
						</div>
					</li>
					<li>
						<h3>分公司（资产端）团队经理 &nbsp;&nbsp;&nbsp;&nbsp;若干</h3>
						<div>
							<h4>岗位职责：</h4>
							<p>
								1、承接公司制定的市场开拓计划，制定销售方案，带领团队与公司一起完成任务指标；<br />
								2、组建和管理团队，并定期进行专业技能的培训；<br />
								3、负责部门的日常管理工作；<br />
								4、配合领导完成其他工作。<br />
								5、主要业务：各类抵押贷款。
							</p>
							<h4>岗位要求：</h4>
							<p>
								1、大专及以上学历；<br />
								2、三年以上本地信贷行业工作经验，二年以上金融行业销售管理工作经验；<br />
								3、了解本地信贷市场，在本行业有一定的人脉资源；<br />
								4、有快速组建团队的能力。
							</p>
						</div>
					</li>
					<li>
						<h3>理财管理培训生&nbsp;&nbsp;&nbsp;&nbsp;若干</h3>
						<div>
							<h4>职位要求：</h4>
							<p>
								1、大专及以上学历，有志于金融行业长远发展，海外留学者优先录取；<br />
								2、良好的沟通能力，很好的亲和力和较强的人际交往能力；<br />
								3、精力充沛，喜爱竞争挑战和有强烈成功欲望；<br />
								4、遵守纪侓和行业规范，能接受严格专业培训，具有敬业精神及团队合作意识；<br />
								5、正直诚信，忠于企业，传承企业文化，愿意与企业一起发展成长；<br />
								6、具有一定的金融行业知识，具有投资等相关业务从业经历者优先。
							</p>
							<h4>任职要求：</h4>
							<p>
								1、了解公司文化，学习掌握金融基础知识及公司热销产品；<br />
								2、从投资理财顾问做起，了解目前金融市场投资工具，协助高净值客户理财，确保客户利益的稳健性及收益性；<br />
								3、优厚的薪资待遇，开启璀璨人生之路。
							</p>
							<h4>福利待遇：</h4>
							<p>
								1、公司总裁等高管亲自带队；<br />
								2、条件符合者，公司将统一安排专业职业技能培训；<br />
								3、、做五休二、OFFICE作息时间，无需加班；<br />
								4、、签订全日制固定期限劳动合同、五险一金、底薪+绩效+奖金提成奖励；<br />
								5、正式员工享受带薪培训、带薪年假、定期体检等福利待遇。
							</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<%@ include file="/static/footer.jsp"  %>
	</body>
</html>
