<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/static/commonTags.jsp"%>
<script type="text/javascript" src="${ctx}/js/countExDown.js"></script>
<!-- 新手专区 -->
<div class="bg attempt_begin">
	<div class="container no_border">
		<div class="proj_name">
			<h4>新手专区</h4>
		</div>
	</div>
	<div class="container">
		<c:choose>
			<c:when test="${empty exlist}">
				<div class="attempt box">
					<div class="cont open_mask">
						<div class="top">
							<h1>体验标</h1>
							<p>仅限投资体验金</p>
							<label>起投金额<span>100</span>元</label>
						</div>
						<div class="second clearFix">
							<div class="left">
								<em>10</em>
								<span>%</span>
								<p>预期年化收益率</p>
							</div>
							<div class="right">
								<em>7</em>
								<span>天</span>
								<p>投资期限</p>
							</div>
						</div>
						<a class="round_spread" href="javascript://">立即投资</a>
						<div class="mask_jjks_ex"></div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<c:forEach items="${exlist}" var="product">
					<div class="attempt box">
						<div class="cont <c:if test="${product.borrowStatus==9}">open_mask</c:if>">
							<input class="endProduct_${product.productId}" type="hidden" value="<fmt:formatDate value="${product.collectEndTime}" pattern="yyyy/MM/dd HH:mm:ss"/>"/> 
							<input class="startProduct_${product.productId}" type="hidden" value="<fmt:formatDate value="${product.collectStartTime}" pattern="yyyy/MM/dd HH:mm:ss"/>"/> 
							<div class="top">
								<h1 style="cursor: pointer;" onclick="detailEx(${product.borrowStatus},${product.productId});">${product.productName}</h1>
								<p>仅限投资体验金</p>
								<label>起投金额<span><fmt:formatNumber type="number" value="${product.investMin}" pattern="###.##"/></span>元</label>
							</div>
							<div class="second clearFix">
								<div class="left">
									<em><fmt:formatNumber type="number" value="${product.borrowInterestRate*100}" pattern="###.##" maxFractionDigits="2"/></em>
									<span>%</span>
									<p>预期年化收益率</p>
								</div>
								<div class="right">
									<em>${product.borrowDayDuration}</em>
									<span>天</span>
									<p>投资期限</p>
								</div>
							</div>
							<c:choose>
								<c:when test="${product.borrowStatus==9}">
									<a class="round_spread" href="javascript://">立即投资</a>
									<div class="mask_jjks_ex"></div>
								</c:when>
								<c:otherwise>
									<a href="javascript://" class="round_spread">立即投资</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<!--新手标-->
		<!--第二层：open_mask为禁止点击状态，并显示遮罩-->
		<c:choose>
			<c:when test="${empty newlist}">
				<div class="begin box">
					<div class="cont open_mask">
						<div class="top">
							<h1>新手标</h1>
							<p>首次投资专享</p>
							<label>起投金额<span>1</span>元</label>
						</div>
						<div class="second clearFix">
							<div class="left">
								<em>10</em>
								<span>%</span>
								<p>预期年化收益率</p>
							</div>
							<div class="right">
								<em>30</em>
								<span>天</span>
								<p>投资期限</p>
							</div>
						</div>
						<a class="round_spread" href="javascript://">立即投资</a>
						<div class="mask_jjks_nh"></div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<c:forEach items="${newlist}" var="product" varStatus="status">
					<div class="begin box">
						<div class="cont <c:if test="${product.borrowStatus==9}">open_mask</c:if>">
							<div class="top">
								<h1 style="cursor: pointer;" onclick="detailNew(${product.borrowStatus}, ${product.productId})">${product.productName}</h1>
								<p>首次投资专享</p>
								<label>起投金额<span><fmt:formatNumber type="number" value="${product.investMin}" pattern="###.##"/></span>元</label>
							</div>
							<div class="second clearFix">
								<div class="left">
									<em><fmt:formatNumber type="number" value="${product.borrowInterestRate*100}" pattern="###.##" maxFractionDigits="2"/></em>
									<span>%</span>
									<p>预期年化收益率</p>
								</div>
								<div class="right">
									<em>${product.borrowDayDuration}</em>
									<span>天</span>
									<p>投资期限</p>
								</div>
							</div>
							<c:choose>
								<c:when test="${product.borrowStatus==9}">
									<a class="round_spread" href="javascript://">立即投资</a>
									<div class="mask_jjks_nh"></div>
								</c:when>
								<c:otherwise>
									<a href="javascript://" class="round_spread">立即投资</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</div>
<script type="text/javascript"> 
	function detailEx(status, productId){
		if(status==9){
			return false;
		}
		return false;
	}
	function detailNew(status, productId){
		if(status==9){
			return false;
		}
		return false;
	}
</script>