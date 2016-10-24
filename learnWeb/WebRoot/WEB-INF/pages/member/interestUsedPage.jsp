<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ include file="/static/commonTags.jsp"%>
			 <div class="media_table_cont">
			<table cellpadding="0" cellspacing="0" border="0">
							<tr>
								<th width="20%">名称</th>
								<th width="21%">领取时间</th>
								<th width="24%">使用时间</th>
								<th width="34%">使用项目</th>
							</tr>
							<c:choose>
							    <c:when test="${empty addinterestusedlist.result}">
									<tr><td colspan="5"><div id="tabList_no"></div></td></tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${addinterestusedlist.result}" var="addinterestuse">
											<tr>
												<td align="left">
												<fmt:formatNumber type="number" value="${addinterestuse.proValue*100}" pattern="##0.00" maxFractionDigits="2"/>%
											    <c:if test="${addinterestuse.type==1}">
												现金红包
												</c:if>
												<c:if test="${addinterestuse.type==2}">
												加息券
												</c:if>
												<c:if test="${addinterestuse.type==3}">
												投资红包
												</c:if>
												</td>
												<td><fmt:formatDate value="${addinterestuse.useTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
												<td><fmt:formatDate value="${addinterestuse.updateTime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/></td>
												<td>${addinterestuse.productName}</td>
											</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>
			     </div>
						<!--分页-->
						<c:choose>
							<c:when test="${empty addinterestusedlist.result}"></c:when>
							<c:otherwise>
								<div class="cadCop_pg">
									<div class="page_fy">
										<li:pagination methodName="queryToAssignPage" pageBean="${addinterestusedlist}" sytleName="page_fy"/>
									</div>
						    	</div>
				    		</c:otherwise>
						</c:choose>