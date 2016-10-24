<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/newtaglibs.jsp"%>
<ul class="main">
	<c:if test="${not empty yingxiangPage}">
		<c:forEach items="${yingxiangPage.result}" var="items">
			<li class="clearFix">
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