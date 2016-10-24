<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/static/newtaglibs.jsp"%>
		<div class="in_ckxq_bod">
			<div class="in_ckxq_title">
				<h2>${productName}</h2>
				<c:if test="${(productType != 4 && (borrowStatus=='还款中' || borrowStatus == '完成' || borrowStatus == '逾期')) || productType == 4}">
					<c:if test="${productType != 8}">
						<a href="javascript:void(0)" onclick="window.open('${ctx}/repayementdetail/downloadUserSignature.htm?systemTraceNo=${systemTraceNo}&pid=${pid}')">查看投资协议</a>
					</c:if>
				</c:if>
				<div></div>
			</div>
			<ul class="in_ckxq_font">
				<li>
					<p>${interest}元</p>
					<label>预期收益</label>
				</li>
				<li>
					<p>${interestCoupon}元</p>
					<label>加息券额外收益</label>
				</li>
				<li class="ick_lis1">
					<p>${paymentType}</p>
					<label>收益方式</label>
				</li>
				<li>
					<p>
						<c:choose>
							<c:when test="${productType==9}">
								<fmt:formatDate value="${lastTime}" pattern="yyyy-MM-dd"/>
							</c:when>
							<c:otherwise>
								<c:if test="${fn:length(repaymentDetailList) > 0}">
									<fmt:formatDate value="${repaymentDetailList[fn:length(repaymentDetailList)-1].repaymentTime}" pattern="yyyy-MM-dd"/>
								</c:if>
								<c:if test="${fn:length(repaymentDetailList) == 0}">
									--
								</c:if>
							</c:otherwise>
						</c:choose>
					</p>
					<label>到期日</label>
				</li>
				<li class="ick_lis2">
					<p>${borrowStatus}</p>
					<label>项目状态</label>
				</li>
			</ul>
			<!--回款计划-->
			<h2 class="in_hkjh_title">
				回款计划(${totalCount}期)
			</h2>
			<div class="media_table_cont">
				<table cellpadding="0" cellspacing="0" class="in_tab_t">
					<tr>
					 	<th width="12%">期数</th>
						<th width="18%">预期回款日</th>
						<th width="18%">实际回款日</th>
						<th width="20%">回款本金</th>
						<th width="17%">回款收益</th>
						<!-- <th width="180">加息券额外收益</th> -->
						<th width="15%">回款状态</th>
					</tr>
				</table>
				<div class="in_hkjh_tab">
					<table cellpadding="0" cellspacing="0">
						<c:if test="${fn:length(repaymentDetailList) > 0}">
							<c:forEach var="item" items="${repaymentDetailList}" varStatus="s">
								<tr>
									<td width="12%">${item.sortOrder}</td>
									<td width="18%"><fmt:formatDate value="${item.repaymentTime}" pattern="yyyy-MM-dd"/></td>
									<td width="18%"><fmt:formatDate value="${item.realReturnDate}" pattern="yyyy-MM-dd"/></td>
									<td width="20%">${item.capital}元</td>
									<td width="17%">${item.interest}元</td>
									<!-- <td width="180">12.06元</td> -->
									<td width="15%">${item.status==1?'待收款':item.status==2?'收款成功':item.status==3?'收款失败':''}</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${fn:length(repaymentDetailList) < 1}">
							<tr>
								<td colspan="6">没有回款记录</td>
							</tr>
						</c:if>
					</table>
				</div>
			</div>
		</div>
