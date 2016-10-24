<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/newtaglibs.jsp"%>
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