<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/commonTags.jsp"%>
					<div class="in_lis_t">
						<label>加入时间:</label>
						<ul>
							<li class="<c:if test="${timeType == 1||timeType == 0}" >ils_c</c:if>" onclick='trans("2_1");' id="2_1">全部</li>
							<li class="<c:if test="${timeType == 2}">ils_c</c:if>" onclick='trans("2_2");' id="2_2" >近1周</li>
							<li class="<c:if test="${timeType == 3}">ils_c</c:if>" onclick='trans("2_3");' id="2_3">近1个月</li>
							<li class="<c:if test="${timeType == 4}">ils_c</c:if>" onclick='trans("2_4");' id="2_4">近3个月</li>
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
						<div class="in_lis_sele">
							项目状态:
							<select  onchange='typefun("2_5")' id="2_5">
								<option value="0" <c:if test="${type == 0}">selected</c:if>>全部</option>
								<option value="3" <c:if test="${type == 3}">selected</c:if>>竞标中</option>
								<option value="6" <c:if test="${type == 6}">selected</c:if>>回款中</option>
								<option value="8" <c:if test="${type == 8}">selected</c:if>>已结清</option>
								<option value="9" <c:if test="${type == 9}">selected</c:if>>已逾期</option>
							</select>
						</div>
					</div>
					<!--表格-->
					<div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="24%">名称/期次</th>
								<th width="20%">投资时间</th>
								<th width="16%">投资金额</th>
								<th width="11%">预期年化</th>
								<th width="8%">加息</th>
								<th width="8%">投资期限</th>
								<th width="13%">操作</th>
							</tr>
							<c:choose>
								<c:when test="${empty sipage.result}">
									<tr><td colspan="7"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${sipage.result}" var="siproduct">
										<tr>
											<td>
												<a href="<c:choose>
													<c:when test="${siproduct.productId==700000001 || siproduct.productId==700000002}">
														${ctx}/newHandProduct/fqueryNewHandProduct.htm?productId=700000001
													</c:when>
													<c:when test="${siproduct.productAdaptedType == 2}">
														${ctx}/siproduct/fquerybisipro.htm?proid=${siproduct.productId}
													</c:when>
													<c:when test="${siproduct.productAdaptedType == 3}">
														${ctx}/peproduct/fquerybisipro.htm?proid=${siproduct.productId}
													</c:when></c:choose>" title='${siproduct.productName}'>
													<c:choose>
														<c:when test="${fn:length(siproduct.productName) > 10}">${fn:substring(siproduct.productName, 0, 10)}...</c:when>
														<c:otherwise>${siproduct.productName}</c:otherwise>
													</c:choose>
												</a>
											</td>
											<td><fmt:formatDate value="${siproduct.createTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<c:choose>
												<c:when test="${siproduct.type==3}">
													<td class="prize">
														<fmt:formatNumber value="${siproduct.investorCapital}" pattern="#,##0.00#"/>元
														<div>含投资红包￥<fmt:formatNumber value="${siproduct.proValue}" pattern="#,###"/></div>
													</td>
												</c:when>
												<c:otherwise>
													<td>
														<fmt:formatNumber value="${siproduct.investorCapital}" pattern="#,##0.00#"/>元
													</td>
												</c:otherwise>
											</c:choose>
											<td><fmt:formatNumber type="number" value="${siproduct.borrowInterestRate*100}" pattern="##0.00" maxFractionDigits="2"/>%</td>
											<td>
											<c:choose>
											<c:when test="${empty siproduct.proValue||siproduct.type!=2}">----</c:when>
											<c:otherwise>+
											<fmt:formatNumber type="number" value="${siproduct.proValue*100}" pattern="##0.00" maxFractionDigits="2"/>%
											</c:otherwise>
											</c:choose>
											</td>
											<td>
											<c:choose>
											<c:when test="${empty siproduct.borrowMonthDuration||siproduct.borrowMonthDuration==0}">
											    ${siproduct.borrowDayDuration}天
											</c:when>
											<c:otherwise>
												${siproduct.borrowMonthDuration}月
											</c:otherwise>
										    </c:choose>
											</td>
											<td><a href="javascript:queryInvestDetail(${siproduct.productId},'${siproduct.systemTraceNo}');" class="inv_ck">查看</a></td>
										</tr>
										</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
					<!--分页-->
					<c:choose>
					<c:when test="${empty sipage.result}"></c:when>
					<c:otherwise>
					 <div class="inves_pg">
						<div class="page_fy">
							<li:pagination methodName="fquerySiproPage" pageBean="${sipage}" sytleName="page_fy"/>
						</div>
					 </div>
					 </c:otherwise>
					</c:choose>
			
