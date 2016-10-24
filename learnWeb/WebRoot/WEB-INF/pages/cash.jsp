<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/static/commonTags.jsp"%>
<!--现金理财-->
<div class="bg cash">
	<div class="container">
		<c:if test="${cashMap.cashProduct.collectStatus == 0}">
		<div class="proj_name">
			<h4>现金理财</h4>
			<p><a href="javascript://">更多</a></p>
		</div>
			<div class="cont">
			<div class="box">
				<p class="title">活期宝<span>T+1随存随取</span></p>
				<ul class="clearFix">
					<li class="item_1">
						<h2>
						<c:choose>
							<c:when test="${empty cashMap.incomeRate}">--</c:when>
							<c:otherwise>
							<fmt:formatNumber value="${cashMap.incomeRate.avgIncomeRate*100}" pattern="#0.00" maxFractionDigits="2" />
							<span>%</span>
							</c:otherwise>
						</c:choose>
						</h2>
						<p>7日平均收益率</p>
					</li>
					<li class="item_2">
						<h3>
						<fmt:formatNumber value="${cashMap.cashProduct.investMin}" pattern="#,###.##"/>
						 <span>元</span></h3>
						<p>起投金额</p>
					</li>
					<li class="item_3">
						<h3>0<span>天</span></h3>
						<p>锁定期</p>
					</li>
					<li class="item_4">
						<h3>
						<c:choose>
							<c:when test="${empty cashMap.totalUsers}">0</c:when>
							<c:otherwise>${cashMap.totalUsers}</c:otherwise>
						</c:choose>
						<span>人</span></h3>
						<p>加入人数</p>
					</li>
					<li class="item_5">
						<h3>
						<c:choose>
							<c:when test="${empty cashMap.totalIncome}">0.00</c:when>
							<c:otherwise><fmt:formatNumber value="${cashMap.totalIncome}" pattern="#,##0.00"/></c:otherwise>
						</c:choose>
						<span>元</span></h3>
						<p>累计为用户赚取</p>
					</li>
				</ul>
				<div class="btn_cont">
					<a class="round_spread" href="javascript://">立即申购</a>
				</div>
				<div class="mask_jjks"></div>
			</div>
		</div>
		</c:if>
		<c:if test="${cashMap.cashProduct.collectStatus == 1}">
		<div class="proj_name">
			<h4>现金理财</h4>
			<p><a href="javascript://">更多</a></p>
		</div>
			<div class="cont open_mask">
			<div class="box">
				<p class="title">活期宝<span>T+1随存随取</span></p>
				<ul class="clearFix">
					<li class="item_1">
						<h2>
						<c:choose>
							<c:when test="${empty cashMap.incomeRate}">--</c:when>
							<c:otherwise>
							<fmt:formatNumber value="${cashMap.incomeRate.avgIncomeRate*100}" pattern="#0.00" maxFractionDigits="2" />
							<span>%</span>
							</c:otherwise>
						</c:choose>
						</h2>
						<p>7日平均收益率</p>
					</li>
					<li class="item_2">
						<h3>
						<fmt:formatNumber value="${cashMap.cashProduct.investMin}" pattern="#,###.##"/>
						 <span>元</span></h3>
						<p>起投金额</p>
					</li>
					<li class="item_3">
						<h3>0<span>天</span></h3>
						<p>锁定期</p>
					</li>
					<li class="item_4">
						<h3>
						<c:choose>
							<c:when test="${empty cashMap.totalUsers}">0</c:when>
							<c:otherwise>${cashMap.totalUsers}</c:otherwise>
						</c:choose>
						<span>人</span></h3>
						<p>加入人数</p>
					</li>
					<li class="item_5">
						<h3>
						<c:choose>
							<c:when test="${empty cashMap.totalIncome}">0.00</c:when>
							<c:otherwise><fmt:formatNumber value="${cashMap.totalIncome}" pattern="#,##0.00"/></c:otherwise>
						</c:choose>
						<span>元</span></h3>
						<p>累计为用户赚取</p>
					</li>
				</ul>
				<div class="btn_cont">
					<a class="round_spread" href="javascript://">即将开始</a>
				</div>
				<div class="mask_jjks"></div>
			</div>
		</div>
		</c:if>
	</div>
</div>