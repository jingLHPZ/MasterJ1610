<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit" /> 
	<meta http-equiv="X-UA-Compatible" content="IE=10" />
	<meta name = "format-detection" content="telephone = no" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
	<%@ include file="/static/newtaglibs.jsp"%>
	<title>
		<c:if test="${type == 1}">新手专区_体验标_新手标_学呗互联网金融</c:if>
		<c:if test="${type == 3}">专享理财_私募债_学呗互联网金融</c:if>
		<c:if test="${type == 4}">盈享理财_债权转让_学呗互联网金融</c:if>
		<c:if test="${type == 5}">私募基金_高端理财_学呗互联网金融</c:if>
		<c:if test="${type == 6}">券商理财_高端理财_学呗互联网金融</c:if>
	</title>
	<link rel="stylesheet" href="${ctx}/V2/css/list.css" />
	<script type="text/javascript" src="${ctx}/V2/js/TouchSlide.1.1.js"></script>
	<script type="text/javascript" src="${ctx}/js/countExDown.js"></script>
	<script type="text/javascript" src="${ctx}/js/countDown.js"></script>
</head>
<body>
<%@ include file="/static/top.jsp" %>
	<div class="bg list">
		<div class="container">
			<div class="cont">
				<ul class="menu clearFix">
					<li data="novice" onclick="menuChange(1);">
						<b></b><label>新手专区</label>
					</li>
					<li data="special" onclick="menuChange(3);">
						<b></b><label>专享理财</label>
					</li>
					<li data="loan" onclick="menuChange(4);">
						<b></b><label>盈享理财</label>
					</li>
					<li data="ban" class="ban">
						<b></b><label>高端理财</label>
					</li>
					<li id="endPartner" onclick="menuChange(5);" data="partner" class="li_2 <c:if test="${type==5}">active</c:if>">
						<label>私募基金</label>
					</li>
					<li id="endBroker" onclick="menuChange(6);" data="broker" class="li_2 <c:if test="${type==6}">active</c:if>">
						<label>券商理财</label>
					</li>
				</ul>
				<div class="box novice">
					<ul class="main">
					<c:choose>
						<c:when test="${empty newlist}">
							<li class="open_mask clearFix">
							<dl>
								<dt>
									<a href="javascript://">新手标</a>
								</dt>
								<dd class="th_1">
									<h4>
										<em>8.70</em><small>%</small>
									</h4>
									<p>预期年化收益率</p>
								</dd>
								<dd class="th_2">
									<h4>
										<span>243</span>天
									</h4>
									<p>投资期限</p>
								</dd>
								<dd class="th_3">
									<h4>
										<span>1</span>元
									</h4>
									<p>起投金额</p>
								</dd>
								<dd class="th_4">
									<h5>
										<b></b>
										<span>仅限首次投资</span>
									</h5>
								</dd>
							</dl>
							<a class="round_spread btn" href="javascript://">立即投资</a>
							<a class="btn_failed" href="javascript://">回款中</a>
							<div class="mask_jjks_nh"></div>
						</li>
						</c:when>
						<c:otherwise>
							<c:forEach items="${newlist}" var="newproduct">
							<li class="clearFix <c:if test='${newproduct.borrowStatus==9}'>open_mask</c:if>">
							<dl>
								<dt>
									<a href="${ctx}/newHandProduct/fqueryNewHandProduct.htm?productId=${newproduct.productId}">${newproduct.productName}</a>
								</dt>
								<dd class="th_1">
									<h4>
										<em><fmt:formatNumber type="number" value="${newproduct.borrowInterestRate*100}" pattern="###.##" maxFractionDigits="2"/></em><small>%</small>
									</h4>
									<p>预期年化收益率</p>
								</dd>
								<dd class="th_2">
									<h4>
										<c:choose>
											<c:when test="${empty newproduct.borrowMonthDuration||newproduct.borrowMonthDuration==0}">
											    <span>${newproduct.borrowDayDuration}</span>天
											</c:when>
											<c:otherwise>
												<span>${newproduct.borrowMonthDuration}</span>月
											</c:otherwise>
										</c:choose>
									</h4>
									<p>投资期限</p>
								</dd>
								<dd class="th_3">
									<h4>
										<span><fmt:formatNumber value="${newproduct.investMin}" pattern="###,###"/></span>元
									</h4>
									<p>起投金额</p>
								</dd>
								<dd class="th_4">
									<h5>
										<b></b>
										<span>仅限首次投资</span>
									</h5>
								</dd>
							</dl>
							<a class="round_spread btn" href="${ctx}/newHandProduct/fqueryNewHandProduct.htm?productId=${newproduct.productId}">立即投资</a>
							<a class="btn_failed" href="javascript://">回款中</a>
							<div class="mask_jjks_nh"></div>
							</li>
							</c:forEach>
						</c:otherwise>
					</c:choose>
						<c:choose>
						<c:when test="${empty exlist}">
							<li class="open_mask clearFix">
							<dl>
								<dt>
									<a href="javascript://">体验标</a>
								</dt>
								<dd class="th_1">
									<h4>
										<em>8.70</em><small>%</small>
									</h4>
									<p>预期年化收益率</p>
								</dd>
								<dd class="th_2">
									<h4>
										<span>243</span>天
									</h4>
									<p>投资期限</p>
								</dd>
								<dd class="th_3">
									<h4>
										<span>100</span>元
									</h4>
									<p>起投金额</p>
								</dd>
								<dd class="th_4">
									<h5>
										<b></b>
										<span>仅限投资体验金</span>
									</h5>
								</dd>
							</dl>
							<a class="round_spread btn" href="javascript://">立即投资</a>
							<a class="btn_failed" href="javascript://">回款中</a>
							<div class="mask_jjks_ex"></div>
						</li>
						</c:when>
						<c:otherwise>
							<c:forEach items="${exlist}" var="exproduct">
							<li class="clearFix <c:if test='${exproduct.borrowStatus==9}'>open_mask</c:if>">
							<input class="endProduct_${exproduct.productId}" type="hidden" value="<fmt:formatDate value="${exproduct.collectEndTime}" pattern="yyyy/MM/dd HH:mm:ss"/>"/> 
							<input class="startProduct_${exproduct.productId}" type="hidden" value="<fmt:formatDate value="${exproduct.collectStartTime}" pattern="yyyy/MM/dd HH:mm:ss"/>"/>
							<dl>
								<dt>
									<a href="${ctx}/experienceProduct/fqueryExperienceProduct.htm?productId=${exproduct.productId}">${exproduct.productName}</a>
								</dt>
								<dd class="th_1">
									<h4>
										<em><fmt:formatNumber type="number" value="${exproduct.borrowInterestRate*100}" pattern="###.##" maxFractionDigits="2"/></em><small>%</small>
									</h4>
									<p>预期年化收益率</p>
								</dd>
								<dd class="th_2">
									<h4>
										<c:choose>
											<c:when test="${empty exproduct.borrowMonthDuration||exproduct.borrowMonthDuration==0}">
											    <span>${exproduct.borrowDayDuration}</span>天
											</c:when>
											<c:otherwise>
												<span>${exproduct.borrowMonthDuration}</span>月
											</c:otherwise>
										</c:choose>
									</h4>
									<p>投资期限</p>
								</dd>
								<dd class="th_3">
									<h4>
										<span><fmt:formatNumber value="${exproduct.investMin}" pattern="###,###"/></span>元
									</h4>
									<p>起投金额</p>
								</dd>
								<dd class="th_4">
									<h5>
										<b></b>
										<span>仅限投资体验金</span>
									</h5>
								</dd>
							</dl>
							<a class="round_spread btn" href="${ctx}/experienceProduct/fqueryExperienceProduct.htm?productId=${exproduct.productId}">立即投资</a>
							<a class="btn_failed" href="javascript://">回款中</a>
							<div class="mask_jjks_ex"></div>
							</li>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					</ul>
					<div class="guide">
							<a href="/selfaboutus/guide.jsp">
								<img src="/V2/img/list_guide.png"/>
							</a>
						</div>
				</div>
				
				<!--专享理财-->
				<div class="box special">
					<form name="sanform">
						<div id="alllist">
							<ul class="main">
							<c:choose>
								<c:when test="${empty proPage.result}"> <div id="tabList_no"></div></c:when>
						 		<c:otherwise>
						  		<c:forEach items="${proPage.result}" var="siproduct">
						  			<c:choose>
						  			<c:when test="${siproduct.borrowStatus== 10}">
				 						<li class="clearFix">
											<dl>
												<dt>
													<a href="javascript://">***私募基金</a>
												</dt>
												<dd class="th_1">
													<h4>
														<em>***</em><small>%</small>
													</h4>
													<p>预期年化收益率</p>
												</dd>
												<dd class="th_2">
													<h4>
														<span>***</span>天
													</h4>
													<p>投资期限</p>
												</dd>
												<dd class="th_3">
													<h4>
														<span>***</span>元
													</h4>
													<p>起投金额</p>
												</dd>
												<dd class="th_4">
													<p>***</p>
													<div class="progress_bar">
														<div style="width: 0%;"></div>
													</div>
													<p>***元  /  ***元</p>
												</dd>
											</dl>
											<a class="round_spread btn" href="${ctx}/borrowinvest/questionnaire.htm">完成问卷</a>
											<a class="btn_failed" href="javascript://">回款中</a>
											<!-- <div class="mask_jjks"></div> -->
										</li>
				 					</c:when>
				 					<c:otherwise>
				 				<c:choose>
				 					<c:when test="${siproduct.borrowStatus== 9}"><li class="open_mask clearFix"></c:when>
									<c:otherwise><li class="clearFix"></c:otherwise>
								</c:choose>
									<dl>
										<dt>
											<c:choose>
												<c:when test="${siproduct.productAdaptedType == 3}">
													<a href="${ctx}/peproduct/fquerybisipro.htm?proid=${siproduct.productId}">${siproduct.productName}</a>
												</c:when>
												<c:otherwise>
													<a href="${ctx}/siproduct/fquerybisipro.htm?proid=${siproduct.productId}">${siproduct.productName}</a>
												</c:otherwise>
											</c:choose>
											<c:if test="${siproduct.canBonus == 1}">
												<img style="display: inline-block;" alt="可用投资红包" title="可用投资红包" src="/img/icon/iconfont-hongbao.png">
											</c:if>
											<c:if test="${siproduct.canAddInterest == 1}">
												<img style="display: inline-block;" alt="可用加息券" title="可用加息券" src="/img/icon/iconfont-quan.png">
											</c:if>
										</dt>
										<dd class="th_1">
											<h4>
												<em><fmt:formatNumber type="number" value="${siproduct.borrowInterestRate*100}" pattern="##0.00" maxFractionDigits="2"/></em><small>%</small>
											</h4>
											<p>预期年化收益率</p>
										</dd>
										<dd class="th_2">
											<h4>
												<c:choose>
													<c:when test="${empty siproduct.borrowMonthDuration||siproduct.borrowMonthDuration==0}">
													    <span>${siproduct.borrowDayDuration}</span>天
													</c:when>
													<c:otherwise>
														<span>${siproduct.borrowMonthDuration}</span>月
													</c:otherwise>
												</c:choose>
											</h4>
											<p>投资期限</p>
										</dd>
										<dd class="th_3">
											<h4>
												<span><fmt:formatNumber value="${siproduct.investMin}" pattern="#,###,###"/></span>元
											</h4>
											<p>起投金额</p>
										</dd>
										<dd class="th_4">
											<p>
												<c:choose>
													<c:when test="${siproduct.repaymentType == 1}">
														每月付息，到期还本
													</c:when>
													<c:when test="${siproduct.repaymentType == 2}">
														到期还本付息
													</c:when>
													<c:when test="${siproduct.repaymentType == 5}">
														每月付息，到期还本
													</c:when>
													<c:when test="${siproduct.repaymentType == 6}">
														每季度付息，到期还本
													</c:when>
													<c:when test="${siproduct.repaymentType == 7}">
														每半年付息，到期还本
													</c:when>
													<c:otherwise>
														每月等额本息
													</c:otherwise>
												</c:choose>
											</p>
										<div class="progress_bar">
											<div style="width: 
												<c:choose>
													<c:when test="${not empty siproduct.haveInvestMoney}">
													<fmt:formatNumber value="${siproduct.caninvest*100}" pattern="#,##0.00#"/>%
													</c:when>
												<c:otherwise>0.00%</c:otherwise></c:choose>">
											</div>
										</div>
										<p><c:choose><c:when test="${not empty siproduct.haveInvestMoney}"><fmt:formatNumber value="${siproduct.haveInvestMoney}" pattern="#,###,###"/></c:when><c:otherwise>0</c:otherwise></c:choose>元&nbsp;/&nbsp;
										<fmt:formatNumber value="${siproduct.borrowMoney}" pattern="#,###,###"/>元</p>
										</dd>
										</dl>
									<c:choose>
										<c:when test="${siproduct.productAdaptedType == 3}">
											<c:if test="${siproduct.borrowStatus== 3}">
												<a class="round_spread btn" href="${ctx}/peproduct/fquerybisipro.htm?proid=${siproduct.productId}">立即投资</a>
												<div class="mask_jjks"></div>
											</c:if>
											<c:if test="${siproduct.borrowStatus== 4}">
												<a style="display: block;" class="btn_failed" href="${ctx}/peproduct/fquerybisipro.htm?proid=${siproduct.productId}">已满标</a>
												<div class="mask_jjks"></div>
											</c:if>
											<c:if test="${siproduct.borrowStatus== 5}">
												<a style="display: block;" class="btn_failed" href="${ctx}/peproduct/fquerybisipro.htm?proid=${siproduct.productId}">已流标</a>
												<div class="mask_jjks"></div>
											</c:if>
											<c:if test="${siproduct.borrowStatus== 6}">
												<a style="display: block;" class="btn_failed" href="${ctx}/peproduct/fquerybisipro.htm?proid=${siproduct.productId}">回款中</a>
												<div class="mask_jjks"></div>
											</c:if>
											<c:if test="${siproduct.borrowStatus== 8}">
												<a style="display: block;" class="btn_failed" href="${ctx}/peproduct/fquerybisipro.htm?proid=${siproduct.productId}">回款完成</a>
												<div class="mask_jjks"></div>
											</c:if>
											<c:if test="${siproduct.borrowStatus== 9}">
												<input class='product_si_${siproduct.productId}' type='hidden' value='<fmt:formatDate value="${siproduct.collectStartTime}" pattern="yyyy/MM/dd HH:mm:ss"/>'>
												<a style="display: block;" class="round_spread btn" href="${ctx}/peproduct/fquerybisipro.htm?proid=${siproduct.productId}"><b id='product_si_${siproduct.productId}' style="font-size:14px;"></b></a>
												<div class="mask_jjks"></div>
											</c:if>
											<c:if test="${siproduct.borrowStatus== 11}">
												<a style="display: block;" class="btn_failed" href="${ctx}/peproduct/fquerybisipro.htm?proid=${siproduct.productId}">查看详情</a>
												<div class="mask_jjks"></div>
											</c:if>
										</c:when>
										<c:otherwise>
											<c:if test="${siproduct.borrowStatus== 3}">
												<a class="round_spread btn" href="${ctx}/siproduct/fquerybisipro.htm?proid=${siproduct.productId}">立即投资</a>
												<div class="mask_jjks"></div>
											</c:if>
											<c:if test="${siproduct.borrowStatus== 4}">
												<a style="display: block;" class="btn_failed" href="${ctx}/siproduct/fquerybisipro.htm?proid=${siproduct.productId}">已满标</a>
												<div class="mask_jjks"></div>
											</c:if>
											<c:if test="${siproduct.borrowStatus== 5}">
												<a style="display: block;" class="btn_failed" href="${ctx}/siproduct/fquerybisipro.htm?proid=${siproduct.productId}">已流标</a>
												<div class="mask_jjks"></div>
											</c:if>
											<c:if test="${siproduct.borrowStatus== 6}">
												<a style="display: block;" class="btn_failed" href="${ctx}/siproduct/fquerybisipro.htm?proid=${siproduct.productId}">回款中</a>
												<div class="mask_jjks"></div>
											</c:if>
											<c:if test="${siproduct.borrowStatus== 8}">
												<a style="display: block;" class="btn_failed" href="${ctx}/siproduct/fquerybisipro.htm?proid=${siproduct.productId}">回款完成</a>
												<div class="mask_jjks"></div>
											</c:if>
											<c:if test="${siproduct.borrowStatus== 9}">
												<input class='product_si_${siproduct.productId}' type='hidden' value='<fmt:formatDate value="${siproduct.collectStartTime}" pattern="yyyy/MM/dd HH:mm:ss"/>'>
												<a style="display: block;" class="round_spread btn" href="${ctx}/siproduct/fquerybisipro.htm?proid=${siproduct.productId}"><b id='product_si_${siproduct.productId}' style="font-size:14px;"></b></a>
												<div class="mask_jjks"></div>
											</c:if>
										</c:otherwise>
									</c:choose>
									</li>
									</c:otherwise>
									</c:choose>
					 			</c:forEach>
					 			</c:otherwise>
					 		</c:choose>
							</ul>
						<c:choose>
						<c:when test="${not empty proPage}">
							<div class="page_box">
								<div class="pages">
									<li:pagination methodName="fqueryPage" pageBean="${proPage}" sytleName="pages"/>
								</div>
						    </div>
				    	</c:when>
				    	</c:choose>
						</div>
					</form>
				</div>
				
				<!--盈享理财-->
				<div class="box loan">
					<form name="yxform">
						<div class="yx_list">
						<ul class="main">
							<c:if test="${not empty yingxiangPage}">
								<c:forEach items="${yingxiangPage.result}" var="items">
									<li class="clearFix <c:if test="${items.borrowStatus!= 3}">open_mask</c:if>">
										<dl>
											<dt>
												<a href="${ctx}/yingxiang/queryYingXiangDetail.htm?proid=${items.productId}">${items.productName}</a>
												<c:if test="${items.productDetail.canBonus>0}">
													<img style="display: inline-block;" alt="可用投资红包" title="可用投资红包" src="${ctx}/img/icon/iconfont-hongbao.png">
												</c:if>
												<c:if test="${items.productDetail.canAddInterest>0}"><img style="display: inline-block;"  alt="可用加息券" title="可用加息券" src="${ctx}/img/icon/iconfont-quan.png"></c:if>
											</dt>
											<dd class="th_1">
												<h4>
													<em><fmt:formatNumber type="number" value="${items.borrowInterestRate*100}" pattern="#.##" maxFractionDigits="2"/></em><small>%</small>
												</h4>
												<p>预期年化收益率</p>
											</dd>
											<dd class="th_2">
												<h4>
													<span><fmt:formatDate value="${items.lastTime}" pattern="yyyy/MM/dd"/></span>
												</h4>
												<p>最终还款日</p>
											</dd>
											<dd class="th_3">
												<h4>
													<span><fmt:formatNumber value="${items.minInvest}" pattern="#,###,###"/></span>元
												</h4>
												<p>起投金额</p>
											</dd>
											<dd class="th_4">
												<p>
													<c:if test="${items.repaymentType == 1}">每月付息，到期还本</c:if>
													<c:if test="${items.repaymentType == 2}">到期还本付息</c:if>
													<c:if test="${items.repaymentType == 3}">每月等额本息</c:if>
													<c:if test="${items.repaymentType == 4}">到期付息</c:if>
													<c:if test="${items.repaymentType == 5}">每月付息，到期还本</c:if>
													<c:if test="${items.repaymentType == 6}">每季度付息，到期还本</c:if>
													<c:if test="${items.repaymentType == 7}">每半年付息，到期还本</c:if>
													<c:if test="${items.repaymentType == 8}">每月等额本金</c:if>
												</p>
												<div class="progress_bar">
													<div style="width: ${items.processRate}%;"></div>
												</div>
												<p><fmt:formatNumber value="${items.investMoney}" pattern="#,###,###"/>元  /  <fmt:formatNumber value="${items.borrowMoney}" pattern="#,###,###"/>元</p>
											</dd>
										</dl>
										
										<c:if test="${items.borrowStatus== 3}">
											<a class="round_spread btn" href="${ctx}/yingxiang/queryYingXiangDetail.htm?proid=${items.productId}">立即投资</a>
										</c:if>
										<c:if test="${items.borrowStatus== 4 || items.borrowStatus== 5 || items.borrowStatus== 6 || items.borrowStatus== 8}">
											<a style="display: block;" class="btn_failed btn" href="${ctx}/yingxiang/queryYingXiangDetail.htm?proid=${items.productId}">
												${items.borrowStatus== 4?'已满标':items.borrowStatus== 5?'已流标':items.borrowStatus== 6?'回款中':items.borrowStatus== 8?'回款完成':''}
											</a>
										</c:if>
										<c:if test="${items.borrowStatus== 9}">
											<a class="round_spread btn" href="${ctx}/yingxiang/queryYingXiangDetail.htm?proid=${items.productId}" style="font-size:14px;"><b id='product_${items.productId}'>即将开始</b></a>
											<input class='product_${items.productId}' type='hidden' value='<fmt:formatDate value="${items.collectStartTime}" pattern="yyyy/MM/dd HH:mm:ss"/>'>
											<div class="mask_jjks"></div>
										</c:if>
									</li>
								</c:forEach>
							</c:if>
							<c:if test="${empty yingxiangPage || empty yingxiangPage.result}">
								<li class="clearFix">
									<div class="waiting">
										<img src="${ctx}/V2/img/bg/list_waiting01.png"/>
									</div>
								</li>
							</c:if>
						</ul>					
						<c:if test="${not empty yingxiangPage}">
							<div class="page_box">
								<div class="pages">
									<li:pagination methodName="queryYxPage" pageBean="${yingxiangPage}" sytleName="pages"/>
								</div>
						    </div>
						</c:if>
						</div>
					</form>
				</div>
				
