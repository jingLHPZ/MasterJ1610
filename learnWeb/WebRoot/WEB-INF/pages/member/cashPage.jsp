<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ include file="/static/commonTags.jsp"%>
<div class="media_table_cont">
<table cellpadding="0" cellspacing="0" border="0">
							<tr>
									<th width="23%">红包编码</th>
									<th width="23%">名称</th>
									<th width="23%">金额</th>
									<th width="31%">领取时间</th>
							</tr>
							<c:choose>
								<c:when test="${empty getcashredlist.result}">
									<tr><td colspan="4"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${getcashredlist.result}" var="cashred">
										<tr>
											<td>${cashred.content}</td>
											<td>${cashred.proValue}元
												<c:if test="${cashred.type==1}">
												现金红包
												</c:if>
												<c:if test="${cashred.type==2}">
												加息券
												</c:if>
												<c:if test="${cashred.type==3}">
												投资红包
												</c:if>
											</td>
											<td><fmt:formatNumber value="${cashred.proValue}" pattern="#,##0.00#"/>元</td>
											<td><fmt:formatDate value="${cashred.useTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
	</div>
						<!--分页-->
						<c:choose>
							<c:when test="${empty getcashredlist.result}"></c:when>
							<c:otherwise>
								<div class="cadCop_pg">
									<div class="page_fy">
										<li:pagination methodName="queryCashPage" pageBean="${getcashredlist}" sytleName="page_fy"/>
									</div>
						    	</div>
				    		</c:otherwise>
						</c:choose>
