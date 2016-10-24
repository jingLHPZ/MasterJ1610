<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ include file="/static/commonTags.jsp"%>
        <div class="in_lis_t">
						<label>加入时间:</label>
						<ul>
							<li class="<c:if test="${timeType == 1||timeType == 0}" >ils_c</c:if>" onclick='trans("3_1");' id="3_1">全部</li>
							<li class="<c:if test="${timeType == 2}">ils_c</c:if>" onclick='trans("3_2");' id="3_2">近1周</li>
							<li class="<c:if test="${timeType == 3}">ils_c</c:if>" onclick='trans("3_3");' id="3_3">近1个月</li>
							<li class="<c:if test="${timeType == 4}">ils_c</c:if>" onclick='trans("3_4");' id="3_4">近3个月</li>
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
						<div class="in_lis_sele" style="display:none;">
							项目状态:
							<select  onchange='typefun("3_5")' id="3_5">
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
								<th width="22%">投资时间</th>
								<th width="21%">投资体验金</th>
								<th width="16%">预期年化</th>
								<!-- <th width="11%">加息</th> -->
								<th width="11%">投资期限</th>
								<th width="18%">操作</th>
							</tr>
							<c:choose>
								<c:when test="${empty expage.result}">
									<tr><td colspan="5"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${expage.result}" var="exproduct">
										<tr>
											<td><fmt:formatDate value="${exproduct.createTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<td><fmt:formatNumber value="${exproduct.affectExperienceGold}" pattern="#,##0.00"/>元</td>
											<td><fmt:formatNumber type="number" value="${exproduct.borrowInterestRate*100}" pattern="##0.00" maxFractionDigits="2"/>%</td>
											<%-- <td><c:choose>
											<c:when test="${empty exproduct.proValue||exproduct.type!=2}">----</c:when>
											<c:otherwise>+
											<fmt:formatNumber type="number" value="${exproduct.proValue*100}" pattern="##0.00" maxFractionDigits="1"/>%
											</c:otherwise>
											</c:choose></td> --%>
											<td>${exproduct.investLimit}天</td>
											<td><a href="javascript:queryInvestDetail(${exproduct.productId},'${exproduct.systemTraceNo}');" class="inv_ck">查看</a></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
					<c:choose>
					<c:when test="${empty expage.result}"></c:when>
					<c:otherwise>
					<!-- 分页 -->
						<div class="inves_pg">
							<div class="page_fy">
								<li:pagination methodName="fqueryExperiencePage" pageBean="${expage}" sytleName="page_fy"/>
							</div>
						 </div>
					 </c:otherwise>
					</c:choose>