<!--私募基金===============================================-->
				<div class="box partner active">
					<form id="peform">
						<div id="pelist">
							<ul class="main">
								<c:if test="${empty pePage}">
									<li class="clearFix">
										<div class="waiting">
											<img src="${ctx}/V2/img/bg/list_waiting01.png"/>
										</div>
									</li>
								</c:if>
								<c:forEach items="${pePage.result}" var="peProduct">
									<li class="clearFix <c:if test="${peProduct.status!=2}">open_mask</c:if>">
										<dl>
											<dt>
												<a href="javascript://" <c:if test="${peProduct.status==2}">onclick="queryProductDetail(${peProduct.productId},1);"</c:if>>${peProduct.productName}</a>
											</dt>
											<dd class="th_1">
												<h4>
													<em><fmt:formatNumber value="${peProduct.financingScale}" pattern="###,###.##"/></em><small>万元</small>
												</h4>
												<p>融资规模</p>
											</dd>
											<dd class="th_2">
												<h4>
													<span>${peProduct.durationContent}</span>
													<c:if test="${peProduct.durationWay == 1}">年</c:if>
													<c:if test="${peProduct.durationWay == 2}">个月</c:if>
													<c:if test="${peProduct.durationWay == 3}">天</c:if>
												</h4>
												<p>存续期限</p>
											</dd>
											<dd class="th_3">
												<h4>
													<span><fmt:formatNumber value="${peProduct.investLimit}" pattern="###,###.##"/></span>万元
												</h4>
												<p>投资门槛</p>
											</dd>
											<dd class="th_5">
												<h4>
													<span><c:choose>
														<c:when test="${peProduct.status==1}">即将开始</c:when>
														<c:when test="${peProduct.status==2}">募集中</c:when>
														<c:when test="${peProduct.status==3}">募集结束</c:when>
														<c:otherwise>即将开始</c:otherwise>
														</c:choose>
													</span>
												</h4>
												<p>募集状态</p>
											</dd>
										</dl>
										<c:choose>
											<c:when test="${peProduct.status==1}"><a class="btn_failed" href="javascript://">查看详情</a><div class="mask_jjks"></div></c:when>
											<c:when test="${peProduct.status==2}"><a class="round_spread btn" href="javascript://" onclick="queryProductDetail(${peProduct.productId},1);">查看详情</a></c:when>
											<c:otherwise><a class="btn_failed" style="display: block;" href="javascript://">募集结束</a></c:otherwise>
										</c:choose>
									</li>
								</c:forEach>
							</ul>
							<c:if test="${not empty pePage}">
								<div class="page_box">
									<div class="pages">
										<li:pagination methodName="queryPePage" pageBean="${pePage}" sytleName="pages"/>
									</div>
							    </div>
							</c:if>
						</div>
					</form>
				</div>
