<%@ page contentType="text/html;charset=UTF-8"%>
                   <table cellpadding="0" cellspacing="0" border="1">
					<tr>
						<th>时间</th>
						<th>交易</th>
						<th>积分详情</th>
					</tr>
					<c:choose>
						<c:when test="${empty proPage.result}">
						<tr> <td colspan="3"><div id="tabList_no"></div></td></tr>
						</c:when>
						<c:otherwise>
						<c:forEach items="${proPage.result}" var="scorelist">
						<tr>
						<td><fmt:formatDate value="${scorelist.createtime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/><br /></td>
						<td>${scorelist.info}</td>
						<td>
						<c:if test="${scorelist.type==1}"><label>+ ${scorelist.affectscore}</label></c:if><!-- 增加 -->
						<c:if test="${scorelist.type==2}"><span>- ${scorelist.affectscore}</span></c:if><!-- 减少 -->
						</td>
				    	</tr>
					    </c:forEach>
						</c:otherwise>
					</c:choose>
     			    </table>
     			    <div class="inte_pg">
					<!--分页-->
						<div class="page_fy">
							<li:pagination methodName="fqueryPage" pageBean="${proPage}" sytleName="page_fy"/>
						</div>
					 </div>