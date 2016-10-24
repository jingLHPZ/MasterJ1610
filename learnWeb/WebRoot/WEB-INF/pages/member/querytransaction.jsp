<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/commonTags.jsp"%>
<!--查询表格-->
          <div class="media_table_cont">
				<table cellpadding="0" cellspacing="0" border="0" class="tran_table">
					<tr>
						<th width="19%">时间</th>
						<th width="20%">交易类型</th>
						<th width="15%">操作金额(元)</th>
						<th width="15%">可用金额</th>
						<th>说明</th>
					</tr>
					<!--
                    	作者：xgh_web@126.com
                    	时间：2015-09-10
                    	描述：操作金额为正数的时候给span添加class=“font_red”
                    		操作金额为负数的时候给span添加class=“font_ger”
                    -->
					<c:choose>
						<c:when test="${empty proPage.result}">
						<tr><td colspan="5"><div id="tabList_no"></div></td></tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${proPage.result}" var="list">
								<tr>
									<td><div><fmt:formatDate value="${list.createTime}" type="both" pattern='yyyy-MM-dd'/><br /><span><fmt:formatDate value="${list.createTime}" type="both" pattern='HH:mm:ss'/></span></div></td>
									<td>
									<c:forEach items="${codedesclist}" var="itemBean">
									 <c:if test="${itemBean.code == list.type}">${itemBean.description_zh}</c:if>
									</c:forEach>
								    </td>
									<td>
									 <c:if test="${fn:startsWith(list.showAffectMoney,'+')}"><span class="font_red"><fmt:formatNumber value="${list.showAffectMoney}" pattern="+,##0.00#"/></span></c:if>
									 <c:if test="${fn:startsWith(list.showAffectMoney,'-')}"><span class="font_ger"><fmt:formatNumber value="${list.showAffectMoney}" pattern="#,##0.00#"/></span></c:if>
									 <c:if test="${fn:startsWith(list.showAffectMoney,'*')}"><span><fmt:formatNumber value="${list.affectMoney}" pattern="#,##0.00#"/></span></c:if>
									</td>
									<td><fmt:formatNumber value="${list.availableMoney}" pattern="#,##0.00#"/></td>
									<td title="${list.info}" class="remarks">${list.info}</td>
										<!--<td><span>0.00</span></td>-->
							   </tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
	        </div>
				<!-- 分页 -->
				<c:choose>
					<c:when test="${not empty proPage.result}">
						 <div class="tran_pg">
							<div class="page_fy">
							   <li:pagination methodName="fqueryPage" pageBean="${proPage}" sytleName="page_fy"/>
				            </div>
						</div>
					</c:when>
				</c:choose>
