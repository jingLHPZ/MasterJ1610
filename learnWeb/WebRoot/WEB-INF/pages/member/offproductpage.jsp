<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/commonTags.jsp"%>
<div class="in_lis_t">
						<label>起息日:</label>
						<ul>
							<li class="<c:if test="${timeType == 1||timeType == 0}" >ils_c</c:if>" onclick='trans("1");' id="1">全部</li>
							<li class="<c:if test="${timeType == 2}">ils_c</c:if>" onclick='trans("2");' id="2" >近1周</li>
							<li class="<c:if test="${timeType == 3}">ils_c</c:if>" onclick='trans("3");' id="3">近1个月</li>
							<li class="<c:if test="${timeType == 4}">ils_c</c:if>" onclick='trans("4");' id="4">近3个月</li>
							<!--<li>高级搜索</li>-->
							<li class="inv_gjss">
								<select>
									<option>2015</option>
									<option>2012</option>
									<option>2013</option>
								</select>
								<label>年</label>
								<select>
									<option>1</option>
									<option>2</option>
									<option>3</option>
								</select>
								<label>月</label>
								<!--<a href="javascript://">高级搜索</a>-->
							</li>
						</ul>
					</div>
					<!--表格-->
					<div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="16%">名称/期次</th>
								<th width="16%">投资金额</th>
								<th width="8%">预期年化</th>
								<th width="8%">投资期限</th>
								<th width="20%">付息方式</th>
								<th width="12%">起息日</th>
								<th width="12%">最终还款日</th>
								<th width="16%">状态</th>
							</tr>
							<c:choose>
								<c:when test="${empty offpage.result}">
									<tr><td colspan="8"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${offpage.result}" var="product">
										<tr>
											<td align="left" title="${product.productName}">
												<c:choose>
													<c:when test="${fn:length(product.productName) > 9}">${fn:substring(product.productName, 0, 9)}...</c:when>
													<c:otherwise>${product.productName}</c:otherwise>
												</c:choose>
											</td>
											<td><fmt:formatNumber value="${product.investMoney}" pattern='###,##0.00'/>元</td>
											<td><fmt:formatNumber type="number" value="${product.investInterestRate*100}" pattern="0" maxFractionDigits="2"/>%</td>
											<td>
												<c:choose>
													<c:when test="${empty product.borrowDayDuration || product.borrowDayDuration==0}">
														${product.borrowMonthDuration}个月
													</c:when>
													<c:otherwise>
														${product.borrowDayDuration}天
													</c:otherwise>
												</c:choose>
											</td>
											<td>
												<c:if test="${product.repaymentType==1}">每月付息，到期还本</c:if>
												<c:if test="${product.repaymentType==2}">到期还本付息</c:if>
												<c:if test="${product.repaymentType==3}">每月等额本息</c:if>
												<c:if test="${product.repaymentType==4}">到期付息</c:if>
												<c:if test="${product.repaymentType==5}">每月付息，到期还本</c:if>
												<c:if test="${product.repaymentType==6}">每季度付息，到期还本</c:if>
												<c:if test="${product.repaymentType==7}">每半年付息，到期还本</c:if>
												<c:if test="${product.repaymentType==8}">每月等额本金</c:if>
											</td>
											<td>
												<fmt:formatDate value="${product.valueDate}" pattern='yyyy-MM-dd'/>
											</td>
											<td>
												<fmt:formatDate value="${product.lastReturnTime}" pattern='yyyy-MM-dd'/>
											</td>
											<td>投资成功</td>
										    </tr>
										</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
					<!--分页-->
					<c:choose>
					<c:when test="${empty offpage.result}"></c:when>
					<c:otherwise>
					 <div class="inves_pg">
						<div class="page_fy">
							<li:pagination methodName="fquerySiproPage" pageBean="${offpage}" sytleName="page_fy"/>
						</div>
					 </div>
					 </c:otherwise>
					</c:choose>