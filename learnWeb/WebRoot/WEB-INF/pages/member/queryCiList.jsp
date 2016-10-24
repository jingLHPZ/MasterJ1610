<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ include file="/static/commonTags.jsp"%>
					<div class="in_lis_t">
						<label>加入时间:</label>
						<ul>
							<li class="<c:if test="${timeType == 1||timeType == 0}">ils_c</c:if>" onclick='trans("1_1");' id="1_1">全部</li>
							<li class="<c:if test="${timeType == 2}">ils_c</c:if>" onclick='trans("1_2");' id="1_2">近1周</li>
							<li class="<c:if test="${timeType == 3}">ils_c</c:if>" onclick='trans("1_3");' id="1_3">近1个月</li>
							<li class="<c:if test="${timeType == 4}">ils_c</c:if>" onclick='trans("1_4");' id="1_4">近3个月</li>
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
							<select  id="1_5"  onchange='typefun("1_5")'>
								<option value="0" <c:if test="${type == 0}">selected</c:if>>全部</option>
								<option value="3" <c:if test="${type == 3}">selected</c:if>>竞标中</option>
								<option value="6" <c:if test="${type == 6}">selected</c:if>>回款中</option>
								<option value="8" <c:if test="${type == 8}">selected</c:if>>已结清</option>
								<option value="9" <c:if test="${type == 9}">selected</c:if>>已逾期</option>
							</select>
						</div>
					</div>
					<!--表格 涨中宝-->
					<div class="media_table_cont">
						<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="24%">名称/期次</th>
								<th width="20%">加入时间</th>
								<th width="16%">加入金额</th>
								<th width="11%">预期年化</th>
								<th width="8%">加息</th>
								<th width="8%">投资期限</th>
								<th width="13%">操作</th>
							</tr>
							<c:choose>
								<c:when test="${empty cipage.result}">
									<tr><td colspan="7"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${cipage.result}" var="ciproduct">
										<tr>
											<td>
											<a href="${ctx}/ciProduct/fqueryCiProduct.htm?productId=${ciproduct.productId}" title="${ciproduct.productName}">
												<c:choose>
													<c:when test="${fn:length(ciproduct.productName) > 10}">${fn:substring(ciproduct.productName, 0, 10)}</c:when>
													<c:otherwise>${ciproduct.productName}</c:otherwise>
												</c:choose>
											</a>
											</td>
											<td><fmt:formatDate value="${ciproduct.createTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/><br /></td>
											<td><fmt:formatNumber value="${ciproduct.investorCapital}" pattern="#,##0.00#"/></td>
											<td><fmt:formatNumber type="number" value="${ciproduct.borrowInterestRate*100}" pattern="##0.00" maxFractionDigits="2"/>%</td>
											<td>
											<c:choose>
											<c:when test="${empty ciproduct.proValue||ciproduct.type!=2}">----</c:when>
											<c:otherwise>+
											<fmt:formatNumber type="number" value="${ciproduct.proValue*100}" pattern="##0.00" maxFractionDigits="1"/>%
											</c:otherwise>
											</c:choose>
											<td>
											<c:choose>
											<c:when test="${empty ciproduct.borrowMonthDuration||ciproduct.borrowMonthDuration==0}">
											    ${ciproduct.borrowDayDuration}天
											</c:when>
											<c:otherwise>
												${ciproduct.borrowMonthDuration}月
											</c:otherwise>
										    </c:choose>
											</td>
											<td><a href="javascript:queryInvestDetail(${ciproduct.productId},'${ciproduct.systemTraceNo}');" class="inv_ck">查看</a></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
					<!-- 分页 -->
					<c:choose>
					<c:when test="${empty cipage.result}"></c:when>
					<c:otherwise>
					 <div class="inves_pg">
							    	<!--分页-->
								<div class="page_fy">
									<li:pagination methodName="fqueryCiproPage" pageBean="${cipage}" sytleName="page_fy"/>
								</div>
					 </div>
					</c:otherwise>
					</c:choose>