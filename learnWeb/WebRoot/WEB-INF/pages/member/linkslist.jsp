<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/commonTags.jsp"%>
          <div class="media_table_cont">
                  <table cellpadding="0" cellspacing="0" border="0">
						<tr>
							<th width="50%">用户账号</th>
							<!-- <th width="100">姓名</th> -->
							<th width="50%">创建时间</th>
							<!-- <th width="150">用户类型</th>
							<th>奖励</th> -->
						</tr>
						<c:choose>
						<c:when test="${empty proPage.result}">
						<tr> <td colspan="3"><div id="tabList_no"></div></td></tr>
						</c:when>
						<c:otherwise>
						<c:forEach items="${proPage.result}" var="inviterecord">
						<tr>
						<td>${inviterecord.mobilephone2}</td>
						<td><fmt:formatDate value="${inviterecord.createtime}" type="both" pattern='yyyy-MM-dd HH:mm:ss'/><br /></td>
				    	</tr>
					    </c:forEach>
						</c:otherwise>
					</c:choose>
				 </table>
			 </div>
					<c:choose>
					  <c:when test="${empty proPage.result}"></c:when>
					  <c:otherwise>
						<div class="links_pg">
						<!--分页-->
							<div class="page_fy">
								<li:pagination methodName="fqueryPage" pageBean="${proPage}" sytleName="page_fy"/>
							</div>
						 </div>
					 </c:otherwise>
					 </c:choose>
