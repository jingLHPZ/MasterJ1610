<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/newtaglibs.jsp"%>
 <ul class="main">
	<c:forEach items="${pePage.result}" var="peProduct">
		<li class="clearFix <c:if test="${peProduct.status!=2}">open_mask</c:if>">
			<dl>
				<dt>
					<a href="javascript://" <c:if test="${peProduct.status==2}">onclick="queryProductDetail(${peProduct.productId},1);"</c:if>>${peProduct.productName}</a>
				</dt>
				<dd class="th_1">
					<h4>
						<em><fmt:formatNumber value="${peProduct.financingScale}" pattern="###,##0.00"/></em><small>万元</small>
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
						<span><fmt:formatNumber value="${peProduct.investLimit}" pattern="###,##0.00"/></span>万元
					</h4>
					<p>投资门槛</p>
				</dd>
				<dd class="th_5">
					<h4>
						<span><c:choose><c:when test="${peProduct.status==1}">即将开始</c:when><c:when test="${peProduct.status==2}">募集中</c:when><c:when test="${peProduct.status==3}">募集结束</c:when><c:otherwise>即将开始</c:otherwise></c:choose></span>
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