<!--券商理财=====================================-->
				<div class="box broker">
					<form id="sbform">
						<div id="sblist">
							<ul class="main">
								<c:if test="${empty sbPage}">
									<li class="clearFix">
										<div class="waiting">
											<img src="${ctx}/V2/img/bg/list_waiting01.png"/>
										</div>
									</li>
								</c:if>
								<c:forEach items="${sbPage.result}" var="sbProduct">
									<li class="clearFix <c:if test="${sbProduct.status!=2}">open_mask</c:if>">
										<dl>
											<dt>
												<a href="javascript://" <c:if test="${sbProduct.status==2}">onclick="queryProductDetail(${sbProduct.productId},2);"</c:if>>${sbProduct.productName}</a>
											</dt>
											<dd class="th_1">
												<h4>
													<em><fmt:formatNumber value="${sbProduct.financingScale}" pattern="###,###.##"/></em><small>万元</small>
												</h4>
												<p>融资规模</p>
											</dd>
											<dd class="th_2">
												<h4>
													<span>${sbProduct.durationContent}</span>
													<c:if test="${sbProduct.durationWay == 1}">年</c:if>
													<c:if test="${sbProduct.durationWay == 2}">个月</c:if>
													<c:if test="${sbProduct.durationWay == 3}">天</c:if>
												</h4>
												<p>存续期限</p>
											</dd>
											<dd class="th_3">
												<h4>
													<span><fmt:formatNumber value="${sbProduct.investLimit}" pattern="###,###.##"/></span>万元
												</h4>
												<p>投资门槛</p>
											</dd>
											<dd class="th_5">
												<h4>
													 <span><c:choose><c:when test="${sbProduct.status==1}">即将开始</c:when><c:when test="${sbProduct.status==2}">募集中</c:when><c:when test="${sbProduct.status==3}">募集结束</c:when><c:otherwise>即将开始</c:otherwise></c:choose></span> 
												</h4>
												<p>募集状态</p>
											</dd>
										</dl>
										<c:choose>
											<c:when test="${sbProduct.status==1}"><a class="btn_failed" href="javascript://">查看详情</a><div class="mask_jjks"></div></c:when>
											<c:when test="${sbProduct.status==2}"><a class="round_spread btn" href="javascript://"  onclick="queryProductDetail(${sbProduct.productId},2);">查看详情</a></c:when>
											<c:otherwise><a class="btn_failed" style="display: block;" href="javascript://">募集结束</a></c:otherwise>
										</c:choose>
									</li>
								</c:forEach>
							</ul>
							<c:if test="${not empty sbPage}">
								<div class="page_box">
									<div class="pages">
										<li:pagination methodName="querySbPage" pageBean="${sbPage}" sytleName="pages"/>
									</div>
							    </div>
							</c:if>
						</div>
					</form>
				</div>
						
			</div>
		</div>
	</div>

