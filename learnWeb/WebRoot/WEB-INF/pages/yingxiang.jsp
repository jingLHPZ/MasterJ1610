<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/static/commonTags.jsp"%>
<script type="text/javascript" src="${ctx}/js/countDown.js"></script>

<!--open_mask为禁止点击状态，并显示遮罩-->
<div class="bg loan">
	<div class="container">
		<div class="proj_name">
			<h4>盈享理财</h4>
			<p><a href="javascript://">更多</a></p>
		</div>
		<div class="cont">
			<a class="more" href="javascript://">更多盈享理财></a>
			<div class="box">
				<c:if test="${not empty queryYingXiangList}">
					<c:forEach items="${queryYingXiangList}" var="items" varStatus="yx">
						<div class="option th_${yx.count} <c:if test="${items.borrowStatus!= 3}">open_mask</c:if>">
							<h4>
								<a href="javascript://" title="${items.productName}">${items.productName}</a>
							</h4>
							<p>
								<label>起投金额</label>
								<span><fmt:formatNumber value="${items.minInvest}" pattern="#,###"/>元</span>
							</p>
							<div class="progress_bar">
								<div style="width: ${items.processRate}%;"></div>
							</div>
							<p>
								<span><fmt:formatNumber value="${items.investMoney}" pattern="#,###"/>元</span>&nbsp;/&nbsp;
								<span><fmt:formatNumber value="${items.borrowMoney}" pattern="#,###"/>元</span>
							</p>
							<div class="profit_time clearFix">
								<div class="left">
									<h2><fmt:formatNumber type="number" value="${items.borrowInterestRate * 100}" pattern="#.##" maxFractionDigits="2"/><span>%</span></h2>
									<p>预期年化收益率</p>
								</div>
								<div class="right">
									<h2>
										<fmt:formatDate value="${items.lastTime}" pattern="yyyy/MM/dd"/>
									</h2>
									<p>最终还款日</p>
								</div>
							</div>
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
							
							<c:if test="${items.borrowStatus== 3}">
								<a class="round_spread btn" href="javascript://">立即投资</a>
							</c:if>
							<c:if test="${items.borrowStatus== 4 || items.borrowStatus== 5 || items.borrowStatus== 6 || items.borrowStatus== 8}">
								<a style="display: block;" class="btn_failed btn" href="javascript://">
									${items.borrowStatus== 4?'已满标':items.borrowStatus== 5?'已流标':items.borrowStatus== 6?'回款中':items.borrowStatus== 8?'回款完成':''}
								</a>
							</c:if>
							<c:if test="${items.borrowStatus== 9}">
								<a class="round_spread btn" href="javascript://"><b id='product_${items.productId}'>即将开始</b></a>
								<input class='product_${items.productId}' type='hidden' value='<fmt:formatDate value="${items.collectStartTime}" pattern="yyyy/MM/dd HH:mm:ss"/>'>
								<div class="mask_jjks"></div>
							</c:if>
						</div>
					</c:forEach>
				</c:if>
				
				<c:forEach var="i" begin="1" end="${3 - fn:length(queryYingXiangList)}" step="1">   
					<div class="option th_3 open_mask">
						<div class="waiting show">
							<img src="/V2/img/bg/index_cj01.png"/>
							<p>项目筹备中，敬请期待···</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>