<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/static/commonTags.jsp"%>
<script type="text/javascript" src="${ctx}/js/countDown.js"></script>
<!--专享理财-->
<!--
	open_mask为禁止点击状态，并显示遮罩
	waiting框默认隐藏，加show显示
-->
<div class="bg finance">
	<div class="container">
		<div class="proj_name">
			<h4>专享理财</h4>
			<p><a href="javascript://">更多</a></p>
		</div>
		<div class="cont">
			<a class="more" href="javascript://">更多专享理财></a>
			<div class="box">
				<c:choose>
					<c:when test="${empty silist}">
						<div class="option th_1">
							<div class="waiting show">
								<img src="${ctx}/V2/img/bg/index_cj01.png"/>
								<p>项目筹备中，敬请期待···</p>
							</div>
						</div>
						<div class="option th_2">
							<div class="waiting show">
								<img src="${ctx}/V2/img/bg/index_cj01.png"/>
								<p>项目筹备中，敬请期待···</p>
							</div>
						</div>
						<div class="option th_3">
							<div class="waiting show">
								<img src="${ctx}/V2/img/bg/index_cj01.png"/>
								<p>项目筹备中，敬请期待···</p>
							</div>
						</div>
					</c:when>
					<c:when test="${fn:length(silist) == 1}">
						<div class="option th_2">
							<div class="waiting show">
								<img src="${ctx}/V2/img/bg/index_cj01.png"/>
								<p>项目筹备中，敬请期待···</p>
							</div>
						</div>
						<div class="option th_3">
							<div class="waiting show">
								<img src="${ctx}/V2/img/bg/index_cj01.png"/>
								<p>项目筹备中，敬请期待···</p>
							</div>
						</div>
					</c:when>
					<c:when test="${fn:length(silist) == 2}">
						<div class="option th_3">
							<div class="waiting show">
								<img src="${ctx}/V2/img/bg/index_cj01.png"/>
								<p>项目筹备中，敬请期待···</p>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<c:forEach items="${silist}" var="product" varStatus="status">
							<c:choose>
								<c:when test="${product.productAdaptedType==3}">
									<c:choose>
										<c:when test="${product.borrowStatus==10}">
											<div class="option th_${status.index + 1}">
												<h4>
													<a href="javascript://">***私募基金</a>
												</h4>
												<p>
													<label>起投金额</label>
													<span>***元</span>
												</p>
												<div class="progress_bar">
													<div style="width: 0%;"></div>
												</div>
												<p>
													<span>***元</span>&nbsp;/&nbsp;
													<span>***元</span>
												</p>
												<div class="profit_time clearFix">
													<div class="left">
														<h2>***<span>%</span></h2>
														<p>预期年化收益率</p>
													</div>
													<div class="right">
														<h2>***<span><c:choose><c:when test="${not empty product.borrowMonthDuration}">个月</c:when><c:otherwise>天</c:otherwise></c:choose></span></h2>
														<p>投资期限</p>
													</div>
												</div>
												<p>***</p>
												<!--可投资的-->
												<a class="round_spread btn" href="${ctx}/borrowinvest/questionnaire.htm">完成问卷</a>
												<!--失效的默认隐藏-->
												<a class="btn_failed" href="javascript://">回款中</a>
												<!--遮罩-->
												<div class="mask_jjks"></div>
												<div class="waiting">
													<img src="${ctx}/V2/img/bg/index_cj01.png"/>
													<p>项目筹备中，敬请期待···</p>
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<div class="option th_${status.index + 1} <c:if test="${product.borrowStatus==9}">open_mask</c:if>">
												<h4>
													<a  title='${product.productName}' href="javascript://">${product.productName}</a>
												</h4>
												<p>
													<label>起投金额</label>
													<span><fmt:formatNumber value="${product.investMin}" pattern="#,###,###"/>元</span>
												</p>
												<div class="progress_bar">
													<div style="width: <c:choose><c:when test="${not empty product.surplusmon}"><fmt:formatNumber value="${product.caninvest*100}" pattern="#,##0.00#"/>%</c:when><c:otherwise>0.00%</c:otherwise></c:choose>"></div>
												</div>
												<p>
													<span><c:choose><c:when test="${not empty product.surplusmon}"><fmt:formatNumber value="${product.surplusmon}" pattern="#,###,###"/></c:when><c:otherwise><fmt:formatNumber value="${product.surplusmon}" pattern="#,###,###"/></c:otherwise></c:choose>元</span>&nbsp;/&nbsp;
													<span><fmt:formatNumber value="${product.borrowMoney}" pattern="#,###,###"/>元</span>
												</p>
												<div class="profit_time clearFix">
													<div class="left">
														<h2><fmt:formatNumber type="number" value="${product.borrowInterestRate*100}" pattern="###.##" maxFractionDigits="2"/><span>%</span></h2>
														<p>预期年化收益率</p>
													</div>
													<div class="right">
														<c:choose><c:when test="${not empty product.borrowMonthDuration}"><h2>${product.borrowMonthDuration}<span>个月</span></h2></c:when><c:otherwise><h2>${product.borrowDayDuration}<span>天</span></h2></c:otherwise></c:choose>
														<p>投资期限</p>
													</div>
												</div>
												<p><c:choose><c:when test="${product.repaymentType == 1}">每月付息到期还本</c:when><c:when test="${product.repaymentType == 2}">到期还本付息</c:when><c:when test="${product.repaymentType == 5}">每月付息，到期还本</c:when><c:when test="${product.repaymentType == 6}">每季度付息，到期还本</c:when><c:when test="${product.repaymentType == 7}">每半年付息，到期还本</c:when><c:otherwise>每月等额本息</c:otherwise></c:choose></p>
												<!--可投资的-->
												<c:choose>
													<c:when test="${product.borrowStatus == 9}">
														<a class="round_spread btn" href="javascript://"><b id='product_${product.productId}'>即将开始</b></a>
														<input class='product_${product.productId}' type='hidden' value='<fmt:formatDate value="${product.collectStartTime}" pattern="yyyy/MM/dd HH:mm:ss"/>'>
													</c:when>
													<c:when test="${product.borrowStatus == 3}">
														<a class="round_spread btn" href="javascript://">立即投资</a>
													</c:when>
													<c:when test="${product.borrowStatus == 4}">
														<a class="btn_failed show" href="javascript://">已满标</a>
													</c:when>
													<c:when test="${product.borrowStatus == 5}">
														<a class="btn_failed show" href="javascript://">已流标</a>
													</c:when>
													<c:when test="${product.borrowStatus == 6}">
														<a class="btn_failed show" href="javascript://">回款中</a>
													</c:when>
													<c:when test="${product.borrowStatus == 8}">
														<a class="btn_failed show" href="javascript://">回款完成</a>
													</c:when>
													<c:when test="${product.borrowStatus == 11}">
														<a  class="round_spread btn" href="javascript://">查看详情</a>
													</c:when>
												</c:choose>
												<!--遮罩-->
												<div class="mask_jjks"></div>
												<div class="waiting">
													<img src="${ctx}/V2/img/bg/index_cj01.png"/>
													<p>项目筹备中，敬请期待···</p>
												</div>
											</div>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<div class="option th_${status.index + 1} <c:if test="${product.borrowStatus==9}">open_mask</c:if>">
										<h4>
											<a title='${product.productName}' href="javascript://">${product.productName}</a>
										</h4>
										<p>
											<label>起投金额</label>
											<span><fmt:formatNumber value="${product.investMin}" pattern="#,###,###"/>元</span>
										</p>
										<div class="progress_bar">
											<div style="width: <c:choose><c:when test="${not empty product.surplusmon}"><fmt:formatNumber value="${product.caninvest*100}" pattern="#,##0.00#"/>%</c:when><c:otherwise>0.00%</c:otherwise></c:choose>"></div>
										</div>
										<p>
											<span><c:choose><c:when test="${not empty product.surplusmon}"><fmt:formatNumber value="${product.surplusmon}" pattern="#,###,###"/></c:when><c:otherwise><fmt:formatNumber value="${product.surplusmon}" pattern="#,###,###"/></c:otherwise></c:choose>元</span>&nbsp;/&nbsp;
											<span><fmt:formatNumber value="${product.borrowMoney}" pattern="#,###,###"/>元</span>
										</p>
										<div class="profit_time clearFix">
											<div class="left">
												<h2><fmt:formatNumber type="number" value="${product.borrowInterestRate*100}" pattern="###.##" maxFractionDigits="2"/><span>%</span></h2>
												<p>预期年化收益率</p>
											</div>
											<div class="right">
												<c:choose><c:when test="${not empty product.borrowMonthDuration}"><h2>${product.borrowMonthDuration}<span>个月</span></h2></c:when><c:otherwise><h2>${product.borrowDayDuration}<span>天</span></h2></c:otherwise></c:choose>
												<p>投资期限</p>
											</div>
										</div>
										<p><c:choose><c:when test="${product.repaymentType == 1}">每月付息到期还本</c:when><c:when test="${product.repaymentType == 2}">到期还本付息</c:when><c:when test="${product.repaymentType == 5}">每月付息，到期还本</c:when><c:when test="${product.repaymentType == 6}">每季度付息，到期还本</c:when><c:when test="${product.repaymentType == 7}">每半年付息，到期还本</c:when><c:otherwise>每月等额本息</c:otherwise></c:choose></p>
										<!--可投资的-->
										<c:choose>
											<c:when test="${product.borrowStatus == 9}">
												<a class="round_spread btn" href="javascript://"><b id='product_${product.productId}'>即将开始</b></a>
												<input class='product_${product.productId}' type='hidden' value='<fmt:formatDate value="${product.collectStartTime}" pattern="yyyy/MM/dd HH:mm:ss"/>'>
											</c:when>
											<c:when test="${product.borrowStatus == 3}">
												<a class="round_spread btn" href="javascript://">立即投资</a>
											</c:when>
											<c:when test="${product.borrowStatus == 4}">
												<a class="btn_failed show" href="javascript://">已满标</a>
											</c:when>
											<c:when test="${product.borrowStatus == 5}">
												<a class="btn_failed show" href="javascript://">已流标</a>
											</c:when>
											<c:when test="${product.borrowStatus == 6}">
												<a class="btn_failed show" href="javascript://">回款中</a>
											</c:when>
											<c:when test="${product.borrowStatus == 8}">
												<a class="btn_failed show" href="javascript://">回款完成</a>
											</c:when>
										</c:choose>
										<!--遮罩-->
										<div class="mask_jjks"></div>
										<div class="waiting">
											<img src="${ctx}/V2/img/bg/index_cj01.png"/>
											<p>项目筹备中，敬请期待···</p>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>
