<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ include file="/static/commonTags.jsp"%>
<div class="media_table_cont">
<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="20%">名称</th>
								<th width="12%">金额</th>
								<th width="21%">领取时间</th>
								<th width="21%">使用时间</th>
								<th width="24%">使用项目</th>
							</tr>
							<c:choose>
								<c:when test="${empty investredusedlist.result}">
									<tr><td colspan="5"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${investredusedlist.result}" var="investredused">
										<tr>
											<td align="left">
										    	<fmt:formatNumber value="${investredused.proValue}" pattern="#,##0.00#"/>元
											    <c:if test="${investredused.type==1}">
												现金红包
												</c:if>
												<c:if test="${investredused.type==2}">
												加息券
												</c:if>
												<c:if test="${investredused.type==3}">
												投资红包
												</c:if>
											</td>
											<td><fmt:formatNumber value="${investredused.proValue}" pattern="#,##0.00#"/>元</td>
											<td><fmt:formatDate value="${investredused.useTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<td><fmt:formatDate value="${investredused.updateTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
											<td>${investredused.productName}</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
	</div>
						<!--分页-->
						<c:choose>
							<c:when test="${empty investredusedlist.result}"></c:when>
							<c:otherwise>
								<div class="cadCop_pg">
									<div class="page_fy">
										<li:pagination methodName="queryInvestPage" pageBean="${investredusedlist}" sytleName="page_fy"/>
									</div>
						    	</div>
				    		</c:otherwise>
						</c:choose>