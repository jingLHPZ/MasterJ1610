<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" /> 
	<%@ include file="/static/newtaglibs.jsp"%>
	<title>中孚电力私募债_学呗互联网金融</title>
	<link rel="stylesheet" href="${ctx}/css/recruit_zfdl.css" />
	<%@ include file="/static/top.jsp" %>
</head>
<body>
	<div class="banner"></div>
	
	<div class="bg recruit">
		<div class="cont">
			<label>产品名称</label>
			<p>河南中孚电力有限公司专项私募债</p>
			<label>融资规模</label>
			<p>2亿元</p>
			<label>融资期限</label>
			<p>8个月、12个月</p>
			<label>资金用途</label>
			<p>用于补充河南中孚电力有限公司经营所需流动资金</p>
			
			<label class="profit">收益率</label>
			<ul>
				<li class="title">
					<div class="pro_1">认购期限</div>
					<div class="pro_5">委托人类型</div>
					<div class="pro_2">认购金额</div>
					<div class="pro_3">预期年化收益率</div>
					<div class="pro_4">分配方式</div>
				</li>
				<li>
					<label class="pro_1">8个月</label>
					<div class="pro_5">
						<p>A1</p>
						<p>A2</p>
						<p>A3</p>
					</div>
					<div class="pro_2">
						<p>10万-50万（不包括50万）</p>
						<p>50万-100万元（不包括100万元）</p>
						<p>100万元以上（包括100万元）</p>
					</div>
					<div class="pro_3">
						<p>8.8%</p>
						<p>9.0%</p>
						<p>9.3%</p>
					</div>
					<label class="pro_4">按半年</label>
				</li>
				<li>
					<label class="pro_1">12个月</label>
					<div class="pro_5">
						<p>B1</p>
						<p>B2</p>
						<p>B3</p>
					</div>
					<div class="pro_2">
						<p>10万-50万（不包括50万）</p>
						<p>50万-100万元（不包括100万元）</p>
						<p>100万元以上（包括100万元）</p>
					</div>
					<div class="pro_3">
						<p>9.4%</p>
						<p>9.6%</p>
						<p>9.9%</p>
					</div>
					<label class="pro_4">按半年</label>
				</li>
				
				
			</ul>
			<label>备案单位</label>
			<p>上海文化产权交易所文化金融创新服务中心</p>
			
			<label class="hkly_l">还款来源</label>
			<p class="hkly_p">中孚电力2015年实现利润近4亿元，特别是2016年机组增容改造将全部完成，三台30万千瓦机组全部增容为32万千瓦机组，以现在的煤炭价格，公司的盈利能力会进一步增强，用利润偿还借款有足够的保障</p>
			
			<label class="fkcs_l">风控措施</label>
			<p class="fkcs_p">
				1、	保证担保： 河南中孚实业股份有限公司（600595.SH）出具担保函，公告编号：临2016-013，为河南中孚电力有限公司的到期还款义务承担连带责任保证。<br />
				2、	质押担保：河南中孚实业股份有限公司提供约2.7亿元应收账款为本次融资作质押担保。<br />
				3、	项目监管：债券管理人对本期私募债募集资金设立共管户进行共管。
			</p>
			<label class="brief_l">增信方介绍</label>
			<p class="brief_p">
				河南中孚实业股份有限公司是以铝精深加工为主体、拥有煤电铝全产业链的大型现代化国际企业，2002年6月在上海证券交易所挂牌上市。公司注册资本17.42亿元，现有总资产250多亿元，总市值约111亿元（截至2016年1月19日收盘）拥有100万吨以上铝及铝精深加工产能、配套300万吨原煤、900MW火力发电和15万吨炭素的产业规模，整体实力位居中国铝行业第一方阵，目前是河南省煤电铝及铝加工一体化转型升级示范性企业。
			</p>
		</div>
		
		<div class="btn_cont">
			<div class="btn" onclick="window.open('${ctx}/newsinformation/contractZfdl.htm')">
				查看合同模板
			</div>
		</div>
	</div>
	<%@ include file="/static/footer.jsp" %>
	
	<script type="text/javaScript">
	    $(function(){
			BASE.removeCss();
		})
	</script>
	</body>
</html>