<div id="openReal"></div>
<%@ include file="/static/footer.jsp" %>

<input type="hidden" value="${realname}" id="realname"/>
<input type="hidden" value="${question}" id="question"/>
<script type="text/javascript">


$(function(){
	var type = ${type};
	var menuNums = {
		1 : 0,
		2 : 1,
		3 : 1,
		4 : 2,
		5 : 4,
		6 : 5
	};
	var topNums = {
		1 : 1,
		2 : 1,
		3 : 2,
		4 : 3,
		5 : 4,
		6 : 4
	};
	$(".cont .box").hide();
	var data = $(".menu li").eq(menuNums[type]).attr('data');
	$(".cont ."+data).show();
	$(".menu li").eq(menuNums[type]).addClass("active");
	$(".top_menu li a").eq(topNums[type]).addClass("active");
	if($("#endPartner").attr('class') == "li_2 active"){
		$(".cont .box").hide();
		$(".cont .partner").show();
		$(".senior_top span").addClass("active");
	}
	if($("#endBroker").attr('class') == "li_2 active"){
		$(".cont .box").hide();
		$(".cont .broker").show();
		$(".senior_top span").addClass("active");
	}  
	
	var real=$("#realname").val();
	var type = ${type};
	if(real==0 && (type==5 || type==6)){
		$("#openReal").load("${ctx}/realName.jsp");
	}
	
	
});

