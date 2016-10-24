<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
		<%@ include file="/static/newtaglibs.jsp"%>
		<title>安全保障_风控_技术_学呗互联网金融</title>
		<link rel="stylesheet" href="${ctx}/css/security.css" />
		<link rel="stylesheet" href="${ctx}/css1000/security1000.css" />
		<link rel="stylesheet" href="${ctx}/css750/security750.css" />
		<link rel="stylesheet" href="${ctx}/css720/security720.css" />
		<script type="text/javascript">
			//导航
			$(document).ready(function(){
				$(".list_nav li a").removeClass('nav_bor');
				$(".list_nav>li:eq(3)").find('a').addClass('nav_bor');
			})
		</script>
	</head>
	<body>
	<%@ include file="/static/top.jsp" %>
	<!--导航-->
		<div class="security_nav">
			<div class="cont">
				<div class="security_logo">
					<img src="${ctx}/img/security_dp.png"/>
					<h1>安全保障</h1>
				</div>
				<ul>
					<li page="page_fk" class="security_fk active">风控保障</li>
					<li page="page_js" class="security_js">技术保障</li>
					<li page="page_qy" class="security_qy">权益保障</li>
				</ul>
			</div>
		</div>
		
		<!--风控页-->
		<div class="page_fk point">
			<!--风控保障-->
			<!--<div class="fk_bz">
				<div class="cont">
					<h2>风控保障</h2>
					<div class="text">
						<h3>投资人保障</h3>
						<p>学呗互联网金融平台拥有优质的借款人，客户均有本地资产证明及良好的信用表现，具备按时还款的能力。</p>
						<h3>风险保障</h3>
						<p>借助学呗的强大风控团队及学呗互联网金融平台的大数据线上风控体系，确保投资人交易安全不受损害。</p>
						<h3>大数据保障</h3>
						<p>学呗互联网金融平台借助第三方征信机构与央行征信体系，360°全方位掌控借款人的信用信息。</p>
						<h3>担保保障</h3>
						<p>学呗与全国性知名担保机构合作，强强联手为学呗保驾护航，做好投资人的强大后盾。</p>
					</div>
					<img src="${ctx}/img/security_hk.png"/>
				</div>
			</div>-->
			
			<!--风控流程-->
			<!--<div class="fk_lz">
				<div class="cont">
					<h2>风控流程</h2>
					<img src="${ctx}/img/security_lc.png"/>
				</div>
			</div>-->
			
			<!--风控防线-->
			<div class="fk_fx">
				<div class="cont">
					<h2>产品准入</h2>
					<h4>严选正规证券公司、信托公司及基金公司发行的各类投资产品，经过风险评估测试后推荐给不同风险承受能力的客户。</h4>
					<img src="${ctx}/img/security_fk8.png"/>
					<!--手机版-->
					<div class="phone_cont">
						<h1>
							<b></b>风控政策
						</h1>
						<p>严苛的信贷政策，剔除高风险、高污染行业。</p>
						<h1>
							<b></b>贷后管理
						</h1>
						<p>完善的贷后管理，多种渠道针对各种逾期情况的催收体系。</p>
						<h1>
							<b></b>贷中预警
						</h1>
						<p>贷中风险预警机制，更有效的降低逾期风险。</p>
						<h1>
							<b></b>上线审查
						</h1>
						<p>合同、他证、产证等原件齐全，确保投资人投资安全。</p>
						<h1>
							<b></b>资料初审
						</h1>
						<p>33项必备材料逐一审查，360度全方位覆盖所有风险点。</p>
						<h1>
							<b></b>大数据排查
						</h1>
						<p>银行级反欺诈作业，结合大数据分析，辨别信息真伪。</p>
						<h1>
							<b></b>风控审查
						</h1>
						<p>云技术精准风险评测，核实借款用途、抵押物以及还款来源等重要信息，量身打造风控措施。</p>
						<h1>
							<b></b>合同审查
						</h1>
						<p>合同内容符合项目审议结果，格式规范，保证合同的合法合规。</p>
					</div>
				</div>
			</div>
			
			<!--贷后风控措施-->
			<!--<div class="fk_cs">
				<div class="cont">
					<h2>贷后风控措施</h2>
					<img src="${ctx}/img/security_jd3.png"/>
				</div>
			</div>-->
			
			<!--资金投向安全保障-->
			<div class="fk_zj">
				<div class="cont">
					<h2>流程管控</h2>
				</div>
				<div class="phone_cont">
					<h1>
						<b></b>银行监管账户
					</h1>
					<p>平台资金由国有五大行之一进行存管，确保投资人交易资金安全。</p>
					<h1>
						<b></b>第三方支付
					</h1>
					<p>引入通联支付作为第三方支付机构，按照客户指令划拨投资相关资金。</p>
					<h1>
						<b></b>风险准备金制度
					</h1>
					<p>每个项目计提一定比例的风险准备金，用于风险出现时的安全兑付。 </p>
				</div>
			</div>
			
		</div>
		
		<!--技术保障-->
		<div class="page_js">
			<div class="cont">
				<h1>
					<b></b>安全套接层协议
				</h1>
				<p>学呗使用VeriSign SSL数字证书、128-256位加密技术。客户在学呗进行操作时，系统将在客户端浏览器和Web服务器之间建立一条SSL安全通道Secure socket layer(SSL)，自动加密交易和资金信息，保证数据在网络交换过程中的安全性。</p>
				<h1>
					<b></b>全方位主动备份技术
				</h1>
				<p>学呗使用跨硬盘、跨主机、跨机房、跨地区四重备份机制，在华北和华东各部署了一个数据中心，对平台数据进行24小时不间断主动备份。</p>
				<h1>
					<b></b>国有银行与第三方支付维护资金结算和数据安全
				</h1>
				<p>学呗与五大银行之一的某国有商业银行达成资金存管合作、与通联支付达成第三方支付通道合作，提升客户资金结算和交易数据的安全。</p>
				<h1>
					<b></b>先进存储机制确保影像和合同文件数据安全
				</h1>
				<p>学呗运营过程中所采用到的所有影像、合同等保密文件均以只读和机密的形式进行存储，避免被恶意篡改和删除。在大规模可扩展集群支持下，确保用户文件的安全性、可靠性，并支持高并发、高可用等数据解决方案。</p>
				<h1>
					<b></b>采用覆盖面更广的内容分发网络（CDN）
				</h1>
				<p>其目的是通过在现有的Internet中增加一层新的网络架构，将网站的内容发布到最接近用户的网络"边缘"，使用户可以就近取得所需的内容，解决Internet网络拥堵的状况，提高用户访问网站的响应速度。从技术上全面解决由于网络带宽小、用户访问量大、网点分布不均等原因所造成的用户访问网站响应速度过慢问题。</p>
				<h1>
					<b></b>使用高端防火墙来提高网站结构的安全性
				</h1>
				<p>通过利用防火墙对内部网络的划分，实现内部网络重点网段与全局网络的隔离，从而限制了局部重点或敏感网络安全问题对全局网络造成的影响，屏蔽内部网络的部分安全漏洞，隐蔽那些透漏内部细节如Finger，DNS等服务。采用防火墙（作为阻塞点、控制点）能极大地提高内部网络的安全性，并通过过滤不安全的服务来降低风险。由于只有经过精心选择的应用协议才能通过防火墙，因此网络环境将变得更安全。</p>
				
			</div>
		</div>
		
		<!--权益保障-->
		<div class="page_qy">
			<div class="cont">
				<h1>
					<b></b>隐私保障
				</h1>
				<p>学呗设定了严格的内部信息安全管理制度和安全系统，以防止未经授权获取客户信息行为的发生。因合作必要而委托的第三方，在得到学呗许可获取客户个人信息时，都被要求严格履行保密义务。</p>
				
				<h1>
					<b></b>法律保障
				</h1>
				<p>1、学呗互联网金融平台提供居间撮合服务的合法性：</p>
				<p class="detail">《合同法》第23章专门对“居间合同”作出规定，其第424条明确定义为：“居间合同是居间人向委托人报告订立合同的机会或者提供订立合同的媒介服务，委托人支付报酬的合同”。学呗互联网金融平台是合法设立的居间服务机构，致力于为民间借贷业务提供优质高效的撮合服务，以促成借贷双方形成借贷关系，然后收取相关报酬。此种居间服务有着明确的法律依据。</p>
				<p>2、学呗互联网金融平台理财人及借款人之间借贷关系的合法性：</p>
				<p class="detail">《合同法》第196条规定：“借款合同是借款人向贷款人借款，到期返还借款并支付利息的合同”；根据《合同法》第十二章“借款合同”和最高人民法院《关于人民法院审理借贷案件的若干意见》，我国法律允许自然人等普通民事主体之间发生借贷关系，并允许出借方到期可以收回本金和符合法律规定的利息。理财人作为出借人，与借款人之间形成的借贷关系受到法律保护。</p>
				<p>3、学呗互联网金融平台理财人获得出借理财收益的合法性：</p>
				<p class="detail">根据最高人民法院《关于人民法院审理借贷案件的若干意见》第6条：“民间借贷的利率可以适当高于银行的利率，各地人民法院可以根据本地区的实际情况具体掌握，但最高不得超过银行同类贷款利率的四倍（包含利率本数）。超出此限度的，超出部分的利息不予保护。” 学呗互联网金融平台上理财人向借款人出借资金并按照约定利率收取利息，该利率未超过银行同类贷款利率的四倍，为合法利息收益，受到法律保护。</p>
				<p>4、学呗互联网金融平台电子合同的合法性：</p>
				<p class="detail">根据《合同法》第11条的规定，当事人可以采用合同书、信件和数据电文（包括电报、电传、传真、电子数据交换和电子邮件）等形式订立合同。电子合同是法律认可的书面合同形式之一。学呗互联网金融平台采取用户网上点击确认的方式签署电子合同。点击确认后的电子合同符合《中华人民共和国合同法》规定的合同成立、生效的要件，其有效性也被人民法院的司法实践所接受。</p>
				
				<h1>
					<b></b>高效的逾期催收体系
				</h1>
				<img src="${ctx}/img/security_lx4.png"/>
			</div>
		</div>
		<%@ include file="/static/footer.jsp" %>
	</body>
</html>