function fqueryPage(pageNo,totalCount,pageSize) {
	var pars = $("#sanform").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
	$.ajax({
		type: "POST",
		url: "${ctx}/product/queryPage.htm",
		data: pars,
		success: function(result) {
			$('#alllist').html(result);
		}
	}); 
	$(document).scrollTop(0);
}

function queryYxPage(pageNo,totalCount,pageSize) {
	var pars = $("#yxform").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
	$.ajax({
		type: "POST",
		url: "${ctx}/product/queryYingXiangPageList.htm",
		data: pars,
		success: function(result) {
			$('.yx_list').html(result);
		}
	}); 
	$(document).scrollTop(0);
}

function queryPePage(pageNo,totalCount,pageSize) {
	var pars = $("#peform").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
	$.ajax({
		type: "POST",
		url: "${ctx}/product/queryPePageList.htm",
		data: pars,
		success: function(result) {
			$('#pelist').html(result);
		}
	}); 
	$(document).scrollTop(0);
}

function querySbPage(pageNo,totalCount,pageSize) {
	var pars = $("#sbform").serialize() +"&pageNo=" + pageNo + "&totalCount=" + totalCount + "&pageSize=" + pageSize;
	$.ajax({
		type: "POST",
		url: "${ctx}/product/querySbPageList.htm",
		data: pars,
		success: function(result) {
			$('#sblist').html(result);
		}
	}); 
	$(document).scrollTop(0);
}

function queryProductDetail(productId, type){
	var count = $("#question").val();
	var real=$("#realname").val();
	if(real==0){
		$("#openReal").load("${ctx}/realName.jsp");
		return false;
	}
	if(count == 0) {//未做问卷
		window.location.href = "${ctx}/borrowinvest/questionnaire.htm";
		return false;
	}
	window.location.href="${ctx}/endProduct/queryProductDetail.htm?productId="+productId+"&type="+type;
}




function menuChange(num) {
	if(num == 2) {
		location.href="${ctx}/cash/toPurchaseApplyDetail.htm";
	}
	location.href = "${ctx}/product/fqueryallproduct.htm?type=" + num;
} 
</script>
</body>
</html>